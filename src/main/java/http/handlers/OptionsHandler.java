package http.handlers;

import http.helper.Handler;
import http.helper.Utils;

import java.util.*;
import java.util.stream.Collectors;

public interface OptionsHandler {
    static Handler getHandler(Set<String> methods) {
        return ((request, response) -> {
            response.setStatus(200,"No Content");
            response.addHeaders("Content-Type","text/html");
            response.addHeaders("Allow",createOptionsHeader(methods));
            response.setBody("".getBytes());
        });
    }

    static String createOptionsHeader(Set<String> methods) {
        ArrayList<String> methodsList = new ArrayList<>(methods);
        Collections.sort(methodsList);
        return String.join(", ",methodsList);

    }
}
