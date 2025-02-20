
public interface IBook {
    public static final int MAX_RATING = 5;
    public static final int MIN_RATING = 1;

    int getYear();
    void setYear(int year);
    String getTitle();
    void setTitle(String title);
    String getGenre();
    void setGenre(String genre);
    int getRating();
    void setRating(int rating);
    int getPages();
    void setPages(int pages);
    int getChapters();
    void setChapters(int chapters);
    String getAuthor();
    void setAuthor(String author);

    record BookRecord(String title, String author, int year, String genre, int rating, int pages, int chapters) {}
    
}
