package ModuleExamples;
public enum Mod05MediaTypes {
    AUDIO_BOOK("Audio Book"), BOOK("Book"), MUSIC("Music");

    private String display;

    private Mod05MediaTypes(String display) {
        this.display = display;
    }

    public static Mod05MediaTypes fromString(String type) {
        switch (type.toUpperCase()) {
            case "AUDIO_BOOK":
            case "AUDIO BOOK":
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
