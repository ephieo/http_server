import http.request.Request;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import static http.request.RequestRouter.requestReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {



    @Test
    public void RequestDataIsRead () throws IOException {
        ByteArrayInputStream mockInput = new ByteArrayInputStream("done\noutput read".getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        requestReader(mockInput);

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
