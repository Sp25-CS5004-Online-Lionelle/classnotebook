public class AudioBook extends DigitalBook implements AudioMedia {
    private String isrc; 
    private int timeBySeconds;

    
    private static final double price = 5.99;
    private static final int max_pages = 0;

    public AudioBook(String title, String genre, int yearCreated, int pages, int chapters,
       String isrc, int timeBySeconds ) {
            super(title, genre, yearCreated, max_pages, chapters);
            this.isrc = isrc;
            this.timeBySeconds = timeBySeconds;
    }
  
    @Override
    public int getTimeBySeconds() {
        return timeBySeconds;
    }

    @Override
    public String getISRC() {
        return isrc;
    }

    @Override
    protected double getPriceByType() {  // exists in AbstractMedia
        return price;
    }

    @Override
    public String toCSV() {  
        return super.toCSV() + "," + isrc + "," + timeBySeconds;
    }

    @Override
    public MediaEnum getType() {
        return MediaEnum.AUDIO_BOOK;
    }
    

    public static void main(String[] args) {
        AudioBook book = new AudioBook("Digital Audio Book Title", "Fiction", 2023, 300, 12, "US-ABC-23-45678", 240);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Year Created: " + book.getYearCreated());
        System.out.println("Pages: " + book.getPages());
        System.out.println("Chapters: " + book.getChapters());
        System.out.println("ISRC: " + book.getISRC());
        System.out.println("Time (seconds): " + book.getTimeBySeconds());
        System.out.println("Price: $" + book.getPrice());
        System.out.println(book);
        System.out.println(book.toCSV());
    }
}
