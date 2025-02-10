import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MusicSorter {
    private static final Scanner userInputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Song> allSongs = new ArrayList<Song>();

        Song fourSeasons = new Song("The Four Seasons Concerto", "Antonio Vivaldi", Genre.CLASSICAL, 2.13);
        Song jolene = new Song("Jolene", "Dolly Parton", Genre.CLASSICAL, 2.44);
        Song wreckingBall = new Song("Wrecking Ball", "Miley Cyrus", Genre.POP, 3.41);

        allSongs.add(wreckingBall);
        allSongs.add(fourSeasons);
        allSongs.add(jolene);

        boolean endProgram = false;

        while (!endProgram) {
            System.out.println("How do you want to sort?");
            System.out.println("1. Song Title\n2.Artist First Name\n3.Artist Last Name\n4.Length");
            int userChoice = userInputScanner.nextInt();

            List<Song> sortedList = allSongs;
            Song[] songArray = new Song[3];

            Comparator<Song> songTitleLambda = (Song s1, Song s2) -> { return s1.getTitle().compareTo(s2.getTitle());};

            switch (userChoice) {
                case 1:
                    sortedList = allSongs.stream().sorted(songTitleLambda).toList();
                    break;
                case 2:
                    sortedList = allSongs.stream()
                            .sorted(new SongStringSorter(SongQualities.FIRSTNAME))
                            .toList();
                    break;
                case 3:
                    sortedList = allSongs.stream()
                            .sorted(new SongStringSorter(SongQualities.LASTNAME))
                            .toList();
                    break;
                case 4:
                    sortedList = allSongs.stream().sorted(new SongSortingStrategies.lengthSort()).toList();
            }

            String firstSong = sortedList.get(0).toString();

            System.out.println(sortedList);

            System.out.println("Do you want to end the program? true or false");
            endProgram = userInputScanner.nextBoolean();
        }

    }
}
