package MediaLibraryApp;


import java.util.stream.Stream;

public interface Filterable {
    
    Stream<IMedia> filter(String filter);

    Stream<IMedia> filter(String filter, MediaData sortOn);

    Stream<IMedia> filter(String filter, MediaData sortOn, boolean asc);


    void resetFilter();


}
