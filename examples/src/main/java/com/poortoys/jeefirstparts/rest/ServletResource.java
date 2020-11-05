package com.poortoys.jeefirstparts.rest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import com.poortoys.jeefirstparts.htmlhelper.HtmlTemplate;

@Path("servlet")
public class ServletResource {

    @Context
    private ServletConfig config;

    @Context
    private ServletContext context;

    @GET
    @Produces("text/html")
    public String getServletNameHtml() {
        HtmlTemplate template = HtmlTemplate.create();
        template.setTitle("Servlet Name");

        StringBuilder body = new StringBuilder();
        body.append("<p>Servlet Name: ").append(config.getServletName()).append("</p>");
        template.setBody(body);

        return template.toString();
    }

    @GET
    @Produces("application/xml")
    public String getServletNameXml() {
        return "<?xml version=\"1.0\"?>\n" + "<servletName>" + config.getServletName() + "</servletName>";
    }

    @GET
    @Produces("application/json")
    public String getServletNameJson() {
        return "{\"servletName\":\"" + config.getServletName() + "\"}";
    }

    @GET
    @Path("context")
    @Produces("application/xml")
    public ServletContextData getServletContextXml() {
        ServletContextData xml = new ServletContextData();
        xml.setContextPath(context.getContextPath());
        xml.setMajorVersion(context.getMajorVersion());
        xml.setMinorVersion(context.getMinorVersion());
        xml.setEffectiveMajorVersion(context.getEffectiveMajorVersion());
        xml.setEffectiveMinorVersion(context.getEffectiveMinorVersion());
        xml.setServerInfo(context.getServerInfo());
        xml.setServletContextName(context.getServletContextName());
        xml.setVirtualServerName(context.getVirtualServerName());
        xml.setSessionTimeout(context.getSessionTimeout());
        xml.setRequestCharacterEncoding(context.getRequestCharacterEncoding());
        xml.setResponseCharacterEncoding(context.getResponseCharacterEncoding());

        return xml;
    }

    @GET
    @Path("context")
    @Produces("application/json")
    public ServletContextData getServletContextJson() {
        ServletContextData json = new ServletContextData();
        json.setContextPath(context.getContextPath());
        json.setMajorVersion(context.getMajorVersion());
        json.setMinorVersion(context.getMinorVersion());
        json.setEffectiveMajorVersion(context.getEffectiveMajorVersion());
        json.setEffectiveMinorVersion(context.getEffectiveMinorVersion());
        json.setServerInfo(context.getServerInfo());
        json.setServletContextName(context.getServletContextName());
        json.setVirtualServerName(context.getVirtualServerName());
        json.setSessionTimeout(context.getSessionTimeout());
        json.setRequestCharacterEncoding(context.getRequestCharacterEncoding());
        json.setResponseCharacterEncoding(context.getResponseCharacterEncoding());

        return json;
    }

    @GET
    @Path("request")
    @Produces("text/html")
    public String getRequestUriHtml(@Context HttpServletRequest request) {
        HtmlTemplate template = HtmlTemplate.create();

        template.setTitle("Request URI");

        StringBuilder body = new StringBuilder();
        body.append("<ul>\n");
        body.append("<li>Request URI: ").append(request.getRequestURI()).append("</li>\n");
        body.append("<li>Method: ").append(request.getMethod()).append("</li>\n");
        body.append("</ul>");
        template.setBody(body);

        return template.toString();
    }
}
