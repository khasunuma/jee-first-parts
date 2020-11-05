package com.poortoys.jeefirstparts.config;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.poortoys.jeefirstparts.htmlhelper.HtmlTemplate;

@Path("config")
@RequestScoped
public class ConfigTestResource {

    static {
        System.setProperty("jeefirstparts.message", "Jakarta EE: The First Parts");
    }

    @Inject
    @ConfigProperty(name = "HOME")
    private String home;

    @Inject
    @ConfigProperty(name = "USERPROFILE")
    private String userprofile;

    @Inject
    @ConfigProperty(name = "jeefirstparts.hello")
    private String hello;

    @Inject
    @ConfigProperty(name = "jeefirstparts.message")
    private String message;

    @Inject
    @ConfigProperty(name = "jeefirstparts.nothing", defaultValue = "N/A")
    private String nothing;

    @GET
    @Produces("text/html")
    public String get() {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("MicroProfile Config Test");

        StringBuilder body = new StringBuilder();
        body.append("<p>HOME = <strong>").append(home).append("</strong></p>\n");
        body.append("<p>USERPROFILE = <strong>").append(userprofile).append("</strong></p>\n");
        body.append("<p>jeefirstparts.hello = <strong>").append(hello).append("</strong></p>\n");
        body.append("<p>jeefirstparts.message = <strong>").append(message).append("</strong></p>\n");
        body.append("<p>jeefirstparts.nothing = <strong>").append(nothing).append("</strong></p>\n");
        template.setBody(body);

        return template.toString();
    }

}
