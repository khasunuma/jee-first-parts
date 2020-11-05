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

/**
 * Minimal HTML Template Engine.
 * <p>Reads a HTML file contains place folders as a template and simply replaces 
 * the place folders by given value.</p>
 * <p>There are two kind of place folders: ${name} and &lt;!-- name --&gt;
 * The first one is used in where an inner text is allowed. The second one is 
 * seemed as a HTML comment and used in elsewhere.</p>
 * <p>The template engine provides two method to replace the place folders:
 * {@link #set(String, Object)} that is used for ${name} and
 * {@link #fill(String, CharSequence)} that is used for &lt;-- name --&gt;.</p>
 * <p>To use two styles of place folders, you could keep a template as a suitable 
 * HTML document.</p>
 * 
 * @author k.hasunuma
 *
 */
public class HtmlTemplate {

    /**
     * The default template.
     * <p>This is the following HTML document:</p>
     * <pre>&lt;!doctype html&gt;
     * &lt;head&gt;
     * &lt;meta charset="utf-8"&gt;
     * &lt;title&gt;${title}&lt;/title&gt;
     * &lt;-- head --&gt;
     * &lt;/head&gt;
     * &lt;body&gt;
     * ${body}
     * &lt;/body&gt;
     * &lt;/html&gt;</pre>
     * <p>There are three place folder: ${title}, &lt;-- head --&gt; and ${body}.</p>
     */
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
    
    /**
     * The template which is edited.
     * <p>This is edited by replacing place folders using {{@link #set(String, Object)} 
     * method or {@link #fill(String, CharSequence)} method.</p>
     */
    private String html;

    /**
     * The constructor.
     * 
     * @param html a HTML template to be edited, not null
     */
    private HtmlTemplate(String html) {
        Objects.requireNonNull(html);

        this.html = html;
    }

    /**
     * Create a new template from a given text.
     * 
     * @param text a text used as a template, not null
     * @return a new instance of this class, never null
     */
    public static HtmlTemplate create(CharSequence text) {
        return new HtmlTemplate(text.toString());
    }

    /**
     * Create a new template from the default template.
     * <p>As the default template, this uses {@link #DEFAULT_TEMPLATE}.</p>
     * 
     * @return a new instance of this class, never null
     */
    public static HtmlTemplate create() {
        return HtmlTemplate.create(DEFAULT_TEMPLATE);
    }
    
    /**
     * Create a new template from a file.
     * 
     * @param path path to the file, not null
     * @return a new instance of this class, never null
     * @throws IOException an error is occurred during reading the file
     */
    public static HtmlTemplate load(Path path) throws IOException {
        Objects.requireNonNull(path);

        byte[] buffer = Files.readAllBytes(path);
        return new HtmlTemplate(new String(buffer, "utf-8"));
    }

    /**
     * Create a new template from a file.
     * 
     * @param file the file object, not null
     * @return a new instance of this class, never null
     * @throws IOException an error is occurred during reading the file
     */
    public static HtmlTemplate load(File file) throws IOException {
        Objects.requireNonNull(file);
        
        return HtmlTemplate.load(file.toPath());
    }

    /**
     * Create a new template from {@link java.io.Reader}.
     * 
     * @param reader {@link java.io.Reader} object to read a template, not null
     * @return a new instance of this class, never null
     * @throws IOException an error is occurred during reading the {@link java.io.Reader}
     */
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

    /**
     * Create a new template from {@link java.io.InputStream}.
     * 
     * @param in {@link java.io.InputStream} object to read a template, not null
     * @return a new instance of this class, never null
     * @throws IOException an error is occurred during reading the {@link java.io.InputStream}
     */
    public static HtmlTemplate load(InputStream in) throws IOException {
        return HtmlTemplate.load(new InputStreamReader(in, "utf-8"));
    }

    /**
     * Set a value to "${name}" style place folder.
     * 
     * @param name place folder name
     * @param value a value to replace, not null
     * @return Reference for this instance, never null
     */
    public HtmlTemplate set(String name, Object value) {
        html = html.replace("${" + name + "}", value.toString());

        return this;
    }

    /**
     * Fill a value to "&lt;-- name --&gt;" style place folder.
     * 
     * @param name place folder name
     * @param text a value to replace, not null
     * @return Reference for this instance, never null
     */
    public HtmlTemplate fill(String name, CharSequence text) {
        html = html.replace("<!-- " + name + " -->", text);

        return this;
    }

    /**
     * Set the title of a HTML template.
     * <p>This is a convenient method for the default template.
     * This is same as {@link #set(String, Object) set("title", Object)}.</p>
     * 
     * @param title a value as title
     * @return Reference for this instance, never null
     */
    public HtmlTemplate setTitle(CharSequence title) {
        return set("title", title);
    }

    /**
     * Set the header of a HTML template.
     * <p>This is a convenient method for the default template.
     * This is same as {@link #fill(String, CharSequence) fill("head", CharSequence)}.</p>
     * 
     * @param header a value as header which excludes &lt;title&gt; and &lt;meta charset&gt;
     * @return Reference for this instance, never null
     */
    public HtmlTemplate setHeader(CharSequence header) {
        return fill("head", header);
    }

    /**
     * Set the body of a HTML template.
     * <p>This is a convenient method for the default template.
     * This is same as {@link #set(String, Object) set("body", Object)}.</p>
     * 
     * @param body
     * @return
     */
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

    /**
     * Obtains a rendered HTML document.
     * 
     * @return a rendered HTML document
     */
    @Override
    public String toString() {
        return html;
    }

}
