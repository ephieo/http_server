package http.router;


import http.helper.Handler;
import http.helper.Messages;
import http.helper.Utils;
import http.request.Request;
import http.response.Response;

import java.io.*;
import java.net.Socket;
import java.util.*;

import static http.request.RequestParser.*;

public class Router {
 private Map<String, Route> routes = new HashMap<>();

 public Map<String, Route> getRoutes(){
     return routes;
 }

 public void makeRouterRequest (Socket clientSocket) throws IOException {
     OutputStream output = clientSocket.getOutputStream();
     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
     Response response = new Response(output);

     try{
         String[] parsedRequest = parseRequest(reader.readLine());
         System.out.println(parsedRequest[0]+parsedRequest[1]+parsedRequest[2]);
         Request request = buildRequest(parsedRequest[0],parsedRequest[1],parsedRequest[2]);
         requestReader(reader);
         Handler handler = fetchHandler(request);
         handler.setResponseValues(request,response);
     }catch(Error err){
         System.out.println(err);
     }


     response.sendResponse();


 }


 public Route addRoute(String path, String method, Handler handler){
     Route route = routes.computeIfAbsent(path, (key) -> new Route());
     route.addHandler(method,handler);
     return route;
 }


 public Handler fetchHandler (Request request){
     Route route = routes.get(request.getPath());
     return  route != null ? route.getHandler(request.getMethod()) : null;
 }



}
