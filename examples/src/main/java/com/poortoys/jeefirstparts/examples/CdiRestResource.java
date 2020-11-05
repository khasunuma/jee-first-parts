package com.poortoys.jeefirstparts.examples;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("cdi-rest")
@RequestScoped
public class CdiRestResource {

    @Inject
    CdiBean2 bean;

    @GET
    @Produces("text/html")
    public String handle() {
        String value = bean.execute();

        return "<!doctype html>" 
            + "<html>" 
            + "<head>" 
            + "<title>CDI-REST Integration Test Result</title>" 
            + "</head>"
            + "<body>" 
            + "<h1>CDI-REST Integration Test Result</h1>" 
            + "<p>Obtained value: <strong>" + value + "</strong></p>" 
            + "</body>"
            + "</html>";
    }

}
