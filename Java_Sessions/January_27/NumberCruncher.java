public class NumberCruncher {
    int randNumber;

    public NumberCruncher() {
        randNumber = (int)(Math.random() * 100);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int exponent(int a, int b) {
        int result = a;
        for (int i = 1; i < b; i++) {
            result = result * a;
        }
        return result;
    }

    public int randomMath(int a, int b){
        int selection = this.randNumber + a * b;

        if(selection % 3 == 0){
            return multiply(a, b);
        }else if (selection % 3 == 1){
            return subtract(a, b);
        }else{
            return exponent(a, b);
        }
    }

    public void doStuff(){
        return;
    }
}
