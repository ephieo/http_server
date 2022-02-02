import http.helper.Handler;

import http.request.Request;
import http.router.Router;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static http.request.RequestParser.*;
import static org.junit.jupiter.api.Assertions.*;

public class RouterTest {

    @Test
    public void checkThatRouteExists (){
        Router router = new Router();
        Handler handler = ((request,response)->{});
        router.addRoute("/simple_get","GET", handler);


        assertTrue(router.getRoutes().containsKey("/simple_get"));

    }

    @Test
    public void checkThatHandlerIsRetrieved() throws IOException {
        Router router = new Router();
        String[] parsedRequest = parseRequest("GET /hello HTTP/1.1");
        Request request = buildRequest(parsedRequest[0],parsedRequest[1],parsedRequest[2]);

        System.out.println(router.fetchHandler(request));
        assertTrue(router.fetchHandler(request) != null);



    }

}
