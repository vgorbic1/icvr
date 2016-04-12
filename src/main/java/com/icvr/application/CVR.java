package com.icvr.application;

import java.util.Properties;

/**
 * iCVR Main Class
 */
public class CVR {

    private Properties properties;

    public CVR() {}

    public CVR(Properties properties) {
        this();
        this.properties = properties;
    }

    public String processString(String string) {
        String[] tokens = createTokens(string);
        String[] tokensHyphen = createTokensHyphen(string);
        String translatedString = string;

        for (String token : tokens) {
            String newToken = checkToken(token);
            translatedString = translatedString.replace(token, newToken);
        }

        for (String token : tokensHyphen) {
            String newToken = checkToken(token);
            translatedString = translatedString.replace(token, newToken);
        }
        return translatedString;
    }


    /**
     *  Split each line of strings to put into separate elements in
     *  ArrayList.
     *  @param string Line of strings from ASCII text file.
     */
    public String[] createTokens(String string) {
        String[] tokenArray = string.split("\\W");
        return tokenArray;
    }

    public String[] createTokensHyphen(String string) {
        String[] tokenArray = string.split("\\s");
        return tokenArray;
    }

    public String checkToken(String token) {
        if (properties.containsKey(token)) {
            token = properties.getProperty(token);
        }
        return token;
    }
}