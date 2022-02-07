


import http.handlers.HeadHandler;
import http.helper.Handler;
import http.helper.Utils;
import http.request.Request;
import http.response.Response;
import http.router.Router;
import http.router.SetupRouter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SetupRoutesTest {

    Router router = SetupRouter.setupRouter();
    ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
    Set<String> routes = router.getRoutes().keySet();
    Request request = new Request();
    Response response = new Response(mockOutput);

    private int getResponseStatusCode (){
        return response.getStatusCode();
    }
    private String getResponseStatusMessage (){
        return response.getStatusMessage();
    }
    private byte[] getResponseBody (){
        return response.getBody();
    }
    private Map<String,String> getResponseHeaders (){
        return response.getHeaders();
    }

    //Test for "/" route :

    @Test
    public void checkThatHomeRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/").getHandler("GET");
        handler.setResponseValues(request,response);



        assertTrue(routes.contains("/"));
        assertEquals(getResponseStatusCode(),200);
        assertEquals(getResponseStatusMessage(),"OK");
        assertEquals(getResponseBody(),null);
        assertEquals(getResponseHeaders(),new HashMap<>());


    }

    //Test for "/redirect" route :

    @Test
    public void checkThatRedirectRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/redirect").getHandler("GET");
        handler.setResponseValues(request,response);

        Map<String,String> headers = new HashMap<>();
        headers.put("Location","http://127.0.0.1:5000/simple_get");
        headers.put("Content-Length","0");


        assertTrue(routes.contains("/redirect"));
        assertEquals(getResponseStatusCode(),301);
        assertArrayEquals(getResponseBody(),"".getBytes());
        assertEquals(getResponseHeaders(),headers);


    }

    //Test for "/simple_get" route :

    @Test
    public void checkThatSimpleGetRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/simple_get").getHandler("GET");
        handler.setResponseValues(request,response);

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","text/html");
        headers.put("Content-Length","0");


        assertTrue(routes.contains("/simple_get"));
        assertEquals(getResponseStatusCode(),200);
        assertArrayEquals(getResponseBody(),"".getBytes());
        assertEquals(getResponseHeaders(),headers);


    }

    //Test for "simple_get_with_body rooute
    @Test
    public void checkThatSimpleGetWithBodyRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/simple_get_with_body").getHandler("GET");
        handler.setResponseValues(request,response);

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","text/html");
        headers.put("Content-Length","11");


        assertTrue(routes.contains("/simple_get_with_body"));
        assertEquals(getResponseStatusCode(),200);
        assertArrayEquals(getResponseBody(),"Hello world".getBytes());
        assertEquals(getResponseHeaders(),headers);


    }

    //Test for "simple_get" route with HEAD method

    @Test
    public void checkThatHeadRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/simple_get").getHandler("HEAD");
        handler.setResponseValues(request,response);

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","text/html");


        assertTrue(routes.contains("/simple_get"));
        assertEquals(getResponseStatusCode(),200);
        assertEquals(getResponseHeaders(),headers);


    }

    //Test for /method_options route

    @Test
    public void checkThatOptionsRouteIsSetupCorrectly (){

        Handler handler = router.getRoutes().get("/method_options").getHandler("OPTIONS");
        handler.setResponseValues(request,response);

        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","text/html");
        headers.put("Content-Length", "0");
        headers.put("Allow","GET, HEAD, OPTIONS, POST, PUT");


        assertTrue(routes.contains("/method_options"));
        assertEquals(getResponseStatusCode(),200);
        assertEquals(getResponseHeaders(),headers);


    }




}
