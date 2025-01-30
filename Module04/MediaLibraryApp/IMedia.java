package MediaLibraryApp;
import java.util.List;

public interface IMedia {

    public static final int MAX_RATING = 5;
    public static final int MIN_RATING = 1;

    int getYearCreated();
    String getTitle();
    String getGenre();
    int getRating();
    void setRating(int rating);
    double getPrice();
    double getPrice(int discount);
    MediaTypes getType(); 


    static IMedia fromCSV(String csv) {
        String[] fields = csv.split(",");
        MediaTypes type = MediaTypes.valueOf(fields[0]);
        IMedia m = null;
        switch (type) {
            case BOOK:
                m = new Book(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
                break;
            case AUDIO_BOOK:
                m = new AudioBook(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[5]), fields[6], Integer.parseInt(fields[7]));
                break;
            case MUSIC:
                m = new MusicMedia(fields[1], fields[2], Integer.parseInt(fields[3]), fields[5], Integer.parseInt(fields[6]));
                break;
            default:
                m = null;
        }
        if(m != null) {
            try {
                m.setRating(Integer.parseInt(fields[4]));
            } catch (Exception e) {
              // invalid rating
            }
        }
        return m;
    }

    static IMedia fromList(List<String> values)  {
        IMedia m = null;
        MediaTypes type = MediaTypes.valueOf(values.get(0));

        switch (type) {
            case BOOK:
                m = new Book(values.get(1), values.get(2), Integer.parseInt(values.get(3)), 
                            Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5)));
                break;
            case AUDIO_BOOK:
                m = new AudioBook(values.get(1), values.get(2), Integer.parseInt(values.get(3)), 
                        Integer.parseInt(values.get(4)), 
                        values.get(5), Integer.parseInt(values.get(6)));
                break;
            case MUSIC:
                m = new MusicMedia(values.get(1), values.get(2), Integer.parseInt(values.get(3)), 
                                  values.get(4), Integer.parseInt(values.get(5)));
                break;
            default:
                m = null;
        }
        return m;
    }
}
