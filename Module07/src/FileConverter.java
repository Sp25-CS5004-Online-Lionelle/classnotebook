import java.util.List;


public class FileConverter {
    public static void main(String[] args) {

        ArgParser parser = new ArgParser();
        parser.parseArgs(args);

        List<BookRecord>  books = InputReader.readBooks(parser.getInputStream(), parser.getInputFormat());

        DataFormatter.write(books, parser.getOutputStream(), parser.getOutputFormat());
        

        
    }
    
}
