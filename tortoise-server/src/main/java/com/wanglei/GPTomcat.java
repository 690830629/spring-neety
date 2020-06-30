package com.wanglei;

public class GPTomcat {
    // javaee标准
    // servlet
    // Request
    // Response

    // 配置好启动端口 默认8080 ServerSocket IP localhost
    // 配置web.xml 自己写的servlet继承httpServlet
    // servlet-name
    // servlet-class
    // url-pattern
    // 读取配置 url-pattern 和servlet建立一个映射关系
    // Map servletMapping
    // HTTP 请求 发送的数据就是字符串 有规律的字符串（HTTP协议）
    // 从协议中拿到url 把相应的servlet用发射进行实例化
    // 调用实例化对象的service()方法 执行具体的逻辑doGet/doPost方法
    // Request(InputStream)/Response(OutputStream)
}
