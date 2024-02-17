public class Bus {
    int busNumber;
    int totalSeats;
    String startPoint;
    String endPoint;
    String startTime;
    double fare;

    public Bus(int busNumber, int totalSeats, String startPoint, String endPoint, String startTime, double fare) {
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.fare = fare;
    }

    // Added new
    // no argument constructor
    public Bus() {
    }

    // getters
    public int getBusNumber() {
        return busNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getStartTime() {
        return startTime;
    }

    public double getFare() {
        return fare;
    }

    // setters
    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    // toString method
    @Override
    public String toString() {
        return "Bus Number: " + busNumber + "\nTotal Seats: " + totalSeats + "\nStart Point: " + startPoint
                + "\nEnd Point: " + endPoint + "\nStart Time: " + startTime + "\nFare: " + fare;
    }

}