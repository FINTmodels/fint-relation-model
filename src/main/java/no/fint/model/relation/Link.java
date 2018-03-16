package no.fint.model.relation;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@XmlType(name = "link", namespace = Link.ATOM_NAMESPACE)
public class Link implements Serializable {

    private static final String URI_PATTERN = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";

    public static final String REL_SELF = "self";
    public static final String REL_FIRST = "first";
    public static final String REL_PREVIOUS = "prev";
    public static final String REL_NEXT = "next";
    public static final String REL_LAST = "last";

    @XmlAttribute private String rel;
    @XmlAttribute private String href;

    
    public Link(String href) {
        this(href, REL_SELF);
    }

    
    public Link(String href, String rel) {
        this.href = href;
        this.rel = rel;
    }


    protected Link() {

    }

    
    public String getHref() {
        return href;
    }

    
    public String getRel() {
        return rel;
    }

    
    public Link withRel(String rel) {
        return new Link(href, rel);
    }

    
    public Link withSelfRel() {
        return withRel(Link.REL_SELF);
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Link)) {
            return false;
        }

        Link that = (Link) obj;

        return this.href.equals(that.href) && this.rel.equals(that.rel);
    }

    @Override
    public int hashCode() {

        int result = 17;
        result += 31 * href.hashCode();
        result += 31 * rel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("<%s>;rel=\"%s\"", href, rel);
    }

    
    public static Link valueOf(String element) {

        Pattern uriAndAttributes = Pattern.compile("<(.*)>;(.*)");
        Matcher matcher = uriAndAttributes.matcher(element);

        if (matcher.find()) {

            Map<String, String> attributes = getAttributeMap(matcher.group(2));

            if (!attributes.containsKey("rel")) {
                throw new IllegalArgumentException("Link does not provide a rel attribute!");
            }

            return new Link(matcher.group(1), attributes.get("rel"));

        } else {
            throw new IllegalArgumentException(String.format("Given link header %s is not RFC5988 compliant!", element));
        }
    }

    
    private static Map<String, String> getAttributeMap(String source) {

        Map<String, String> attributes = new HashMap<String, String>();
        Pattern keyAndValue = Pattern.compile("(\\w+)=\"(\\p{Lower}[\\p{Lower}\\p{Digit}\\.\\-]*|" + URI_PATTERN + ")\"");
        Matcher matcher = keyAndValue.matcher(source);

        while (matcher.find()) {
            attributes.put(matcher.group(1), matcher.group(2));
        }

        return attributes;
    }
}
