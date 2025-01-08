public class Rectangle {
    private int length;
    private int width;


    public Rectangle() {
        this(0, 0);
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int newLength){
        if (newLength < 0) {
            System.err.println("Length cannot be negative. No black holes!");
            return;
        }
        this.length = newLength;
    }

    public String toString() {
        return "Rectangle {Length: " + length + ", Width: " + width + "}";
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(10, 20);

        r2.setLength(-100);
        
        System.out.println(r1);
        System.out.println(r2);

    }

}