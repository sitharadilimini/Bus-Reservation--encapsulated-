public class Customer {
    private String name;
    private int mobileNumber;
    private String email;
    private String city;
    private int age;

    public Customer(String name, int mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    // Added new
    // no argument constructor
    public Customer() {
    }

    // getters
    public String getName() {
        return name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer " + "name='" + name + "\nmobileNumber=" + mobileNumber + "\nemail='" + email + "\ncity='"
                + city + "\nage=" + age + '}';
    }

}