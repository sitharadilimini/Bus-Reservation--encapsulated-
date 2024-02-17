public class ReservationDto {
    String customerName;
    String customerEmail;
    int busNumber;
    int seatNumber;

    // parameterized constructor
    public ReservationDto(String customerName, String customerEmail, int busNumber, int seatNumber) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.busNumber = busNumber;
        this.seatNumber = seatNumber;
    }

    // no argument constructor
    public ReservationDto() {
    }

    // getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    // setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer Name: " + customerName + "\nCustomer Email: " + customerEmail + "\nBus Number: " + busNumber
                + "\nSeat Number: " + seatNumber;
    }
}
