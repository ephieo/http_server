import http.response.Response;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;





public class ResponseTest {
    @Test
    public void checksIfResponseValuesAreSetAndReturned (){
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        Response response = new Response(mockOutput);
        response.setStatus(1234,"hello");
        response.setHeaders("Content-Type","text");
        response.setBody("world".getBytes());



        assertEquals(response.getStatusMessage(),"hello");
        assertEquals(response.getStatusCode(),1234);
        assertEquals(response.getHeaders().get("Content-Length"),"5");
        assertEquals(response.getHeaders().get("Content-Type"),"text");
        assertArrayEquals(response.getBody(),"world".getBytes());

    }
}
