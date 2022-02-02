import http.helper.Utils;
import http.response.BuildResponse;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildResponseTest {
    @Test
    public void checkThatStartLineIsReturned (){
        BuildResponse build = new BuildResponse();
        int statusCode = 200;
        String statusMessage = "OK";
        String protocol = "HTTP/1.1";

        assertArrayEquals(build.buildStartLine(protocol,statusCode,statusMessage),"HTTP/1.1 200 OK\n\r".getBytes());


    }

    @Test
    public void checkThatHeadersLineIsParsed (){
        BuildResponse build = new BuildResponse();
        String headerKey = "Age";
        String headerValue = "7777";

        assertEquals(build.parseHeaderLine(headerKey,headerValue),"Age : 7777\n\r");

    }
    @Test
    public void checkThatHeadersLineIsReturned () throws UnsupportedEncodingException {
        BuildResponse build = new BuildResponse();
        Map<String,String> headers = new HashMap<>();
        headers.put("Content-Type","text/html");
        headers.put("Age","7777");
        headers.put("Connection","Kept-Alive");

        byte[] formattedHeader = ("Connection : Kept-Alive\n\r" + "Age : 7777\n\r" + "Content-Type : text/html\n\r").getBytes();

        assertArrayEquals(build.buildHeaderLine(headers), formattedHeader);


    }
}
