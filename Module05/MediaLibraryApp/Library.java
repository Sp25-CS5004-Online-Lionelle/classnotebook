package MediaLibraryApp;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Library implements Filterable {
    private HashSet<IMedia> mediaList;
    private List<IMedia> filteredMediaList;

    
    public Library() {
        mediaList = new HashSet<>();
        filteredMediaList = new LinkedList<>();
    }

    public void addMedia(IMedia media) {     
        mediaList.add(media);
        filteredMediaList.add(media);
    }

    public Stream<IMedia> getMediaList() {
        return mediaList.stream().sorted(new Sorts.SortByTitle());
    }

    @Override
    public Stream<IMedia> filter(String filter) {
        return filter(filter, MediaData.TITLE);
    }

    @Override
    public Stream<IMedia> filter(String filter, MediaData sortOn) {
        return filter(filter, sortOn, true);
    }

    @Override
    public Stream<IMedia> filter(String filter, MediaData sortOn, boolean asc) {
        String[] filters = filter.split(",");
        for (String f : filters) {
            filteredMediaList = filterSingle(f).toList();
        }
        return  filteredMediaList.stream().sorted(Sorts.getSortType(sortOn, asc));
    }

    private Stream<IMedia> filterSingle(String filter) {
        filter = filter.replaceAll(" ", "");
        Operations op = Operations.getOperatorFromStr(filter);
        if (op == null) {
            return filteredMediaList.stream();
        }
        String[] parts = filter.split(op.getOperator());
        if (parts.length != 2) {
            return filteredMediaList.stream();
        }
        MediaData column = MediaData.fromString(parts[0].trim());
        if (column == null) {
            return filteredMediaList.stream();
        }
        String value = parts[1].trim();
        filteredMediaList = filteredMediaList.stream().filter(media -> Filters.filter(media, column, op, value)).toList();



        return filteredMediaList.stream();
    }

    @Override
    public void resetFilter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resetFilter'");
    }



   

}
