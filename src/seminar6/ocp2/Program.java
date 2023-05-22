package seminar6.ocp2;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new RightTriangle(2, 3));
        shapes.add(new Circle(4));

        double sumArea = 0;
        for (Shape shape: shapes) {
            sumArea += shape.getArea();
            /*if (shape instanceof RightTriangle) {
                RightTriangle triangle = (RightTriangle) shape;
                sumArea += triangle.getKatet1() * triangle.getKatet2() / 2.0;
            }
            if (shape instanceof Circle){
                Circle circle = (Circle) shape;
                sumArea += Math.PI *  Math.pow(circle.getRadius(), 2);
            }
            if (shape instanceof Square) {
                Square square = (Square) shape;
                sumArea += Math.pow(square.getSide(), 2);
            }*/
        }

        System.out.printf("Сумма площадей фигур равна %f \n", sumArea);

    }

}
