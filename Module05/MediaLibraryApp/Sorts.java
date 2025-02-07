package MediaLibraryApp;

import java.util.Comparator;

public class Sorts {
    public static Comparator<IMedia> getSortType(MediaData sortOn, boolean asc) {
        switch(sortOn) {
            case TITLE:
                return asc ? new SortByTitle() : new SortByTitleDesc();
            case GENRE:
                return (o1, o2) -> {
                    int compare = o1.getGenre().compareTo(o2.getGenre());
                    return asc ? compare : -compare;
                };

            case RATING:
                return (o1, o2) -> {
                    int compare = o1.getRating() - o2.getRating();
                    return asc ? compare : -compare;
                };

            case TYPE:

                return (o1, o2) -> {
                    int compare = o1.getType().compareTo(o2.getType());
                    return asc ? compare : -compare;
                };
        
            default:
                return (o1, o2) -> 0;


        }

    }

    public static class SortByTitle implements Comparator<IMedia> {
        @Override
        public int compare(IMedia o1, IMedia o2) {
            int compare = o1.getTitle().compareTo(o2.getTitle());
            if (compare == 0) {
                compare = o1.getType().compareTo(o2.getType());
            }
            return compare;
        }
    }

    public static class SortByTitleDesc implements Comparator<IMedia> {
        @Override
        public int compare(IMedia o1, IMedia o2) {
            int compare = o2.getTitle().compareTo(o1.getTitle());
            if (compare == 0) {
                compare = o2.getType().compareTo(o1.getType());
            }
            return compare;
        }
    }
}
