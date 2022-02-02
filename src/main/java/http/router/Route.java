package http.router;

import http.helper.Handler;

import java.util.*;

public class Route {
private Map<String, Handler> methodHandlers = new HashMap<>();


public Map<String,Handler> getAllHandlers (){
    return methodHandlers;
}

public Route addHandler (String methodVerb, Handler handler){
     methodHandlers.putIfAbsent(methodVerb,handler);
     return this;
}

public Handler getHandler (String methodVerb) {
 return methodHandlers.containsKey(methodVerb) ? methodHandlers.get(methodVerb) : null;
}
}
