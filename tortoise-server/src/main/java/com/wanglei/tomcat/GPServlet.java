package com.wanglei.tomcat;

public abstract class GPServlet {

    public void service(GPRequest request, GPResponse response) {
        if ("GET".equals(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    protected abstract void doPost(GPRequest request, GPResponse response);

    protected abstract void doGet(GPRequest request, GPResponse response);

}
