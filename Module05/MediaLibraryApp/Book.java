package MediaLibraryApp;
public class Book extends AbstractMedia implements IBook {
    private int pages;
    private int chapters;
    
    private static final double price = 1.99;

    public Book(String title, String genre, int yearCreated, 
        int pages, int chapters) {
        super(title, genre, yearCreated);
        this.pages = pages;
        this.chapters = chapters;
    }

    @Override
    public MediaTypes getType() {  // interface Media
        return MediaTypes.BOOK;
    }

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public int getChapters() {
        return chapters;
    }

    @Override
    protected double getPriceByType() {  // exists in AbstractMedia
        return price;
    }

    @Override
    public String toCSV() {  
        return super.toCSV() + "," + pages + "," + chapters;
    }


    public static void main(String[] args) {
        Book book = new Book("Digital Book Title", "Fiction", 2023, 300, 12);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Year Created: " + book.getYearCreated());
        System.out.println("Pages: " + book.getPages());
        System.out.println("Chapters: " + book.getChapters());
        System.out.println("Price: $" + book.getPrice());
        System.out.println(book);
        System.out.println(book.toCSV());
        if (book.getType() == MediaTypes.BOOK) {
            System.out.println("This is a book.");
        }
    }
}
