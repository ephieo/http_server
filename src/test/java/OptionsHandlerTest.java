import http.handlers.HeadHandler;
import http.handlers.OptionsHandler;
import http.helper.Handler;
import http.request.Request;
import http.response.Response;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsHandlerTest {

    @Test
    public void checkThatHeadHandlerReadsContentLength() {

        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        Request request = new Request();
        Response response = new Response(mockOutput);

        Map <String,String> methods = new HashMap<>();
        methods.put("GET","string");
        methods.put("POST","string");
        methods.put("PUT","string");
        methods.put("OPTIONS","string");
        methods.put("HEAD","string");


        Handler handler = OptionsHandler.getHandler(methods.keySet());
        handler.setResponseValues(request, response);

        assertEquals(response.getStatusCode(), 200);

    }
}
