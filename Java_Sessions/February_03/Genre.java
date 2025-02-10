public enum Genre {
    CLASSICAL, ROCK, POP, HEAVYMETAL, RAP, COUNTRY, HIPHOP, JAZZ, OPERA;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
