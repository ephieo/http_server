import http.response.BuildResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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

        assertArrayEquals(build.parseHeaderLine(headerKey,headerValue),"Age : 7777\n\r".getBytes());

    }
    @Test
    public void checkThatHeadersLineIsReturned (){
        BuildResponse build = new BuildResponse();

    }
}
