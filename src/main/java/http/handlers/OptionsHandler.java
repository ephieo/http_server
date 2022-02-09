package http.handlers;

import http.helper.Handler;


import java.util.*;


public interface OptionsHandler {
    static Handler getHandler(Set<String> methods) {
        return ((request, response) -> {
            response.setStatus(200,"No Content");
            response.addHeaders("Content-Type","text/html");
            response.addHeaders("Allow",createOptionsHeader(methods));
            response.setBody("".getBytes());
        });
    }

    private static String createOptionsHeader(Set<String> methods) {
        ArrayList<String> methodsList = new ArrayList<>(methods);
        return String.join(", ",methodsList);

    }
}
