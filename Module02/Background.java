import java.util.ArrayList;
import java.util.List;

public class Background implements IColor {
    private int[] colors = {0, 0, 0};
    private int width = 1600;
    private int height = 900;
    List<AbstractShape> shapes = new ArrayList<AbstractShape>();

    public Background() {
    }

    public Background(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException("Width must be non-negative");
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if(height < 0) {
            throw new IllegalArgumentException("Height must be non-negative");
        }
        this.height = height;
    }

    @Override
    public void setColor(int r, int g, int b) {
        if (r + b + g > 255*3) {
            throw new IllegalArgumentException("Colors must be less than or equal to 255");
        }
        colors[0] = r;
        colors[1] = g;
        colors[2] = b;
    }

    @Override
    public void setColor(int[] colors) {
        if(colors.length != 3) {
            throw new IllegalArgumentException("Colors must be an array of length 3");
        }
        this.setColor(colors[0], colors[1], colors[2]);
    }

    @Override
    public int[] getColor() {
        int[] copy = new int[colors.length];
        for(int i = 0; i < colors.length; i++) {
            copy[i] = colors[i];
        }
        return copy;
    }
    
    public void addShape(AbstractShape shape) {
        // Add shape to background
        shapes.add(shape);
    }

    public List<IColor> getAllColors() {
        List<IColor> allColors = new ArrayList<IColor>();
        for (AbstractShape shape : shapes) {
            allColors.add(shape);
        }
        allColors.add(this);
        return allColors;
    }
}
