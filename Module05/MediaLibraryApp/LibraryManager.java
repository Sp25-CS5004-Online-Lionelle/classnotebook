package MediaLibraryApp;
import java.util.Arrays;
import java.util.List;

public final class LibraryManager {
    private final ConsoleView view;
    private final Library library;
    private static final String DEFAULT_LIBRARY = "library.csv";

    public LibraryManager(ConsoleView view, Library library) {
        this.view = view;
        this.library = library;
        
        for (Commands cmd : Commands.values()) {
            view.registerCommand(cmd.getCommandString(), cmd.getDesc());
        }
        // load the default library
        FileUtils.openLibrary(library, DEFAULT_LIBRARY);

        view.displayHelp();
    }

    public void run() {
        List<String> commands = view.getCommand();
        String cmd = commands.get(0);
        while (cmd != null) {
            Commands command = Commands.fromString(cmd);
            switch (command) {
                case HELP:
                    view.displayHelp();
                    break;
                case ADD:
                    List<String> values = view.addMedia();
                    if(values != null) {
                        IMedia media = IMedia.fromList(values);
                        if(media != null) {
                            library.addMedia(media);
                        } 
                    } else {
                        view.invalidCommand();
                    }

                    break;
                case LIST:
                    view.displayMediaList(library.getMediaList());
                    break;
                case SAVE:
                    String filename;
                    if(commands.size() > 1) {
                        filename = commands.get(1);
                        
                    }else {
                        filename = view.getSaveFileName();
                    }
                    FileUtils.saveLibrary(library, filename);
                    break;
                case LOAD:
                    String openFileName;
                    if(commands.size() > 1 ) {
                        openFileName = commands.get(1);
                    } else {
                        openFileName = view.getFileToOpen();
                    }
                    FileUtils.openLibrary(library, openFileName);
                    break;
                case DETAILS:
                    view.display("Displaying details of a media item.\n");
                    break;
                
                
                case EXIT:
                    view.display("Exiting the program.\n");
                    System.exit(0);
                    break;

            }
      
            commands = view.getCommand();
            cmd = commands.get(0);
        }

    }

    
 

    private enum Commands {
        HELP("help|?",  "Display this help dialog."), 
        ADD("add", "Add a new media item."),
        LIST("list|ls", "List all media items."),
        SAVE("save", "save [filename] - Save the media library to a file. Uses filename if provided"),
        LOAD("load|open", "open [filename] Load the media library from a file. Uses filename if provided"),
        DETAILS("details", "Display details of a media item."),
        EXIT("exit|bye|goodbye", "Exit the program.");

        private final List<String> cmd;
        private final String desc;

        Commands(String cmd, String desc) {
            this.cmd = Arrays.asList(cmd.split("\\|"));
            this.desc = desc;
        }

        public static Commands fromString(String cmd) {
            for (Commands c : Commands.values()) {
                if (c.cmd.contains(cmd.toLowerCase())) {
                    return c;
                }
            }
            return null;
        }

        public String getDesc() {
            return desc;
        }

        public String getCommandString() {
            String str = "";
            for (String c : cmd) {
                str += c + "|";
            }
            return str.substring(0, str.length() - 1);
        }

        
    }
}
