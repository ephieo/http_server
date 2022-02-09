

import http.handlers.RouteNotFound;
import http.helper.Handler;
import http.request.Request;

import http.response.Response;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;

//import static http.request.RequestParser.buildRequest;
import static org.junit.jupiter.api.Assertions.*;

//public class RouteNotFoundTest {
//    @Test
//    public void checkThatErrorIs404 (){
//        String[] requestLine = "GET /invalid_path HTTP/1.1".split(" ");
//        Request request = buildRequest(requestLine[0],requestLine[1],requestLine[2]);
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        Response response = new Response(output);
//        Handler handler = RouteNotFound.getHandler();
//        handler.setResponseValues(request,response);
//
//        assertEquals(response.getStatusCode(), 404);
//
//    }
//}
