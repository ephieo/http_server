import http.handlers.MethodNotAllowedHandler;
import http.helper.Handler;
import http.request.Request;
import http.response.Response;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MethodNotAllowedHandlerTest {
    @Test
    public void checkThatMethodNotAllowedHandlerHasCorrectStatusCode() {

        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        Request request = new Request();
        Response response = new Response(mockOutput);

        Handler handler = MethodNotAllowedHandler.getHandler();
        handler.setResponseValues(request, response);

        assertEquals(response.getStatusCode(), 405);

    }
}
