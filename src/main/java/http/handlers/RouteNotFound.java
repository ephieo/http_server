package http.handlers;

import http.helper.Handler;



public interface RouteNotFound {
    static Handler getHandler (){
        return ((request,response)->{
            response.setStatus(404,"Not Found");
            response.setBody("".getBytes());
            response.addHeaders("","");
        });
    }
}
