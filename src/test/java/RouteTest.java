import http.helper.Handler;

import org.junit.jupiter.api.Test;
import http.router.Route;



import static org.junit.jupiter.api.Assertions.*;

public class RouteTest {

@Test
public void checkThatMethodsAreStored() {
    Route route = new Route();

    Handler handler = ((request, response)->{});
    route.addHandler("GET",handler);

    assertTrue(route.getAllHandlers().containsKey("GET"));
    assertEquals(route.getHandler("GET"),handler);
}


}
