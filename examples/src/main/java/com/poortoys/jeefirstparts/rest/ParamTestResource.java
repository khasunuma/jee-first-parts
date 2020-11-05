package com.poortoys.jeefirstparts.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.poortoys.jeefirstparts.htmlhelper.HtmlTemplate;

@Path("param")
public class ParamTestResource {

    @GET
    @Path("query")
    @Produces("text/html")
    public String getQueryParam(@QueryParam("id") int id, @DefaultValue("en") @QueryParam("lang") String lang) {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Param Test Result - @QueryParam");
        
        StringBuilder body = new StringBuilder();
        body.append("<h1>Param Test Result - @QueryParam</h1>\n");
        body.append("<p>Query Parameters:</p><ul>\n");
        body.append("<li>id = <strong>").append(id).append("</strong></li>\n");
        body.append("<li>lang = <strong>").append(lang).append("</strong></li>\n");
        body.append("</ul>");
        template.setBody(body);
        
        return template.toString();
    }

    @POST
    @Path("form")
    @Produces("text/html")
    public String getFormParam(@FormParam("name") String name, @FormParam("email") String email) {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Param Test Result - @FormParam");
        
        StringBuilder body = new StringBuilder();
        body.append("<h1>Param Test Result - @FormParam</h1>\n");
        body.append("<p>Form Parameters:</p><ul>\n");
        body.append("<li>name = <strong>").append(name).append("</strong></li>\n");
        body.append("<li>email = <strong>").append(email).append("</strong></li>\n");
        body.append("</ul>");
        template.setBody(body);
        
        return template.toString();
    }
    
    @GET
    @Path("path/{name}")
    @Produces("text/html")
    public String getPathParam(@PathParam("name") String name) {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Param Test Result - @PathParam");
        
        StringBuilder body = new StringBuilder();
        body.append("<h1>Param Test Result - @PathParam</h1>\n");
        body.append("<p>Path Parameter: <strong>").append(name).append("</strong></p>\n");
        template.setBody(body);
        
        return template.toString();
    }

    @GET
    @Path("header")
    @Produces("text/html")
    public String getHeaderParam(@HeaderParam("Host") String host, @HeaderParam("User-Agent") String userAgent) {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Param Test Result - @HeaderParam");
        
        StringBuilder body = new StringBuilder();
        body.append("<h1>Param Test Result - @HeaderParam</h1>\n");
        body.append("<p>Header Parameter(s):</p><ul>\n");
        body.append("<li>Host = <strong>").append(host).append("</strong></li>\n");
        body.append("<li>User-Agent = <strong>").append(userAgent).append("</strong></li>\n");
        body.append("</ul>");
        template.setBody(body);
        
        return template.toString();
    }

    @GET
    @Path("matrix")
    @Produces("text/html")
    public String getMatrixParam(@MatrixParam("x") double x, @MatrixParam("y") double y, @MatrixParam("z") double z) {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Param Test Result - @MatrixParam");
        
        StringBuilder body = new StringBuilder();
        body.append("<h1>Param Test Result - @MatrixParam</h1>\n");
        body.append("<p>Matrix URI Parameters:</p><ul>\n");
        body.append("<li>x = <strong>").append(x).append("</strong></li>\n");
        body.append("<li>y = <strong>").append(y).append("</strong></li>\n");
        body.append("<li>z = <strong>").append(z).append("</strong></li>\n");
        body.append("</ul>");
        template.setBody(body);
        
        return template.toString();
    }

}
