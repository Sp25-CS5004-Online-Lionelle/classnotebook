public class Shape  {
    private int numSides;
    private final int[] colors = {0, 0, 0};

    public Shape(int numSides) {
        this.numSides = numSides;
    }

    public int getNumSides() {
        return numSides;
    }


    public void setColor(int r, int g, int b) {
        colors[0] = r;
        colors[1] = g;
        colors[2] = b;
    }

    public void setColor(int[] colors) {
        if(colors.length != 3) {
            throw new IllegalArgumentException("Colors must be an array of length 3");
        }
        this.setColor(colors[0], colors[1], colors[2]);
    }


    public int[] getColor() {
        int[] copy = new int[colors.length];
        for(int i = 0; i < colors.length; i++) {
            copy[i] = colors[i];
        }
        return copy;
    }

   


    @Override
    public String toString() {
        return "Shape{" +
                "numSides=" + numSides +
                ", colors=" + colors[0] + ", " + colors[1] + ", " + colors[2] +
                "'}'";
    }

}
