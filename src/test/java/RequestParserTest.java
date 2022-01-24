import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static http.request.RequestParser.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParserTest {


    @Test
    public void checkThatAStartLineDataIsSet() {
        setRequestType("GET / HTTP/1.1");

        assertEquals(getRequestType(), "GET / HTTP/1.1".trim());

    }

    @Test
    public void checkThatHeadersAreSet() {
        setHeaders("text/html");

        assertEquals(getHeaders(), headers);

    }

    @Test
    public void checkThatRequestBodyWasSet() {
        setRequestBody("hello".getBytes());

        assertEquals(getRequestBody(), "hello");

    }

    @Test
    public void checkThatStatusIsUpdated() {
        setStatus("200", "well done :)");

        assertEquals(getStatusCode(), "200");
        assertEquals(getStatusMessage(), "well done :)");
    }

    @Test
    public void checkThatFormattedResponseIsReturned() {
        setRequestType("GET / HTTP/1.1");
        setHeaders("text/html");
        System.out.println(requestBody + "*****************");
        setRequestBody("hello".getBytes(StandardCharsets.UTF_8));
        setStatus("200", "well done :)");
        System.out.println(requestBody + "*****************");

        String fakeFormattedRequest = "GET / HTTP/1.1" + "\n"
                + "Content-Type: " + "text/html" + "\n"
                + "Content-Length: " + "11" + "\n"
                + "Body{ " + "\n" + "hello" + "\n" + "}";

        assertEquals(formatRequestBody(), fakeFormattedRequest);
    }

}
