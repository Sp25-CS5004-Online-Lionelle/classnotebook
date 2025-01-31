package MediaLibraryApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class FileUtils {
   
    
    public static void saveLibrary(Library library, String filename) {
        List<String> lines = library.getMediaList().map(IMedia::toCSV).toList();
        
        try {
            Files.write(Path.of(filename), lines);
        }catch(IOException ex) {
            System.err.println("Error saving the library to file: " + ex.getMessage());
        }
    }

    public static void openLibrary(Library library, String filename) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filename));
            
            lines.stream().map(IMedia::fromCSV).forEach(library::addMedia);
            // lines.stream().map(IMedia::fromCSV).forEach(m -> {
            //     library.addMedia(m);
            //     }
            // );

        }catch(IOException ex) {
            System.err.println("Error loading the library from file: " + ex.getMessage());
        }
    }
}
