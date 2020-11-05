package com.poortoys.jeefirstparts.htmlhelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class HtmlTemplate {

    public static final String DEFAULT_TEMPLATE = "<!doctype html>\n" 
            + "<head>\n" 
            + "<meta charset=\"utf-8\">\n"
            + "<title>${title}</title>\n" 
            + "<!-- head -->\n" 
            + "</head>\n" 
            + "<body>\n" 
            + "${body}\n" 
            + "</body>\n"
            + "</html>";
    
    private String html;

    private HtmlTemplate(String html) {
        Objects.requireNonNull(html);

        this.html = html;
    }

    public static HtmlTemplate create(CharSequence text) {
        return new HtmlTemplate(text.toString());
    }

    public static HtmlTemplate create() {
        return HtmlTemplate.create(DEFAULT_TEMPLATE);
    }
    
    public static HtmlTemplate load(Path path) throws IOException {
        Objects.requireNonNull(path);

        byte[] buffer = Files.readAllBytes(path);
        return new HtmlTemplate(new String(buffer, "utf-8"));
    }

    public static HtmlTemplate load(File file) throws IOException {
        Objects.requireNonNull(file);
        
        return HtmlTemplate.load(file.toPath());
    }

    public static HtmlTemplate load(Reader reader) throws IOException {
        Objects.requireNonNull(reader);

        try (BufferedReader buffer = new BufferedReader(reader)) {
            StringBuilder sb = new StringBuilder();
            for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
                sb.append(line).append("\n");
            }
            return new HtmlTemplate(sb.toString());
        }
    }

    public static HtmlTemplate load(InputStream in) throws IOException {
        return HtmlTemplate.load(new InputStreamReader(in, "utf-8"));
    }

    public HtmlTemplate set(String name, Object value) {
        html = html.replace("${" + name + "}", value.toString());

        return this;
    }

    public HtmlTemplate fill(String name, CharSequence text) {
        html = html.replace("<!-- " + name + " -->", text);

        return this;
    }

    public HtmlTemplate setTitle(CharSequence title) {
        return set("title", title);
    }

    public HtmlTemplate setHeader(CharSequence header) {
        return fill("head", header);
    }

    public HtmlTemplate setBody(CharSequence body) {
        return set("body", body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(html);
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
        HtmlTemplate other = (HtmlTemplate) obj;
        return Objects.equals(html, other.html);
    }

    @Override
    public String toString() {
        return html;
    }

}
