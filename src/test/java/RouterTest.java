import http.helper.Handler;

import http.request.Request;
import http.request.RequestParser;
import http.router.Router;


import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String readerString = "GET /hello HTTP/1.1";
        ByteArrayInputStream input = new ByteArrayInputStream(readerString.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        RequestParser requestRouter = new RequestParser(reader);
        Request request = requestRouter.buildRequest();

        System.out.println(router.fetchHandler(request));
        assertTrue(router.fetchHandler(request) != null);



    }

}
