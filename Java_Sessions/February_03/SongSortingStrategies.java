import java.util.Comparator;


public class SongSortingStrategies {

    public static class firstNameSort implements Comparator<Song> {
        public int compare(Song song1, Song song2) {
            String name1 = song1.getTitle();
            String name2 = song2.getTitle();
            return name1.compareTo(name2);
        }
    }

    public static class lastNameSort implements Comparator<Song> {
        public int compare(Song song1, Song song2) {
            String[] name1 = song1.getArtist().split(" ");
            String[] name2 = song2.getArtist().split(" ");

            return name1[name1.length - 1].compareTo(name2[name2.length - 1]);
        }
    }

    public static class lengthSort implements Comparator<Song> {

        public int compare(Song song1, Song song2) {
            Double length1 = song1.getLengthMinutes();
            Double length2 = song2.getLengthMinutes();
            //debugging
//            System.out.printf("\t\tcomparing %.3f to %.3f\n", length1, length2);
//            System.out.printf("\t\t\tlength 1 - length2 = %d\n", (int) (length1-length2));
            return length1.compareTo(length2);

//            return (int) (length1 - length2);
        }
    }

}
