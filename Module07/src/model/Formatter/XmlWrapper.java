package model.Formatter;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import model.BookRecord;

@JacksonXmlRootElement(localName = "BookList")
public final class XmlWrapper {

    @JacksonXmlElementWrapper(useWrapping = false)
    private Collection<BookRecord> book;

    public XmlWrapper(Collection<BookRecord> books) {
        this.book = books;
    }
}
