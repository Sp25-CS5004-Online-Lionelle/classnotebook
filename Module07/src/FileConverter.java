
import controller.ArgController;

import model.BookModel;

public class FileConverter {
    public static void main(String[] args) {


        ArgController parser = new ArgController();
        parser.parseArgs(args);
        BookModel model = BookModel.getInstance(parser.getInputFile());
        parser.setModel(model);
        parser.run();

        

        
    }
    
}
