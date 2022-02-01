import http.request.Request;
import org.junit.jupiter.api.Test;

import java.io.*;


import static http.request.RequestParser.requestReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {



    @Test
    public void RequestDataIsRead () throws IOException {
        ByteArrayInputStream mockInput = new ByteArrayInputStream("done\noutput read".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(mockInput));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        requestReader(reader);

        assertEquals("http.Server received : done\noutput read", output.toString().trim());
    }
    @Test
    public void checkThatRequestClassValuesAreAssigned (){
        Request request = new Request();
        request.setMethod("GET");
        request.setPath("/hello");
        request.setHeaders("Content-Length","11");
        request.setBody("hello");


        assertEquals(request.getMethod(),"GET");
        assertEquals(request.getPath(),"/hello");
        assertEquals(request.getHeaders().get("Content-Length"),"11");
        assertEquals(request.getBody(),"hello");

    }
}
