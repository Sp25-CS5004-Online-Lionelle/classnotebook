package MediaLibraryApp;

public final class Filters {

    private Filters() {}

    public static boolean filter(IMedia media, MediaData column, Operations op, String value) {
        switch (column) {
            case TITLE:
                return filterString(media.getTitle(), op, value);
            case GENRE:
                return filterString(media.getGenre(), op, value);
            case RATING:
                return filterNumber(media.getRating(), op, value);
            case TYPE:
                return filterString(media.getType().toString(), op, value);
            default:
                return false;
        }        
    }

    private static boolean filterString(String mediaValue, Operations op, String value) {
        mediaValue = mediaValue.toLowerCase();
        value = value.toLowerCase();
        switch (op) {
            case EQUALS:
                return mediaValue.equalsIgnoreCase(value);
            case NOT_EQUALS:
                return !mediaValue.equalsIgnoreCase(value);
            case CONTAINS:
                return mediaValue.contains(value);
            case GREATER_THAN:
                return mediaValue.compareTo(value) > 0;
            case GREATER_THAN_EQUALS:
                return mediaValue.compareTo(value) >= 0;
            // and on down the line
            default:
                return false;
        }
    }

    private static boolean filterNumber(double mediaValue, Operations op, String value) {
        double filterValue;
        try {
            filterValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        switch (op) {
            case EQUALS:
                return mediaValue == filterValue;
            case NOT_EQUALS:
                return mediaValue != filterValue;
            case GREATER_THAN:
                return mediaValue > filterValue;
            case GREATER_THAN_EQUALS:
                return mediaValue >= filterValue;
            case LESS_THAN:
                return mediaValue < filterValue;
            case LESS_THAN_EQUALS:
                return mediaValue <= filterValue;
            default:
                return false;
        }
    }
    
}
