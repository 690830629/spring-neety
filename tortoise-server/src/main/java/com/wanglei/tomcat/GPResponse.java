package com.wanglei.tomcat;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;

@Data
public class GPResponse {

    private OutputStream out;

    public GPResponse(OutputStream out) {
        this.out = out;
    }

    public void write(String s) throws IOException {
        // http协议 输出也要遵循http协议
        // 给到一个状态码
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK \n")
                .append("Content-Type:text/html;\n")
                .append(s)
                .append("\r\n");

        out.write(sb.toString().getBytes());

    }
}
