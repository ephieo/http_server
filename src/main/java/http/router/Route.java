package http.router;

import http.handlers.HeadHandler;
import http.handlers.RouteNotFound;
import http.helper.Handler;

import java.util.*;

public class Route {
private Map<String, Handler> methodHandlers = new HashMap<>();


public Map<String,Handler> getAllHandlers (){
    return methodHandlers;
}

public Route addHandler (String methodVerb, Handler handler){
     methodHandlers.putIfAbsent(methodVerb,handler);
     createDefaultHandlers();
     return this;
}

public Handler getHandler (String methodVerb) {
 return methodHandlers.containsKey(methodVerb) ? methodHandlers.get(methodVerb) : RouteNotFound.getHandler();
}

public void createDefaultHandlers (){
    methodHandlers.putIfAbsent("OPTIONS",((request,response)->{}));
    methodHandlers.putIfAbsent("HEAD", HeadHandler.getHandler());
    methodHandlers.putIfAbsent("POST",((request,response)->{}));
    methodHandlers.putIfAbsent("PUT",((request,response)->{}));

}
}


