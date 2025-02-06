package MediaLibraryApp;
public final class AppMain {

    public static void main(String[] args) {
        ConsoleView view = ConsoleView.getInstance();
        Library library = new Library();
        ICheckout checkout = new CheckhoutCart();
        LibraryManager manager = new LibraryManager(view, library, checkout);
        manager.run();
    }
    
}
