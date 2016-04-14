package com.icvr.application;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Properties;
import static org.junit.Assert.*;

/**
 * Tests for Service class.
 */



public class ServiceTest {
    private final Logger log = Logger.getLogger(this.getClass());
    Properties properties;
    CVR cvr;
    Service s;

    @Before
    public void setUp() throws Exception {
        this.cvr = new CVR();
    }

    @Test
    public void testOutputPlainMessage() throws Exception {
        s = new Service();
        String user_input = "cvr demo";
        s.outputPlainMessage("demo");

        /*
        Service s = new Service();
        String userInput = "cvr";
        String processed_input = s.processUserInput(userInput);
        log.info(processed_input);
        assertEquals(processed_input, "Cockpit Voice Recorder");
*/
    }

    @Test
    public void testOutputHTMLMessage() throws Exception {

    }

    @Test
    public void testOutputJSONMessage() throws Exception {

    }
}