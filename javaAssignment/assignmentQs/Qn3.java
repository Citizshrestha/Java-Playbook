package assignmentQs;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Student {
    String name, contact, address, dateofbirth;
    int age;
    double totalMarks;


    public void getInfo(Scanner sc) {
        System.out.println("Enter the name of the student");
        name = sc.nextLine();
        System.out.println("Enter the age of the student");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the contact of the student");
        contact = sc.nextLine();
        System.out.println("Enter the address of the student");
        address = sc.nextLine();
        System.out.println("Enter the total marks of the student");
        totalMarks = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the date of birth of the student");
        dateofbirth = sc.nextLine();
    }
    public void displayInfo() {
        System.out.println("Student Details");
        System.out.println(" Name: " + name);
        System.out.println(" Age: " + age);
        System.out.println(" Contact: " + contact);
        System.out.println(" Address: " + address);
        System.out.println(" Total Marks: " + totalMarks);
        System.out.println(" Date of Birth: " + dateofbirth);
    }

    public void calcAge(){
        LocalDate dob = LocalDate.parse(dateofbirth);
        LocalDate now = LocalDate.now();
        Period age = Period.between(dob, now);

        this.age = age.getYears();
        System.out.println("Age is " + age.getYears());
    }

    public void evaluateGrade(){
        if (totalMarks >= 90){
            System.out.println("Your grade is A+");
        } else if (totalMarks >= 80 && totalMarks < 90){
            System.out.println("Your grade is A-");
        } else if (totalMarks >= 70 && totalMarks < 80){
            System.out.println("Your grade is B+");
        } else if (totalMarks >= 60 && totalMarks < 70) {
            System.out.println("Your grade is B");
        } else if (totalMarks >= 50 && totalMarks < 60) {
            System.out.println("Your grade is C+");
        } else if (totalMarks >= 40 && totalMarks < 50) {
            System.out.println("Your grade is C");
        } else if (totalMarks >= 30 && totalMarks < 50) {
            System.out.println("Your grade is D+");
        } else {
            System.out.println("Better luck next time Mr"+ name + "You have failed");
        }
    }
}
public class Qn3 {

    public static void main(String[] args) {
     Student stObj = new Student();
     stObj.getInfo(new Scanner(System.in));
     stObj.displayInfo();
     stObj.calcAge();
     stObj.evaluateGrade();
    }
}
