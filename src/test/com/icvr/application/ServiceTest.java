package com.icvr.application;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


import javax.servlet.ServletContext;
import javax.ws.rs.PathParam;
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

    @Context
    ServletContext context;
    //Service s =  new Service();


    /*  private String processUserInput(String userInput) */

    /*

    public String outputPlainMessage(@PathParam("param") String userInput) {
        return processUserInput(userInput);
    }

    */


    @Before
    public void setUp() throws Exception {
        //Service s = new Service();
    }

    @Test
    public void testOutputPlainMessage() throws Exception {
        Service s = new Service();
        String user_input = "cvr demo";
        s.outputPlainMessage(user_input);

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