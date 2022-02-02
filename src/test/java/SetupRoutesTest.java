


import http.router.Router;
import http.router.SetupRouter;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetupRoutesTest {
    @Test
    public void checkThatRoutesAreSetup (){
        Router router = SetupRouter.setupRouter();
        Set<String> routes = router.getRoutes().keySet();

        assertTrue(routes.contains("/"));
        assertTrue(routes.contains("/simple_get"));

    }
}
