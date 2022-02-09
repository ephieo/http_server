package http.handlers;

import http.helper.Handler;

public interface PageNotFoundHandler {
    static Handler getHandler (){
        return ((request,response)->{
            response.setStatus(404,"Not Found");
            response.setBody("".getBytes());
        });
    }
}
