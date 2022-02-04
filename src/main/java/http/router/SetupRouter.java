package http.router;



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
        router.addRoute("/simple_get_with_body", "GET",((request, response) -> {
            response.setStatus(200,"OK");
            response.setBody("Hello world".getBytes());
            response.addHeaders("Content-Type","text/html");

        }));
        router.addRoute("/redirect", "GET",((request, response) -> {
            response.setStatus(301,"OK");
            response.setBody("".getBytes());
            response.addHeaders("Location","http://0.0.0.0:5000/simple_get");

        }));

        return router;
    }

}
