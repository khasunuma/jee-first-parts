package com.poortoys.jeefirstparts.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.poortoys.jeefirstparts.htmlhelper.HtmlTemplate;

@Path("scope")
@RequestScoped
public class ScopeTestResource {

    @Inject
    private RequestScopedBean request;

    @Inject
    private SessionScopedBean session;

    @Inject
    private ApplicationScopedBean application;

    @GET
    public String getValues() {
        request.setCount(request.getCount() + 1);
        session.setCount(session.getCount() + 1);
        application.setCount(application.getCount() + 1);

        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("CDI Scope Test Result");

        StringBuilder body = new StringBuilder();
        body.append("<h2>CDI Scope Test Result</h2>");
        body.append("<p style=\"font-size: large;\">Count of calls (reload and confirm each value)</p>");
        body.append("<p>Request scope: ").append(request.getCount()).append("</p>");
        body.append("<p>Session scope: ").append(session.getCount()).append("</p>");
        body.append("<p>Application scope: ").append(application.getCount()).append("</p>");
        template.setBody(body);

        return template.toString();
    }

}
