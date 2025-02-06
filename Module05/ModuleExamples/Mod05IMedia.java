package ModuleExamples;

public interface Mod05IMedia {

    public static final int MAX_RATING = 5;
    public static final int MIN_RATING = 1;

    int getYearCreated();
    String getTitle();
    String getGenre();
    int getRating();
    void setRating(int rating);
    double getPrice();
    double getPrice(int discount);
    Mod05MediaTypes getType(); 
    String toCSV();
    String pretty(); // for pretty printing


   
}
