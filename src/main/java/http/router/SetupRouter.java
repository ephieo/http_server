package http.router;



public class SetupRouter {

    public static Router setupRouter (){
        Router router = new Router();

        router.addRoute("/", "GET",((request, response) -> {}));

        router.addRoute("/simple_get", "GET",((request, response) -> {
          response.setStatus(200,"OK");
          response.setBody("".getBytes());
          response.addHeaders("Content-Type","text/html");

        }));

        return router;
    }

}
