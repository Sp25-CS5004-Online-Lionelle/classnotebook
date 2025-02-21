package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "book")
@JsonPropertyOrder({"id", "title", "author", "year", "genre", "rating", "pages", "chapters"})
public record BookRecord(String id, String title, String author, int year, String genre, int rating, int pages, int chapters) {
    
}
