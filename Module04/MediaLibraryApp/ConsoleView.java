package MediaLibraryApp;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    private static ConsoleView instance = null;

    private static String cmdPrmpt = "What would you like to do? ";

    private String helpDialog = "Commands:\n";

    private ConsoleView() {
    }

    // this means only one instance of ConsoleView can exist. 
    public static ConsoleView getInstance() {
        if (instance == null) {
            instance = new ConsoleView();
        }
        return instance;
    }

    private String getClientInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void display(String fmt, Object ... args) {
        System.out.printf(fmt, args);
    }

    public void registerCommand(String cmd, String desc) {
        helpDialog += String.format("%s: %s\n", cmd, desc);
    }

    public void displayHelp() {
        display("%s%n", helpDialog);
    }

    public String getCommand() {
        return getClientInput(cmdPrmpt);
    }

    public void invalidCommand() {
        display("Invalid command. Type 'help' for a list of commands.\n");
    }
    
    // asks a series of questions to add new media, returns a list of the answers
    public List<String> addMedia() {
        display("Adding a new media item.\n");
        MediaTypes type = getMediaType();
        switch(type) {
            case BOOK:
                return getBookDetails();
            case AUDIO_BOOK:
                return getAudioBookDetails();
            case MUSIC:
                return getMusicDetails();
            default:
                return null;
        }
    }



    private MediaTypes getMediaType() {
        String type = getClientInput("Enter the media type (book, audio_book, music): ");
        return MediaTypes.fromString(type);
    }
    
    private List<String> getBookDetails() {
        String title = getClientInput("Enter the title: ");
        String genre = getClientInput("Enter the genre: ");
        String year = getClientInput("Enter the year: ");
        String pages = getClientInput("Enter the number of pages: ");
        String chapters = getClientInput("Enter the number of chapters: ");
        return List.of(MediaTypes.BOOK.toString(), title, genre, year, pages, chapters);
    }

    private List<String> getAudioBookDetails() {
        String title = getClientInput("Enter the title: ");
        String genre = getClientInput("Enter the genre: ");
        String year = getClientInput("Enter the year: ");
        String chapters = getClientInput("Enter the chapters: ");
        String isrc = getClientInput("Enter the isrc: ");
        String length = getClientInput("Enter the time in seconds: ");
        return List.of(MediaTypes.AUDIO_BOOK.toString(), title, genre, year, chapters, isrc, length);
    }

    private List<String> getMusicDetails() {
        String title = getClientInput("Enter the title: ");
        String genre = getClientInput("Enter the genre: ");
        String year = getClientInput("Enter the year: ");
        String artist = getClientInput("Enter the isrc: ");
        String length = getClientInput("Enter the time in seconds: ");
        return List.of(MediaTypes.MUSIC.toString(), title, genre, year, artist, length);
    }

    public void displayMediaList(Stream<IMedia> mediaList) {
        mediaList.forEach(media -> display("%s%n", media)); 
    }
}
