import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class DataFormatter {

    private DataFormatter() {
    }


    private static void writePrettyData(Collection<BookRecord> books, OutputStream out) {
        PrintStream ps = new PrintStream(out);
        for (BookRecord book : books) {
            ps.printf("\"%s\" by %s (%d) - %d pages, %d chapters, rated %d/5%n", book.title(), book.author(),
                    book.year(), book.pages(), book.chapters(), book.rating());
        }
    }

    private static void writeJSONData(Collection<BookRecord> books, OutputStream out) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(out, books);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void writeCSVData(Collection<BookRecord> books, OutputStream out) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(BookRecord.class).withHeader();
        try {
            mapper.writer(schema).writeValues(out).writeAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void write(Collection<BookRecord> books, OutputStream out, Format format) {
        switch (format) {
            case CSV:
                writeCSVData(books, out);
                break;
            case JSON:
                writeJSONData(books, out);
                break;
            case PRETTY:
                writePrettyData(books, out);
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

}
