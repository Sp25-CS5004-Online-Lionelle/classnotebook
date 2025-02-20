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
              int id = 0;
              for (Book book : books) {
               book.setId(id++);
                System.out.println(book);
              }
              System.out.println("Book Records:");
              List<IBook.BookRecord> bookRecords = books.stream()
                     .map(Book::toRecord)
                     .toList();
              bookRecords.forEach(System.out::println);
         } catch (Exception e) {
              e.printStackTrace();
         }

    }
}
