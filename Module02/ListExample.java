import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {


    public static void addToStart(List<Integer> list, int value) {
        list.add(0, value);
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for(int i = 0; i < 200000; i++) {
           addToStart(list, i);
        }

        System.out.println(list);
        
    }
}
