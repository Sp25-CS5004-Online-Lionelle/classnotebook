public class Rectangle {
    /** Length of the rectangle. */
    private int length;
    /** width of the rectangle. */
    private int width;


    /**
     * Creates a new rectangle with a length and width of 0.
     */
    public Rectangle() {
        this(0, 0);
    }

    /**
     * Creates a new rectangle with the specified length and width.
     * @param length the length of the rectangle
     * @param width the width of the rectangle
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Returns the length of the rectangle.
     * @return the length of the rectangle
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the width of the rectangle.
     * @return the width of the rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the length of the rectangle.
     * @param newLength the new length of the rectangle
     */
    public void setLength(int newLength) {
        if (newLength < 0) {
            System.err.println("Length cannot be negative. No black holes!");
            return;
        }
        this.length = newLength;
    }

    /**
     * Returns a string representation of the rectangle.
     * @return a string representation of the rectangle
     */
    public String toString() {
        return "Rectangle {Length: " + length + ", Width: " + width + "}";
    }

    /**
     * The main method to run the Rectangle class.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // turning off checkstyle as this just quick testing
        Rectangle r1 = new Rectangle();

        // 
        Rectangle r2 = new Rectangle(10, 20); 

        r2.setLength(-100);

        System.out.println(r1);
        System.out.println(r2);
        //CHECKSTYLE:ON
    }

}

