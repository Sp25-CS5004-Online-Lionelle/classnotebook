public class Song{
    private String title;
    private String artist;
    private Genre mainGenre;
    private Genre secondaryGenre;
    private double lengthMinutes;

    public Song(String title, String artist){
        this(title, artist, null, null, 0);
    }

    public Song(String title, String artist, Genre mainGenre, double lengthMinutes) {
        this(title, artist, mainGenre, null, lengthMinutes);
    }

    public Song(String title, String artist, Genre mainGenre, Genre secondaryGenre, double lengthMinutes) {
        this.title = title;
        this.artist = artist;
        this.mainGenre = mainGenre;
        this.secondaryGenre = secondaryGenre;
        this.lengthMinutes = lengthMinutes;
    }

    public String getArtist() {
        return artist;
    }

//    public void setArtist(String artist) {
//        this.artist = artist;
//    }

    public String getTitle() {
        return title;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Genre getMainGenre() {
        return mainGenre;
    }

//    public void setMainGenre(Genre mainGenre) {
//        this.mainGenre = mainGenre;
//    }

    public Genre getSecondaryGenre() {
        return secondaryGenre;
    }

//    public void setSecondaryGenre(Genre secondaryGenre) {
//        this.secondaryGenre = secondaryGenre;
//    }

    public double getLengthMinutes() {
        return lengthMinutes;
    }

//    public void setLengthMinutes(double lengthMinutes) {
//        this.lengthMinutes = lengthMinutes;
//    }


    @Override
    public String toString(){
        return String.format("%s %s %s %s %f", title, artist, mainGenre, secondaryGenre, lengthMinutes);
    }
}