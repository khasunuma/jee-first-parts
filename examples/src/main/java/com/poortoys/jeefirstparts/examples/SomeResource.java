package com.poortoys.jeefirstparts.examples;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("some")
public class SomeResource {

    @GET
    @Produces("text/html")
    public String handleGet(@QueryParam("id") String id) {
        return "<!doctype html>" 
                + "<html>" 
                + "<head>" 
                + "<title>HTTP GET Test</title>" 
                + "</head>" 
                + "<body>"
                + "<h1>HTTP GET Test Result</h1>" 
                + "<p>Query Parameter: <strong>" + id + "</strong></p>" 
                + "</body>" 
                + "</html>";
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html")
    public String handlePost(@FormParam("data") String data) {
        return "<!doctype html>" 
                + "<html>" 
                + "<head>" 
                + "<title>HTTP POST Test Result</title>" 
                + "</head>" 
                + "<body>"
                + "<h1>HTTP POST Test Result</h1>" 
                + "<p>Form Parameter: <strong>" + data + "</strong></p>" 
                + "</body>" 
                + "</html>";
    }
}
