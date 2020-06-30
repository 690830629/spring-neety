package com.wanglei.tomcat;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

@Data
public class GPRequest {

    private String method;
    private String url;

    private InputStream inputStream;

    public GPRequest(InputStream in) throws IOException {
        // 拿到http协议内容
        String content = "";
        byte[] buff = new byte[1024];
        int len = 0;
        if ((len = in.read(buff)) > 0) {
            content = new String(buff, 0, len);
            System.out.println(content);
        }
        String line = content.split("\\n")[0];
        String[] arr = line.split("\\s");
        this.method = arr[0];
        this.url = arr[1].split("\\?")[0];
    }

    public String getUrl() {
        return "";
    }

    public String getMethod() {
        return "";
    }
}
