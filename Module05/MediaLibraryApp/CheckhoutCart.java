package MediaLibraryApp;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class CheckhoutCart implements ICheckout{
    private Set<IMedia> cart;

    public CheckhoutCart() {
        cart = new TreeSet<>(Sorts.getSortType(MediaData.TITLE, true));
    }

    @Override
    public List<IMedia> getCart() {
        return List.copyOf(cart);
    }

    @Override
    public void clear() {
        cart.clear();
    }

    @Override
    public int count() {
        return cart.size();
    }

    @Override
    public void addToCart(String str, Stream<IMedia> filtered) throws IllegalArgumentException {
        if(str.equalsIgnoreCase(ADD_ALL)) {
            filtered.forEach(cart::add);
        } else {
            List<IMedia> list = List.copyOf(filtered.toList());
            // note this only finds the first - really, in this case it would make sense to find all ... however, the instructions are to find the first
            IMedia media = list.stream().filter(m -> m.getTitle().toLowerCase().contains(str.toLowerCase())).findFirst().orElse(null);
            if(media != null) {
                cart.add(media);
            }else {
                int[] range = getRange(str, list.size());
                if(range != null) {
                    list.stream().skip(range[0]-1).limit(range[1] - range[0] + 1).forEach(cart::add);
                } else {
                    throw new IllegalArgumentException("Invalid input");
                }
            }
        }
    }

    private int[] getRange(String str, int max) {
       
        int start = 0;
        int end = max;
        String[] parts = str.split("-");
        if(parts.length != 2) {
            try {
                start = Integer.parseInt(str);
                return new int[] {start, start};
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input");
            } 
        }
        try {
            start = Integer.parseInt(parts[0]);
            int endP = Integer.parseInt(parts[1]);
            if (start > endP) {
                throw new IllegalArgumentException("Invalid input");
            }
            end = max > 0 ? Math.min(endP, max) : endP;
            return new int[] {start, end};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    @Override
    public void removeFromCart(String str) throws IllegalArgumentException {
        List<IMedia> list = List.copyOf(cart);
        IMedia media = list.stream().filter(m -> m.getTitle().toLowerCase().contains(str.toLowerCase())).findFirst().orElse(null);
        if(media != null) {
            cart.remove(media);
        }else {
            int[] range = getRange(str, 0);
            if(range != null && range[1] <= list.size()) {
                list.stream().skip(range[0]-1).limit(range[1] - range[0] + 1).forEach(cart::remove);
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        }
        
    }
    
}
