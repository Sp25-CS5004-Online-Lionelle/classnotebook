public enum MediaEnum {
    AUDIO_BOOK, BOOK, MUSIC;


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
