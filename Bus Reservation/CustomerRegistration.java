import java.util.ArrayList;

public class CustomerRegistration {
    ArrayList<Customer> customerStack = new ArrayList<Customer>();
    Customer customer = new Customer();
    int top = -1;

    // Method to register a customer
    public void RegisteredCustomer(String name, int mobileNumber, String email, String city, int age) {
        customer = new Customer();
        customer.setName(name);
        customer.setMobileNumber(mobileNumber);
        customer.setEmail(email);
        customer.setCity(city);
        customer.setAge(age);

        push(customer);
        System.out.println("-------------------------------------------");
        System.out.println("Customer registered successfully!");
    }

    // push registered customer to stack
    public void push(Customer customer) {
        customerStack.add(customer);
        top++;
    }

    // display registered customer
    public void displayCustomer() {
        if (top == -1) {
            System.out.println("No customer registered yet!");
        } else {
            System.out.println("Registered Customers:");
            for (int i = top; i >= 0; i--) {
                System.out.println("Name: " + customerStack.get(i).getName());
                System.out.println("Mobile Number: " + customerStack.get(i).getMobileNumber());
                System.out.println("Email: " + customerStack.get(i).getEmail());
                System.out.println("City: " + customerStack.get(i).getCity());
                System.out.println("Age: " + customerStack.get(i).getAge());
                System.out.println("----------------------------");
            }
        }

    }

}
