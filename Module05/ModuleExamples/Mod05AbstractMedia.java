package ModuleExamples;
public abstract class Mod05AbstractMedia implements Mod05IMedia, Comparable<Mod05AbstractMedia> {

    private String title;
    private String genre;
    private int yearCreated;
    private int rating;
    
    public Mod05AbstractMedia(String title, String genre, int yearCreated) {
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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) { // potential gotcha
            return false;
        }
        Mod05AbstractMedia other = (Mod05AbstractMedia) obj;
        return this.getType().equals(other.getType()) && 
                this.title.equals(other.title) && 
                this.genre.equals(other.genre) && 
                this.yearCreated == other.yearCreated;
    }

    @Override
    public int hashCode() {
        return getType().hashCode() + title.hashCode() + genre.hashCode() + yearCreated;
    }

    @Override
    public String toString() {
        return "Type:" + getType() + ", Title: " + title + ", Genre: " + 
                genre + ", Year: " + yearCreated + ", Rating: " + rating;
    }

    @Override
    public String toCSV() {
        return getType() + "," + title + "," + genre + "," + 
                yearCreated + "," + rating;
    }

    @Override
    public String pretty() {
        return String.format("%s, (%d), Format: (%s)", getTitle(), getRating(), getType().pretty());
    }

    @Override
    public int compareTo(Mod05AbstractMedia o) {
        int compare = this.title.compareTo(o.title);
        if(compare == 0) {
            compare = this.getType().toString().compareTo(o.getType().toString());
        }
        return compare;
    }
}
