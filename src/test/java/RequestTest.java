import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static http.request.RequestHandler.requestReader;
import static http.request.RequestHandler.sendResponse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestTest {




    @Test
    public void inputSentToClient () {
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();

        sendResponse(mockOutput);

        assertArrayEquals("status: 200 OK\n".getBytes(), mockOutput.toByteArray());
    }

    @Test
    public void RequestDataIsRead () throws IOException {
        ByteArrayInputStream mockInput = new ByteArrayInputStream("done".getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        requestReader(mockInput);

        assertEquals("http.Server received : done\ndone", outContent.toString().trim());
    }
}
