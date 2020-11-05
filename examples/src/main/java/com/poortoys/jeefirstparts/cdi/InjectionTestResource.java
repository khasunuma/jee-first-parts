package com.poortoys.jeefirstparts.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.poortoys.jeefirstparts.htmlhelper.HtmlTemplate;

@Path("inject")
@RequestScoped
public class InjectionTestResource {

    @Inject
    private Message message1;

    @Inject
    private MessageImpl message2;

    @GET
    @Produces("text/html")
    public String getMessage() {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Injection Test Result");

        StringBuilder body = new StringBuilder();
        body.append("<h2>Injection Test Result</h2>");
        body.append("<p>Message (injects to interface): ").append(message1.getMessage()).append("</p>\n");
        body.append("<p>Message (injects to class): ").append(message2.getMessage()).append("</p>\n");
        template.setBody(body);

        return template.toString();
    }
}
