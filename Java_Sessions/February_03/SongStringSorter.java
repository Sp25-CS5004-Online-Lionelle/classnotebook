import java.util.Comparator;

public class SongStringSorter implements Comparator<Song> {
    SongQualities fieldToSort;

    public SongStringSorter(SongQualities fieldToSort){
        this.fieldToSort = fieldToSort;
    }

    public int compare(Song song1, Song song2) {
        String string1 ="";
        String string2 = "";

        if (this.fieldToSort == SongQualities.FIRSTNAME){
            string1 = song1.getArtist();
            string2 = song2.getArtist();
        } else if (this.fieldToSort == SongQualities.LASTNAME) {
            String[] name1 = song1.getArtist().split(" ");
            string1 = name1[name1.length - 1];

            String[] name2 = song2.getArtist().split(" ");
            string2 = name2[name2.length - 1];
        }

        //DEBUGGING
//        System.out.printf("\t\tcomparing %s to %s\n", string1, string2);
        return string1.compareTo(string2);
    }
}
