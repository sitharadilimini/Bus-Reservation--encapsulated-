import java.util.ArrayList;
import java.util.Scanner;

// Added new extends
public class Reservation extends ReservationDto {

    // Queue implementation for reservation
    static int front = -1;
    static int rear = -1;
    static int capacity = 40;
    static Reservation[] queue = new Reservation[capacity];
    static Scanner scanner = new Scanner(System.in);

    // method to make reservation
    public static void makeReservation(CustomerRegistration customerRegistration, ArrayList<Bus> buses,
            Reservation reservation) {
        System.out.println("------------MAKE RESERVATION--------------");
        System.out.print("Enter Customer Name: ");
        String name = scanner.next();
        System.out.print("Enter Customer Email: ");
        String email = scanner.next();
        System.out.print("Enter Bus Number: ");
        int busNumber = scanner.nextInt();
        System.out.print("Enter Seat Number: ");
        int seatNumber = scanner.nextInt();

        boolean customerFound = false;
        boolean busFound = false;

        // Check if customer is registered
        for (Customer customer : customerRegistration.customerStack) {
            if (customer != null && customer.getName().equals(name) && customer.getEmail().equals(email)) {
                customerFound = true;
                break;
            }
        }

        // Check if bus number is valid and seat number is available
        if (!customerFound) {
            System.out.println("Customer is not registered!");
            return;
        }

        // Check if bus number is valid and seat number is available
        for (Bus bus : buses) {
            if (bus != null && bus.busNumber == busNumber) {
                busFound = true;
                if (seatNumber <= bus.totalSeats) {
                    reservation.setCustomerName(name);
                    reservation.setCustomerEmail(email);
                    reservation.setBusNumber(busNumber);
                    reservation.setSeatNumber(seatNumber);
                    System.out.println("-------------------------------------------------");
                    enqueue(reservation);
                }
                // Display error message if seat number is invalid
                else {
                    System.out.println("Seat number is invalid!");
                }
                break;
            }
        }

        // Display error message if bus number is invalid
        if (!busFound) {
            System.out.println("Bus number is invalid!");
        }
    }

    // method to display reservations
    public static void displayReservations() {
        System.out.println("------------DISPLAY RESERVATIONS--------------");
        // Check if no reservations are made yet
        if (front == -1 || front > rear) {
            System.out.println("No reservations made yet!");
        } else {
            System.out.println("Reservations:");
            for (int i = front; i <= rear; i++) {
                Reservation reservation = queue[i];
                if (reservation != null) { // Fix: Added null check
                    System.out.println("Reservation " + (i - front + 1) + ":");
                    System.out.println("Customer Name: " + reservation.getCustomerName());
                    System.out.println("Customer Email: " + reservation.getCustomerEmail());
                    System.out.println("Bus Number: " + reservation.getBusNumber());
                    System.out.println("Seat Number: " + reservation.getSeatNumber());
                    System.out.println("---------------------");
                }
            }
        }
    }

    // method to cancel reservation
    public static void cancelReservation(Reservation reservation, CustomerRegistration customerRegistration,
            ArrayList<Bus> buses) {
        System.out.println("------------CANCEL RESERVATION--------------");
        System.out.print("Enter Customer Email: ");
        String email = scanner.next();
        System.out.print("Enter Bus Number: ");
        int busNumber = scanner.nextInt();
        System.out.print("Enter Seat Number: ");
        int seatNumber = scanner.nextInt();

        // Check if no reservations are made yet
        if (front == -1 || front > rear) {
            System.out.println("No reservation made yet!");
        } else {
            for (int i = front; i <= rear; i++) {
                Reservation currentReservation = queue[i];
                if (currentReservation != null && currentReservation.getCustomerEmail().equals(email)
                        && currentReservation.getBusNumber() == busNumber
                        && currentReservation.getSeatNumber() == seatNumber) {
                    dequeue();
                    System.out.println("A new seat is available for another customer!");
                    return;
                }
            }
            System.out.println("Reservation not found!");
        }
    }

    // method to change reserved seat
    public static void changeReservedSeat(Reservation reservation) {
        System.out.println("------------CHANGE RESERVED SEAT--------------");
        System.out.print("Enter Customer Email: ");
        String email = scanner.next();
        System.out.print("Enter Bus Number: ");
        int busNumber = scanner.nextInt();
        System.out.print("Enter Current Seat Number: ");
        int currentSeatNumber = scanner.nextInt();

        // Check if no reservations are made yet
        if (front == -1 || front > rear) {
            System.out.println("No reservation made yet!");
        } else {
            for (int i = front; i <= rear; i++) {
                Reservation currentReservation = queue[i];
                if (currentReservation != null && currentReservation.getCustomerEmail().equals(email)
                        && currentReservation.getBusNumber() == busNumber
                        && currentReservation.getSeatNumber() == currentSeatNumber) {
                    System.out.print("Enter New Seat Number: ");
                    int newSeatNumber = scanner.nextInt();
                    if (isSeatAvailable(busNumber, newSeatNumber)) {
                        currentReservation.setSeatNumber(newSeatNumber);
                        System.out.println("--------------------------------");
                        System.out.println("Seat changed successfully!");
                    } else {
                        System.out.println("New seat is not available!");
                    }
                    return;
                }
            }
            System.out.println("Reservation not found!");
        }
    }

    // method to check if a seat is available
    private static boolean isSeatAvailable(int busNumber, int seatNumber) {
        for (int i = front; i <= rear; i++) {
            Reservation reservation = queue[i];
            if (reservation != null && reservation.getBusNumber() == busNumber
                    && reservation.getSeatNumber() == seatNumber) {
                return false;
            }
        }
        return true;
    }

    // method to enqueue reservation
    public static void enqueue(Reservation reservationQueue) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            queue[rear] = reservationQueue;
            System.out.println("Reservation added successfully!");
        }
    }

    // method to dequeue reservation
    public static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("No reservation made yet!");
        } else {
            System.out.println("Reservation canceled successfully!");
            front++;
            if (front > rear) { // Reset front and rear if all reservations are removed
                front = rear = -1;
            }
        }
    }
}
