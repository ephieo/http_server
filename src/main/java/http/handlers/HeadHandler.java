package http.handlers;

import http.helper.Handler;

public interface HeadHandler {

    static Handler getHandler() {
        return ((request, response) -> {
            response.setStatus(200, "OK");
            response.addHeaders("Content-Type", "text/html");
        });
    }
}
