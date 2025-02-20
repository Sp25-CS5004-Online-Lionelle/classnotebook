import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

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
        throw new UnsupportedOperationException("Not implemented yet");
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



    
}
