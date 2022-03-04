import http.handlers.PageNotFoundHandler;
import http.helper.Handler;
import http.request.Request;
import http.response.Response;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageNotFoundHandlerTest {

    @Test
    public void checkThatPageNotFoundHandlerReadsStatusCode() {

        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        Request request = new Request();
        Response response = new Response(mockOutput);

        Handler handler = PageNotFoundHandler.getHandler();
        handler.setResponseValues(request, response);

        assertEquals(response.getStatusCode(), 404);

    }
}






