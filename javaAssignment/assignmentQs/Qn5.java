package assignmentQs;

 interface Resizable {
    void resize(int width, int height);
}
class Rectangle implements Resizable{
    private int width;
    private int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void display() {
        System.out.println("Displaying Rectangle");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
    @Override
    public void resize(int width, int height){
        this.width = width;
        this.height = height;
    }

}
public class Qn5 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(150, 100);
        System.out.println("Before  Rectangle");
        rectangle.display();
        System.out.println("After  Rectangle");
        rectangle.resize(200, 150);
        rectangle.display();
    }
}
