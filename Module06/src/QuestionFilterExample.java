import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class QuestionFilterExample {
    
    
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("hello", "world", "java", "programming", "is", "fun"));

        List<String> wordsCurrent = List.copyOf(words);  // you will have at least instance variables in Planner - the original, and the list

        Stream<String> stream = wordsCurrent.stream()
                .filter(word -> word.length() > 3);

        wordsCurrent = stream.map(word -> word.toUpperCase()).toList();

        wordsCurrent.stream().filter(word -> word.length() > 4)
                .forEach(System.out::println);
      


    }
}
