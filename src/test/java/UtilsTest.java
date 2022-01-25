import http.helper.Utils;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class UtilsTest{

    @Test
    public void printsTextToTerminal (){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Utils.print("hello world !");

        assertEquals("hello world !", outContent.toString().trim());
    }
}

