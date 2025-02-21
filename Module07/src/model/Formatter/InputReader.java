package model.Formatter;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import model.Book;
import model.BookRecord;

public class InputReader {

    public static List<BookRecord> readBooks(InputStream source, Format format) {

        switch (format) {
            case CSV:
                return readCSV(source);
            case JSON:
                return readJSON(source);
            case XML:
                return readXML(source);
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }


    private static List<BookRecord> readXML(InputStream source) {
       
       ObjectMapper mapper = new XmlMapper();
       List<BookRecord> books = null;
       try {
            books = mapper.readValue(source, new TypeReference<List<BookRecord>>(){});

        } catch (Exception e) {
            e.printStackTrace();
        }
       
       return books;
    }

    private static List<BookRecord> readJSON(InputStream source) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    private static List<BookRecord> readCSV(InputStream source) {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

       CsvMapper mapper = new CsvMapper();

        try {
              
              MappingIterator<Book> it = mapper.readerFor(Book.class)
                     .with(schema)
                     .readValues(source);
              List<Book> books = it.readAll();
              for (Book book : books) {
                    if(book.getId() == null) book.setId(slugify(book.getTitle()));
              }

              return books.stream().map(Book::toRecord).toList();
         } catch (Exception e) {
              e.printStackTrace();
         }
         return null;
    }

    private static String slugify(String title) {
        return title.toLowerCase().replaceAll("[^a-z0-9]", "-");
    }



    public static void main(String[] args) {
        String xml = "<BookList>\r\n" + //
                        "  <book>\r\n" + //
                        "    <id>the-catcher-in-the-rye</id>\r\n" + //
                        "    <title>The Catcher in the Rye</title>\r\n" + //
                        "    <author>J.D. Salinger</author>\r\n" + //
                        "    <year>1951</year>\r\n" + //
                        "    <genre>classic</genre>\r\n" + //
                        "    <rating>3</rating>\r\n" + //
                        "    <pages>214</pages>\r\n" + //
                        "    <chapters>26</chapters>\r\n" + //
                        "  </book>" + 
                        "  <book>\r\n" + //
                        "    <id>the-catcher-in-the-rye2</id>\r\n" + //
                        "    <title>The Catcher in the Rye2</title>\r\n" + //
                        "    <author>J.D. Salinger</author>\r\n" + //
                        "    <year>1951</year>\r\n" + //
                        "    <genre>classic</genre>\r\n" + //
                        "    <rating>3</rating>\r\n" + //
                        "    <pages>214</pages>\r\n" + //
                        "    <chapters>26</chapters>\r\n" + //
                        "  </book></BookList>"; 
        ObjectMapper mapper = new XmlMapper();
        try {
            List<BookRecord> books = mapper.readValue(xml, new TypeReference<List<BookRecord>>(){});
            System.out.println(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
