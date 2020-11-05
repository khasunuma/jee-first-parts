package com.poortoys.jeefirstparts.rest;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "servletContext")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServletContextData {

    private String contextPath;

    private int majorVersion;

    private int minorVersion;

    private int effectiveMajorVersion;

    private int effectiveMinorVersion;

    private String serverInfo;

    private String servletContextName;

    private String virtualServerName;

    private int sessionTimeout;

    private String requestCharacterEncoding;

    private String responseCharacterEncoding;

    @Override
    public int hashCode() {
        return Objects.hash(contextPath, effectiveMajorVersion, effectiveMinorVersion, majorVersion, minorVersion,
                requestCharacterEncoding, responseCharacterEncoding, serverInfo, servletContextName, sessionTimeout,
                virtualServerName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ServletContextData other = (ServletContextData) obj;
        return Objects.equals(contextPath, other.contextPath) && effectiveMajorVersion == other.effectiveMajorVersion
                && effectiveMinorVersion == other.effectiveMinorVersion && majorVersion == other.majorVersion
                && minorVersion == other.minorVersion
                && Objects.equals(requestCharacterEncoding, other.requestCharacterEncoding)
                && Objects.equals(responseCharacterEncoding, other.responseCharacterEncoding)
                && Objects.equals(serverInfo, other.serverInfo)
                && Objects.equals(servletContextName, other.servletContextName)
                && sessionTimeout == other.sessionTimeout && Objects.equals(virtualServerName, other.virtualServerName);
    }

    @Override
    public String toString() {
        return "ServletContextData [contextPath=" + contextPath + ", majorVersion=" + majorVersion + ", minorVersion="
                + minorVersion + ", effectiveMajorVersion=" + effectiveMajorVersion + ", effectiveMinorVersion="
                + effectiveMinorVersion + ", serverInfo=" + serverInfo + ", servletContextName=" + servletContextName
                + ", virtualServerName=" + virtualServerName + ", sessionTimeout=" + sessionTimeout
                + ", requestCharacterEncoding=" + requestCharacterEncoding + ", responseCharacterEncoding="
                + responseCharacterEncoding + "]";
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public int getEffectiveMajorVersion() {
        return effectiveMajorVersion;
    }

    public void setEffectiveMajorVersion(int effectiveMajorVersion) {
        this.effectiveMajorVersion = effectiveMajorVersion;
    }

    public int getEffectiveMinorVersion() {
        return effectiveMinorVersion;
    }

    public void setEffectiveMinorVersion(int effectiveMinorVersion) {
        this.effectiveMinorVersion = effectiveMinorVersion;
    }

    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }

    public String getServletContextName() {
        return servletContextName;
    }

    public void setServletContextName(String servletContextName) {
        this.servletContextName = servletContextName;
    }

    public String getVirtualServerName() {
        return virtualServerName;
    }

    public void setVirtualServerName(String virtualServerName) {
        this.virtualServerName = virtualServerName;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getRequestCharacterEncoding() {
        return requestCharacterEncoding;
    }

    public void setRequestCharacterEncoding(String requestCharacterEncoding) {
        this.requestCharacterEncoding = requestCharacterEncoding;
    }

    public String getResponseCharacterEncoding() {
        return responseCharacterEncoding;
    }

    public void setResponseCharacterEncoding(String responseCharacterEncoding) {
        this.responseCharacterEncoding = responseCharacterEncoding;
    }

}
