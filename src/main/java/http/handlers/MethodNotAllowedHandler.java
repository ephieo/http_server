package http.handlers;

import http.helper.Handler;

public interface MethodNotAllowedHandler {
    static Handler getHandler (){
        return ((request,response)->{
            response.setStatus(405,"Method Not Allowed");
            response.addHeaders("Content-Type", "text/html");
            response.setBody("".getBytes());
            
        });
    }
}
