import java.io.OutputStream;
import java.util.Collection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class DataFormatter {

    private DataFormatter() {
    }

    public static void writeJSONData(Collection<IBook.BookRecord> books, OutputStream out) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(out, books);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeCSVData(Collection<IBook.BookRecord> books, OutputStream out) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(IBook.BookRecord.class).withHeader();
        try {
            mapper.writer(schema).writeValues(out).writeAll(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void write(Collection<IBook.BookRecord> books, OutputStream out, Format format) {
        switch (format) {
            case CSV:
                writeCSVData(books, out);
                break;
            case JSON:
                writeJSONData(books, out);
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

}
