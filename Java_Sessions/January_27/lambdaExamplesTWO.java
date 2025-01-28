import java.util.ArrayList;
import java.util.function.Predicate;

public class lambdaExamplesTWO {


    public static void main(String[] args) {
        //create initial list of numbers
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            numList.add(i);
        }
        System.out.println("original list = " + numList);

        //define lambda functions to help us filter the list
        Predicate<Integer> isEven = (x) -> {return x % 2 == 0;};
        Predicate<Integer> luckyNumber = (x) -> {
            // random requirements for a number to be considered "lucky"
            if(x % 2 == 0 || x % 3 == 0){
                return x % 5 != 0;
            }else if(x % 7 == 0){
                return true;
            }

            return false;
        };

        //making a new list to hold the numbers that passed the predicate test
        ArrayList<Integer> filteredList = new ArrayList<>();

        //going through every number in our list
        for (Integer currNumber : numList) {
            //use our predicate to decide if we should keep the current number or not
            if (luckyNumber.test(currNumber)) {
                filteredList.add(currNumber);

                //using format specifier to right justify the number by 4 spaces
                System.out.printf("%4d passed!\n", currNumber);
            }
        }

        System.out.println("final filtered list = " + filteredList);
    }
}
