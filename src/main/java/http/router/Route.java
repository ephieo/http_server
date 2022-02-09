package http.router;

import http.handlers.HeadHandler;
import http.handlers.MethodNotAllowedHandler;
import http.handlers.OptionsHandler;
import http.handlers.RouteNotFound;
import http.helper.Handler;

import java.security.cert.CRLException;
import java.util.*;

public class Route {
    private Map<String, Handler> methodHandlers = new HashMap<>();


    public Map<String, Handler> getAllHandlers() {
        return methodHandlers;
    }

    public Route addHandler(String methodVerb, Handler handler) {
        methodHandlers.putIfAbsent(methodVerb, handler);
        createDefaultHandlers();
        return this;
    }

    public Handler getHandler(String methodVerb) {
        createDefaultHandlers();
        return methodHandlers.containsKey(methodVerb) ? methodHandlers.get(methodVerb) : MethodNotAllowedHandler.getHandler();
    }





    public void createDefaultHandlers() {
        methodHandlers.putIfAbsent("OPTIONS", OptionsHandler.getHandler(methodHandlers.keySet()));
        methodHandlers.putIfAbsent("HEAD", HeadHandler.getHandler());
    }
}





