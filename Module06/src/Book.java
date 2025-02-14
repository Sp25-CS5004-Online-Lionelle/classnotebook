import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Book implements IBook {
    
    private String title;
    private String genre;
    private int year;
    private int rating;
    private String author;
    private int pages;
    private int chapters;
    private int id;


    public Book() {

    }

    public Book(int id, String title, String author, String genre, int year, 
        int pages, int chapters, int rating) {
       
        
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.chapters = chapters;
        this.rating = rating;
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
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book [id="+  id + ", author=" + author + ", chapters=" + chapters + ", genre=" + genre + ", pages=" + pages
                + ", rating=" + rating + ", title=" + title + ", year=" + year + "]";
    }

@   Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public BookRecord toRecord() {
        return new BookRecord(title, author, year, genre, rating, pages, chapters);
    }
  

  }
