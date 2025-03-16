package assignmentQs;

class Vehicle{
    public void start(){
        System.out.println("Vehicle is ready to get started");
    }
}
class Car extends Vehicle{
    @Override
    public void start(){
        System.out.println("Car is getting ready for start");
    }
}
public class Qn4 {

    public static void main(String[] args) {
        Vehicle vh = new Vehicle();
        vh.start();
        Car car = new Car();
        car.start();
    }

}
