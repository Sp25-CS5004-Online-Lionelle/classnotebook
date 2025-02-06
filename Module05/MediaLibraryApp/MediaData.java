package MediaLibraryApp;

public enum MediaData {

    TITLE, TYPE, GENRE, RATING;

    
    public static MediaData fromString(String value) {
        for(MediaData data : MediaData.values()) {
            if (data.toString().equalsIgnoreCase(value)) {
                return data;
            }
        }

        throw new IllegalArgumentException("No media with that type " + value);
    }

}