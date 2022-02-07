package http.router;


import http.handlers.HeadHandler;

public class SetupRouter {

    public static Router setupRouter (){
        Router router = new Router();

        router.addRoute("/", "GET",((request, response) -> {
            response.setStatus(200,"OK");
        }));

        router.addRoute("/simple_get", "GET",((request, response) -> {
          response.setStatus(200,"OK");
          response.setBody("".getBytes());
          response.addHeaders("Content-Type","text/html");

        }));

        router.addRoute("/simple_get","HEAD", HeadHandler.getHandler());


        router.addRoute("/simple_get_with_body", "GET",((request, response) -> {
            response.setStatus(200,"OK");
            response.setBody("Hello world".getBytes());
            response.addHeaders("Content-Type","text/html");

        }));

        router.addRoute("/redirect", "GET",((request, response) -> {
            response.setStatus(301,"OK");
            response.setBody("".getBytes());
            response.addHeaders("Location","http://127.0.0.1:5000/simple_get");

        }));

        router.addRoute("/method_options","GET", ((request,response)->{}));

        return router;
    }

}
