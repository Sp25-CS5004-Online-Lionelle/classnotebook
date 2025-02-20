import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Book {
    
    private String title;
    private String genre;
    private int year;
    private int rating;
    private String author;
    private int pages;
    private int chapters;
    private String id;


    public Book() {

    }

    public Book(String id, String title, String author, String genre, int year, 
        int pages, int chapters, int rating) {
       
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.chapters = chapters;
        this.rating = rating;
    }

   
    public int getPages() {
        return pages;
    }

    public int getChapters() {
        return chapters;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book [id="+  id + ", author=" + author + ", chapters=" + chapters + ", genre=" + genre + ", pages=" + pages
                + ", rating=" + rating + ", title=" + title + ", year=" + year + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public BookRecord toRecord() {
        return new BookRecord(id, title, author, year, genre, rating, pages, chapters);
    }
  

  }
