package MediaLibraryApp;
public enum MediaTypes {
    AUDIO_BOOK, BOOK, MUSIC;


    public static MediaTypes fromString(String type) {
        switch (type.toUpperCase()) {
            case "AUDIO_BOOK":
                return AUDIO_BOOK;
            case "BOOK":
                return BOOK;
            case "MUSIC":
                return MUSIC;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return name();
    }
}
