import java.util.ArrayList;

class BusRegistration {
    ArrayList<Bus> buses = new ArrayList<Bus>();

    public void initializeBuses() {
        buses.add(new Bus(1, 50, "City A", "City B", "08:00 AM", 25.50));
        buses.add(new Bus(2, 40, "City B", "City C", "10:30 AM", 30.00));
        buses.add(new Bus(3, 30, "City C", "City D", "01:00 PM", 20.75));
    }

    public void registerBus(int busNumber, int totalSeats, String startPoint, String endPoint, String startTime,
            double fare) {
        Bus bus = new Bus();
        bus.setBusNumber(busNumber);
        bus.setTotalSeats(totalSeats);
        bus.setStartPoint(startPoint);
        bus.setEndPoint(endPoint);
        bus.setStartTime(startTime);
        bus.setFare(fare);
        buses.add(bus);
        System.out.println("Bus registered successfully!");
    }

    // display registered buses
    public void displayBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses available!");
        } else {
            System.out.println("Available Buses:");
            for (Bus bus : buses) {
                System.out.println("Bus Number: " + bus.getBusNumber());
                System.out.println("Total Seats: " + bus.getTotalSeats());
                System.out.println("Starting Point: " + bus.getStartPoint());
                System.out.println("Ending Point: " + bus.getEndPoint());
                System.out.println("Starting Time: " + bus.getStartTime());
                System.out.println("Fare: " + bus.getFare());
                System.out.println("----------------------------");
            }
        }
    }
}