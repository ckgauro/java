public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        shape1 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape1.draw();

        //get an object of Square and call its draw method.
        shape1 = shapeFactory.getShape("SQUARE");
        shape1.draw();
        
        shape1 = shapeFactory.getShape("TRIANGLE");

        //call draw method of square
        shape1.draw();
    }
}
