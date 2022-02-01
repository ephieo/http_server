import http.request.Request;
import http.request.RequestParser;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParserTest {

    @Test
    public void parseRequestData() {
        RequestParser requestRouter = new RequestParser();
        String requestData = "GET /hello HTTP/1.1";

        String[] splitData = requestRouter.parseRequest(requestData);

        assertEquals(splitData[0],"GET" );
        assertEquals(splitData[1],"/hello" );
        assertEquals(splitData[2],"HTTP/1.1" );
    }

    @Test
    public void checkThatRequestIsBuilt (){
        RequestParser requestParser = new RequestParser();
        String[] requestData = {"GET", "/hello", "HTTP/1.1"};

        Request request = requestParser.buildRequest(requestData[0],requestData[1],requestData[2]);

        assertEquals(request.getMethod(),"GET");
    }

}
