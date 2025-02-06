package MediaLibraryApp;
public class MusicMedia extends AbstractMedia implements IAudioMedia  {
    private String isrc; 
    private int timeBySeconds;

    private static final double price = .99;

    public MusicMedia(String title, String genre, int yearCreated, 
        String isrc, int timeBySeconds) {
        super(title, genre, yearCreated);
        this.isrc = isrc;
        this.timeBySeconds = timeBySeconds;
    }

    
    @Override
    public MediaTypes getType() {  // interface Media
        return MediaTypes.MUSIC;
    }

    @Override
    public int getTimeBySeconds() { // exists in AudioMedia
        return timeBySeconds;
    }

    @Override
    public String getISRC() { // exists in AudioMedia
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

    public static void main(String[] args) {
        MusicMedia music = new MusicMedia("Song Title", "Pop", 2023, "US-ABC-23-45678", 240);
        System.out.println("Title: " + music.getTitle());
        System.out.println("Genre: " + music.getGenre());
        System.out.println("Year Created: " + music.getYearCreated());
        System.out.println("ISRC: " + music.getISRC());
        System.out.println("Time (seconds): " + music.getTimeBySeconds());
        System.out.println("Price: $" + music.getPrice());
        System.out.println(music);
        System.out.println(music.toCSV());
    }
}
