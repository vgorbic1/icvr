package com.icvr.application;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.Properties;

/**
 * Tests for CVR class.
 */
public class CVRTest {
    private final Logger log = Logger.getLogger(this.getClass());
    Properties properties;
    CVR cvr;

    @Before
    public void setUp() throws Exception {
        loadProperties("/cvr.properties");
        cvr = new CVR(properties);
    }

    @Test
    public void testProcessString() throws Exception {
        String string = "equipment's, test. pan-pan";
        string = cvr.processString(string);
        assertEquals(string, "airplane's, test. urgency signal");
    }

    @Test
    public void testCreateTokens() throws Exception {
        String [] tokenList = cvr.createTokens("test, test.");
        assertEquals(tokenList.length, 3);
    }

    @Test
    public void testCheckToken() throws Exception {
        String translatedToken = cvr.checkToken("equipment");
        assertEquals(translatedToken, "airplane");
    }

    /**
     * The method loads properties from the properties file.
     * @param propertiesFilePath path to properties file.
     * @exception IOException
     * @exception Exception
     */
    public void loadProperties(String propertiesFilePath) {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch(IOException ioException) {
            ioException.printStackTrace();
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}