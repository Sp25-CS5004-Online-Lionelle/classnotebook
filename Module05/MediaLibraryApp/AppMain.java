package MediaLibraryApp;
public final class AppMain {

    public static void main(String[] args) {
        ConsoleView view = ConsoleView.getInstance();
        Library library = new Library();
        LibraryManager manager = new LibraryManager(view, library);
        manager.run();
    }
    
}
