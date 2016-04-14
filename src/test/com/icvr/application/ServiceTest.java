package com.icvr.application;

import org.apache.log4j.Logger;
import org.junit.Test;
import javax.servlet.ServletContext;
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
    Service service;

    @Context ServletContext context;

    @Test
    public void setUp() throws Exception {}

    @Test
    public void testOutputPlainMessage() throws Exception {
        String userInput = "cvr";
        String processed_input = service.processUserInput(userInput);
        log.info(processed_input);
        assertEquals(processed_input, "Cockpit Voice Recorder");
    }

    @Test
    public void testOutputHTMLMessage() throws Exception {
        String userInput = "cvr";
        String processed_input = service.processUserInput(userInput);
        log.info(processed_input);
        assertEquals(processed_input, "Cockpit Voice Recorder");

    }

    @Test
    public void testOutputJSONMessage() throws Exception {
        String userInput = "cvr";
        String processed_input = service.processUserInput(userInput);
        log.info(processed_input);
        assertEquals(processed_input, "Cockpit Voice Recorder");
    }
}