import java.util.Scanner;

public class myProgram {
    private static final Scanner userInputScanner = new Scanner(System.in);

    public static void main(String[] args){
//        simpleFormattingExample();

//        doubleFormattingExample();
//
        numberFormattingExample();
    }

    //create our message by using String.format one time
    public static void simpleFormattingExample(){
        System.out.println("Please enter a name:");
        String petName = userInputScanner.nextLine();

        System.out.println("Please enter an age:");
        int petAge = userInputScanner.nextInt();

        System.out.println("Please enter a decimal:");
        float petEnergy = userInputScanner.nextFloat();

        //option 1 - type out a string literal for the "base" then use variables for the values
        String petMessage = String.format("%s is %d years old and their energy level is at %f %%", petName, petAge, petEnergy);
        System.out.println(petMessage);

        //option 2 - use variables for everything
        String petMessageFormat = "%s is %d years old and their energy level is at %f %%";
        petMessage = String.format(petMessageFormat, petName, petAge, petEnergy);
        System.out.println(petMessage);
    }

    //create our message by using String.format twice
    public static void doubleFormattingExample(){
        System.out.println("Please enter an amount of money:");

        float moneyAmount = userInputScanner.nextFloat();

        float taxRate = 10.5f;

        String taxesFormat = "you have %f dollars so you will be paying %%f dollars in taxes";
        System.out.println("\t"+ taxesFormat);

        // put the variables we currently have into our taxesFormat string
        String taxMessageBase = String.format("you have %f dollars so you will be paying %%f dollars in taxes", moneyAmount);
        System.out.println("\t"+ taxMessageBase);

        // calculate how much is paid in tax
        float taxesPaid = taxRate * moneyAmount;

        // now we have all the values we can finish the message
        String taxMessageComplete = String.format(taxMessageBase, taxesPaid);
        System.out.println("\t"+ taxMessageComplete);
    }

    //special formatting for numbers
    public static void numberFormattingExample(){
        System.out.println("Please enter a number:");
        float number = userInputScanner.nextFloat();

        //lets round to the 2nd decimal place
        String twoDecimals = "original number was %f but now we're going to round and get %.2f\n";
        System.out.printf(twoDecimals, number, number);

        //now lets round to the 4th decimal place
        String fourDecimals = "original number was %f but now we're going to round and get %.4f\n";
        System.out.printf(fourDecimals, number, number);

        //now lets right justify
        System.out.printf("padding with 12 and no rounding:\n%12f\n", number);

        //now lets right justify AND round to the 3rd decimal place
        System.out.printf("padding with 12 and rounding to 3rd decimal:\n%12.3f\n", number);

        //resource for more detailed things you can do with String.format
        //https://www.homeandlearn.co.uk/java/java_formatted_strings.html#:~:text=To%20get%20the%20left%2Djustified,except%20for%20the%20minus%20sign.
    }

}
