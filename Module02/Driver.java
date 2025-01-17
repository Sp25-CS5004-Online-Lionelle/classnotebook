public class Driver {

    public static void main(String[] args) {
        // Shape s = new Shape(4);
        // s.setColor(255, 0, 0);
        // int[] colors = {255, 255, 255};
        // s.setColor(colors);
        // System.out.println(s); 
        // colors[0] = 100;
        // System.out.println(s); 
        // int[] newColors = s.getColor();
        // newColors[1] = 0;
        // System.out.println(s); 


        // int fromIndex = 9;
        // String s1 = "Mississippi";
        // System.out.println(s1.lastIndexOf("i", fromIndex));


        AbstractShape sq = new Square(10);

        System.out.println(sq);


        AbstractShape c = new Circle(5);

        System.out.println(c);

        AbstractShape[] shapes = new AbstractShape[2];
        shapes[0] = sq;
        shapes[1] = c;
        c.setColor(255, 0, 10);
        System.out.println("Shapes:");
        double total_area = 0;
        for(AbstractShape shape : shapes) {
            // if (shape instanceof Square)
            //     total_area += ((Square)shape).getArea();
            // else if (shape instanceof Circle)
            //     total_area += ((Circle)shape).getArea();
            total_area += shape.getArea();
        }
        System.out.println("Total area: " + total_area);
        

        Background b = new Background();

        b.addShape(sq);
        b.addShape(c);

        c.setColor(b);
        for(IColor color : b.getAllColors()) {
            System.out.println(color.getClass().getName() + " " + color.getColor()[0] + ", " + color.getColor()[1] + ", " + color.getColor()[2]);
        }
    }
    
}
