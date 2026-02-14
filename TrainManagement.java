import java.util.ArrayList;
import java.util.Scanner;

class Train {
    int trainNo;
    String trainName;
    String source;
    String destination;

   
    public Train(int trainNo, String trainName, String source, String destination) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
    }

   
    public String toString() {
        return "Train No: " + trainNo +
               ", Name: " + trainName +
               ", Source: " + source +
               ", Destination: " + destination;
    }
}

public class TrainManagement {

    static ArrayList<Train> trains = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("TRAIN MANAGEMENT SYSTEM ");
            System.out.println("1. Add New Train");
            System.out.println("2. Display All Trains");
            System.out.println("3. Update Train");
            System.out.println("4. Remove Train");
            System.out.println("5. Track Train");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addTrain();break;
                case 2:displayTrains();break;
                case 3:updateTrain(); break;
                case 4:removeTrain();break;
                case 5:trackTrain();break;
                case 6:System.out.println("Exiting Program...");return;
                default:System.out.println("Invalid Choice!");
            }
        }
    }

    
    static void addTrain() {
        System.out.print("Enter Train No: ");
        int no = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Train Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Source Station: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination: ");
        String dest = sc.nextLine();

        trains.add(new Train(no, name, source, dest));
        System.out.println("Train Added Successfully!");
    }

    
    static void displayTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains available.");
            return;
        }

        for (Train t : trains) {
            System.out.println(t);
        }
    }
    static void updateTrain() {
        System.out.print("Enter Train No to Update: ");
        int no = sc.nextInt();
        sc.nextLine();

        for (Train t : trains) {
            if (t.trainNo == no) {
                System.out.print("Enter New Train Name: ");
                t.trainName = sc.nextLine();

                System.out.print("Enter New Source: ");
                t.source = sc.nextLine();

                System.out.print("Enter New Destination: ");
                t.destination = sc.nextLine();

                System.out.println("Train Updated Successfully!");
                return;
            }
        }
        System.out.println("Train Not Found!");
    }
    static void removeTrain() {
        System.out.print("Enter Train No to Remove: ");
        int no = sc.nextInt();

        for (Train t : trains) {
            if (t.trainNo == no) {
                trains.remove(t);
                System.out.println("Train Removed Successfully!");
                return;
            }
        }
        System.out.println("Train Not Found!");
    }
    static void trackTrain() {
        System.out.print("Enter Train No to Track: ");
        int no = sc.nextInt();

        for (Train t : trains) {
            if (t.trainNo == no) {
                System.out.println("Train Found:");
                System.out.println(t);
                return;
            }
        }
        System.out.println("Train Not Found!");
    }
}
