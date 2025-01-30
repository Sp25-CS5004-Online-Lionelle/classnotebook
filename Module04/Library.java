import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Library {
    private List<Media> mediaList;

    public Library() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public List<Media> getMatchingTitles(String title) {
       Stream<Media> st = mediaList.stream()
                .filter(media -> media.getTitle().contains(title))
                .filter(media -> media.getRating() > 1);
       return st.toList();
    }

    public List<Media> getSortedByGenre() {
        return mediaList.stream()
//                .sorted((m1, m2) -> m1.getGenre().toLowerCase().compareTo(m2.getGenre().toLowerCase()))
                .sorted((m1, m2) -> {
                    String lowerM1 = m1.getGenre().toLowerCase();
                    String lowerM2 = m2.getGenre().toLowerCase();
                    return lowerM1.compareTo(lowerM2);
                })
                .toList();
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addMedia(new Book("Digital Book Title", "Fiction", 2023, 300, 12));
        library.addMedia(new MusicMedia("Song Title", "Pop", 2023, "US-ABC-23-45678", 240));
        library.addMedia(new Book("Digital Song Book Title", "non-Fiction", 2023, 100, 3));
        
        for (Media media : library.getMediaList()) {
            media.setRating(3);
            System.out.println(media);
        }
        System.out.println();
        for (Media media : library.getMatchingTitles("Song")) {
            System.out.println(media);
        }
        System.out.println();


        library.getSortedByGenre().forEach(System.out::println);

        System.out.println();
        List<String> lines = new LinkedList<>();
        lines.add("BOOK,The Great Gatsby,Fiction,1925,1,180,11");
        lines.add("MUSIC,Bohemian Rhapsody,Rock,1975,2,US-ABC-23-45678,354");
        lines.add("AUDIO_BOOK,The Great Gatsby,Fiction,1925,3,0,180,US-ABC-23-45678,354");

        for (String line : lines) {
            Media media = Media.fromCSV(line);
            library.addMedia(media);
        }
        
        library.getMediaList().forEach(System.out::println);

    }

}
