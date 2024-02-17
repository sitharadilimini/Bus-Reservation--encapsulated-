import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CustomerRegistration customerRegistration = new CustomerRegistration();
        BusRegistration busRegistration = new BusRegistration();
        busRegistration.initializeBuses(); // Initialize the buses
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n");
            System.out.println("1. Register Bus");
            System.out.println("2. Display Available Buses");
            System.out.println("3. Register Customer");
            System.out.println("4. Display registered customers");
            System.out.println("5. Make a Reservation");
            System.out.println("6. Display Reservations");
            System.out.println("7. Cancel Reservation");
            System.out.println("8. Change seat number");
            System.out.println("9. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            System.out.println("\n");

            switch (choice) {
                case 1:
                    System.out.println("------------BUS REGIATRATION--------------");
                    System.out.print("Enter Bus Number: ");
                    int busNumber = scanner.nextInt();
                    System.out.print("Enter Total Seats: ");
                    int totalSeats = scanner.nextInt();
                    System.out.print("Enter Starting Point: ");
                    String startPoint = scanner.next();
                    System.out.print("Enter Ending Point: ");
                    String endPoint = scanner.next();
                    System.out.print("Enter Starting Time: ");
                    String startTime = scanner.next();
                    System.out.print("Enter Fare: ");
                    double fare = scanner.nextDouble();
                    busRegistration.registerBus(busNumber, totalSeats, startPoint, endPoint, startTime, fare);
                    break;

                case 2:
                    System.out.println("------------VIEW REGIATERED BUSES--------------");
                    busRegistration.displayBuses();
                    break;

                case 3:
                    System.out.println("------------CUSTOMER REGISTRATION--------------");
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Mobile Number: ");
                    int mobileNumber = scanner.nextInt();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter City: ");
                    String city = scanner.next();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    customerRegistration.RegisteredCustomer(name, mobileNumber, email, city, age);
                    break;

                case 4:
                    customerRegistration.displayCustomer();
                    break;

                case 5:
                    Reservation.makeReservation(customerRegistration, busRegistration.buses, new Reservation());
                    break;

                case 6:
                    Reservation.displayReservations();
                    break;

                case 7:
                    Reservation.cancelReservation(new Reservation(), customerRegistration, null);
                    break;

                case 8:
                    Reservation.changeReservedSeat(new Reservation());
                    break;

                case 9:
                    System.out.println("Exiting the system. Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
