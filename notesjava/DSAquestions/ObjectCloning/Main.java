package letsgoDSA.cloning;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human(20, "Citiz Shrestha");
        Human twin =(Human) kunal.clone();
        System.out.println(kunal.age + " " + kunal.name);
        kunal.age = 22;
        twin.name = "Sycon";
        System.out.println(twin.age + " " + twin.name);
        System.out.println(kunal.age + " " + kunal.name);


    }
}
