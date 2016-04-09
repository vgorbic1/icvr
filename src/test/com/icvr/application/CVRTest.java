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

    public void testProcessString() throws Exception {

    }

    public void testCreateTokens() throws Exception {

    }

    public void testCheckToken() throws Exception {

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