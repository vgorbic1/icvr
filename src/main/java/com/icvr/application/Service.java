package com.icvr.application;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 * Provide Web Services.
 */
@Path("/service")
public class Service {

    /*
    * @Context - Context of the resource
     */
    @Context ServletContext context;

    public String processUserInput(String userInput) {
        CVR cvr = (CVR) context.getAttribute("properties");
        return cvr.processString(userInput.toLowerCase());
    }


    /*
    * JAX-RS
    * @GET          - HTTP Get request, used to fetch resource
    * @Path         - Path of the resource method
    * @Produces     - HTTP Response type
    * @PathParam    - Maps variable URI path into method call
     */
    @GET
    @Path("/txt/{param}")
    @Produces("text/plain")
    public String outputPlainMessage(@PathParam("param") String userInput) {
        return processUserInput(userInput);
    }

    @GET
    @Path("/html/{param}")
    @Produces("text/html")
    public String outputHTMLMessage(@PathParam("param") String userInput) {
        return "<!DOCTYPE html><html><head><title>iCVR Web Service</title></head>"
                + "<body><p>" + userInput + "</p><p>" + processUserInput(userInput)
                + "</p></body></html>";
    }

    @GET
    @Path("/json/{param}")
    @Produces("application/json")
    public String outputJSONMessage(@PathParam("param") String userInput) {
        return "{\"" + userInput + "\":\"" + processUserInput(userInput) + "\"}";
    }

}