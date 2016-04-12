package com.icvr.application;

import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * iCVR Main Class
 */
public class CVR {

    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;

    /**
     * Empty Constructor
     */
    public CVR() {}

    /**
     * Constructor, when given a properties file loads properties file into the CVR class.
     * @param properties Properties file containing words and translations.
     */
    public CVR(Properties properties) {
        this();
        this.properties = properties;
    }

    /**
     * String is submitted and checked against properties file of vocabulary. If word exists it is replaced, and
     * the translated text is returned as a String.
     * @param string String input by user to be processed
     * @return Processed string
     */
    public String processString(String string) {

        // string split into string array for processing
        String[] tokens = createTokensWord(string);

        // translated string created from replacing words
        String translatedString = string;

        // checks tokens by word
        for (String token : tokens) {
            String newToken = checkToken(token);
            translatedString = translatedString.replace(token, newToken);
        }

        // converts translated string to tokens for another pass through.
        tokens = createTokensSpace(translatedString);

        // checks tokens by spaces
        for (String token : tokens) {
            String newToken = checkToken(token);
            translatedString = translatedString.replace(token, newToken);
        }

        // returns translated string
        return translatedString;
    }


    /**
     *  Split each line of strings to put into separate elements in
     *  ArrayList by word.
     *  @param string Line of strings from ASCII text file.
     */
    public String[] createTokensWord(String string) {
        String[] tokenArray = string.split("\\W");
        return tokenArray;
    }

    /**
     *  Split each line of strings to put into separate elements in
     *  ArrayList by space.
     *  @param string Line of strings from ASCII text file.
     */
    public String[] createTokensSpace(String string) {
        String[] tokenArray = string.split("\\s");
        return tokenArray;
    }

    /**
     * Checks a single token against the properties file to see if a translation exists.
     * If translation exists returns the translated word.
     * @param token Single token to be checked.
     * @return Translated token, or same token if no translation exists.
     */
    public String checkToken(String token) {

        if (properties.containsKey(token)) {
            token = properties.getProperty(token);
        }

        return token;
    }
}