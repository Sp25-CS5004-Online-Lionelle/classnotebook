import java.io.File;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ReadCSVExample {
    
    
    public static void main(String[] args) {
       CsvSchema schema = CsvSchema.emptySchema().withHeader();

       CsvMapper mapper = new CsvMapper();

        try {
              File file = new File("books.csv");
              MappingIterator<Book> it = mapper.readerFor(Book.class)
                     .with(schema)
                     .readValues(file);
              List<Book> books = it.readAll();
              for (Book book : books) {
                System.out.println(book);
              }
         } catch (Exception e) {
              e.printStackTrace();
         }

    }
}
