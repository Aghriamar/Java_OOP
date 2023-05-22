package seminar6.ocp1;

public class SimpleDrawer {

    public void Draw(Shape shape){

        switch (shape.getShapeType()){
            case Circle -> {
                drawCircle(shape);
            }
            case Square -> {
                drawSquare(shape);
            }
        }

    }

    private void drawSquare(Shape shape){
        //...
    }

    private void drawCircle(Shape shape){
        //...
    }

}
