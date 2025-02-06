package MediaLibraryApp;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Library implements Filterable {
    private HashSet<IMedia> mediaList;

    public Library() {
        mediaList = new HashSet<>();
    }

    public void addMedia(IMedia media) {     
        mediaList.add(media);
    }

    public Stream<IMedia> getMediaList() {
        return mediaList.stream();
    }

    @Override
    public Stream<IMedia> filter(String filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public Stream<IMedia> filter(String filter, MediaData sortOn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public Stream<IMedia> filter(String filter, MediaData sortOn, boolean asc) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    @Override
    public void resetFilter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetFilter'");
    }

    @Override
    public Stream<IMedia> getFilteredMedia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilteredMedia'");
    }


   

}
