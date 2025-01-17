public class Circle extends AbstractShape {
    private int radius;

    public Circle(int radius) {
        super(1);
        this.setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if(radius < 0) {
            throw new IllegalArgumentException("Radius must be non-negative");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", numSides=" + this.getNumSides() +
                ", colors=" + this.getColor()[0] + ", " + this.getColor()[1] + ", " + this.getColor()[2] +
                ", area=" + this.getArea() +
                "'}'";
    }
    
}
