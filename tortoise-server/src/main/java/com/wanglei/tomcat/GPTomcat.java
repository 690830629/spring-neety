package com.wanglei.tomcat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPTomcat {
    // 打开tomcat源码 全局搜索servletSocket

    private int port = 8080;

    private Map<String, GPServlet> servletMapping = new HashMap<>();

    private Properties webxml = new Properties();

    private void init() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String WEB_INF = this.getClass().getResource("/").getAuthority();
        FileInputStream fis = new FileInputStream(WEB_INF + "web.properties");
        webxml.load(fis);
        for (Object k : webxml.keySet()) {
            String key = k.toString();
            if (key.endsWith(".url")) {
                String servletName = key.replaceAll("\\.url$", "");
                String url = webxml.getProperty(key);
                String className = webxml.getProperty(servletName);
                // 单实例 多线程
                GPServlet obj = (GPServlet) Class.forName(className).newInstance();
                servletMapping.put(url, obj);

            }
        }


    }

    public void start() throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        init();

        // Netty封装了NIO Reactor模型 Boss worker
        // ServletBootstrap   ServerSocketChannel
        ServerSocket server = new ServerSocket(this.port);
        System.out.println("已启动");
        // tomcat源码就是死循环
        while (true) {
            Socket client = server.accept();
            process(client);
        }
    }


    private void process(Socket client) throws IOException {
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        GPRequest request = new GPRequest(inputStream);
        GPResponse response = new GPResponse(outputStream);
        String url = request.getUrl();

        outputStream.flush();
        outputStream.close();
        inputStream.close();
        client.close();
    }

    public static void main(String[] args) {

    }
}
