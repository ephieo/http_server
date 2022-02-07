import http.helper.Handler;

import http.response.Response;
import http.router.Router;
import http.router.SetupRouter;
import org.junit.jupiter.api.Test;

import http.router.Route;


import java.io.ByteArrayOutputStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RouteTest {
    Route route = new Route();


    @Test
    public void checkThatMethodsAreStored() {
        Handler handler = ((request, response) -> {
        });
        route.addHandler("GET", handler);

        assertTrue(route.getAllHandlers().containsKey("GET"));
        assertEquals(route.getHandler("GET"), handler);
    }

    @Test
    public void checkThatDefaultHandlersAreStored() {
        route.createDefaultHandlers();

        Set<String> methods = route.getAllHandlers().keySet();

        assertTrue(methods.contains("OPTIONS"));
        assertTrue(methods.contains("HEAD"));
        assertTrue(methods.contains("POST"));
        assertTrue(methods.contains("PUT"));
    }

}
