import http.request.Request;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import static http.request.RequestRouter.requestReader;
import static http.request.RequestRouter.sendResponse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {




    @Test
    public void inputSentToClient () throws IOException {
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();

        sendResponse(mockOutput);

        assertArrayEquals("status: 200 OK\n".getBytes(), mockOutput.toByteArray());
    }

    @Test
    public void RequestDataIsRead () throws IOException {
        ByteArrayInputStream mockInput = new ByteArrayInputStream("done".getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        requestReader(mockInput);

        assertEquals("http.Server received : done\ndone", output.toString().trim());
    }
    @Test
    public void checkThatRequestClassValuesAreAssigned (){
        ByteArrayInputStream mockInput = new ByteArrayInputStream("hello".getBytes());
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
