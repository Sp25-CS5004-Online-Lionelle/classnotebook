package MediaLibraryApp;
public enum MediaTypes {
    AUDIO_BOOK("Audio Book"), BOOK("Book"), MUSIC("Music");

    private String display;

    private MediaTypes(String display) {
        this.display = display;
    }

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

    public String pretty() {
        return display;
    }
}
