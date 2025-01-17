public class Square extends AbstractShape {
    private int sideLength;


    public Square(int sideLength) {
        super(4);
        this.setSideLength(sideLength);
    }


    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if(sideLength < 0) {
            throw new IllegalArgumentException("Side length must be non-negative");
        }
        this.sideLength = sideLength;
    }
    
    public double getArea() {
        return this.getSideLength() * this.getSideLength();
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", numSides=" + this.getNumSides() +
                ", colors=" + this.getColor()[0] + ", " + this.getColor()[1] + ", " + this.getColor()[2] +
                ", area=" + this.getArea() +
                "'}'";
    }
}
