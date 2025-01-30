public abstract class AbstractMedia implements Media {

    private String title;
    private String genre;
    private int yearCreated;
    private int rating;
    
    public AbstractMedia(String title, String genre, int yearCreated) {
        this.title = title;
        this.genre = genre;
        this.yearCreated = yearCreated;
        this.rating = 0; // Default rating
    }

    @Override
    public int getYearCreated() {
        return yearCreated;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        if (rating >= MIN_RATING && rating <= MAX_RATING) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between " + MIN_RATING + " and " + MAX_RATING);
        }
    }

    @Override
    public double getPrice() {
        return getPrice(0);
    }

    @Override
    public double getPrice(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        return getPriceByType() * (1 - discount / 100.0);        
    }

    protected abstract double getPriceByType();


    @Override
    public String toString() {
        return "Type:" + getType() + ", Title: " + title + ", Genre: " + 
                genre + ", Year: " + yearCreated + ", Rating: " + rating;
    }

    public String toCSV() {
        return getType() + "," + title + "," + genre + "," + 
                yearCreated + "," + rating;
    }

}
