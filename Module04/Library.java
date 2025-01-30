import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Library {
    private List<IMedia> mediaList;

    public Library() {
        mediaList = new LinkedList<>();
    }

    public void addMedia(IMedia media) {
        mediaList.add(media);
    }

    public Stream<IMedia> getMediaList() {
        return mediaList.stream();
    }

    public List<IMedia> getMatchingTitles(String title) {
       Stream<IMedia> st = mediaList.stream()
                .filter(media -> media.getTitle().contains(title))
                .filter(media -> media.getRating() > 1);
       return st.toList();
    }

    public List<IMedia> getSortedByGenre() {
        return mediaList.stream()
//                .sorted((m1, m2) -> m1.getGenre().toLowerCase().compareTo(m2.getGenre().toLowerCase()))
                .sorted((m1, m2) -> {
                    String lowerM1 = m1.getGenre().toLowerCase();
                    String lowerM2 = m2.getGenre().toLowerCase();
                    return lowerM1.compareTo(lowerM2);
                })
                .toList();
    }

   

}
