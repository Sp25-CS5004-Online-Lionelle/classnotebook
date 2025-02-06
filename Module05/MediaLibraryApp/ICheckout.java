package MediaLibraryApp;

import java.util.List;
import java.util.stream.Stream;

public interface ICheckout {
    
    String ADD_ALL = "all";

    List<IMedia> getCart();

    void clear();

    int count();


    void addToCart(String str, Stream<IMedia> filtered) throws IllegalArgumentException;

    void removeFromCart(String str) throws IllegalArgumentException;

}
