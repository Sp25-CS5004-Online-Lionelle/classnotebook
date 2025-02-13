import java.util.List;

public class FileConverter {
    public static void main(String[] args) {

        ArgParser parser = new ArgParser();
        parser.parseArgs(args);

        List<Book>  books = InputReader.readBooks(parser.getInputStream(), parser.getInputFormat());

        System.out.println(books);

        
    }
    
}
