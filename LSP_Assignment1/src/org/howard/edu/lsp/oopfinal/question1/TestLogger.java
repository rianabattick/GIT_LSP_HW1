package org.howard.edu.lsp.oopfinal;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLogger {

    @Test
    public void testDisplayLog() {
        Logger logger = Logger.getInstance();
        logger.logMessage("Test message");
        String expectedOutput = "Log:\nTest message\n";
        assertEquals("The displayLog output is not as expected.", expectedOutput, logger.displayLog());
    }
}
