//A client should not be forced to depend on methods it does not use.
//In short: "Many small interfaces are better than one fat interface."

interface User {
    void bookRide();
    void acceptRide();
    void rateDriver();
    void ratePassenger();
    void showEarnings();
}
//Problem:

//A Passenger doesn’t need acceptRide() or showEarnings().

//A Driver doesn’t need bookRide() or ratePassenger() maybe.

//Both are forced to implement irrelevant methods → violation of ISP.

// Passenger-specific behavior
interface Passenger {
    void bookRide();
    void rateDriver();
}

// Driver-specific behavior
interface Driver {
    void acceptRide();
    void showEarnings();
}

class PassengerUser implements Passenger {
    private String name;
    public PassengerUser(String name) { this.name = name; }

    @Override
    public void bookRide() {
        System.out.println(name + " booked a ride.");
    }

    @Override
    public void rateDriver() {
        System.out.println(name + " rated the driver.");
    }
}

class DriverUser implements Driver {
    private String name;
    public DriverUser(String name) { this.name = name; }

    @Override
    public void acceptRide() {
        System.out.println(name + " accepted a ride.");
    }

    @Override
    public void showEarnings() {
        System.out.println(name + " has earned ₹500 today.");
    }
}

public class interfaceSegregationPrinciple {
    static void main() {
        Passenger passenger = new PassengerUser("Saloni");
        passenger.bookRide();
        passenger.rateDriver();

        Driver driver = new DriverUser("Amit");
        driver.acceptRide();
        driver.showEarnings();
    }
}
