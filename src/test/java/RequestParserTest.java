import http.request.Request;
import http.request.RequestParser;
import org.junit.jupiter.api.Test;


import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParserTest {

    @Test
    public void parseRequestData() throws IOException {
        String readerString = "GET /hello HTTP/1.1";
        ByteArrayInputStream input = new ByteArrayInputStream(readerString.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        RequestParser requestRouter = new RequestParser(reader);
        Request request = requestRouter.buildRequest();

        assertEquals(request.getMethod(),"GET" );
        assertEquals(request.getPath(),"/hello" );
        assertEquals(request.getProtocol(),"HTTP/1.1" );
    }

    @Test
    public void checkThatRequestIsBuilt () throws IOException {
        String readerString = "GET /hello HTTP/1.1";
        ByteArrayInputStream input = new ByteArrayInputStream(readerString.getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        RequestParser requestRouter = new RequestParser(reader);
        Request request = requestRouter.buildRequest();


        assertEquals(request.getMethod(),"GET");
    }

}
