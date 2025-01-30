public interface Media {

    public static final int MAX_RATING = 5;
    public static final int MIN_RATING = 1;

    int getYearCreated();
    String getTitle();
    String getGenre();
    int getRating();
    void setRating(int rating);
    double getPrice();
    double getPrice(int discount);
    MediaEnum getType(); 


    static Media fromCSV(String csv) {
        String[] fields = csv.split(",");
        MediaEnum type = MediaEnum.valueOf(fields[0]);
        Media m = null;
        switch (type) {
            case BOOK:
                m = new Book(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
                break;
            case AUDIO_BOOK:
                m = new AudioBook(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[6]), Integer.parseInt(fields[6]), fields[7], Integer.parseInt(fields[8]));
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
}
