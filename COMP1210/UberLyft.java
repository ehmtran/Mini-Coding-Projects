import java.util.ArrayList;

public interface Serviceable {
    // provideService()
    String provideService();
}

public abstract class Ride implements Serviceable {
    // rideId, distance, baseFare

    protected int rideId;
    protected int distance;
    protected double baseFare;

    public Ride(int rideId, int distance, double baseFare) {
        this.rideId = rideId;
        this.distance = distance;
        this.baseFare = baseFare;
    }

    // displayRideDetails() - prints ride information
    public void displayRideDetails() {
        System.out.println("Ride ID: " + rideId);
        System.out.println("Distance: " + distance + " miles");
        System.out.println("Base Fare: $" + baseFare);
    }

    // calculateFare() - abstract method
    abstract double calculateFare();

    // provideService() for subclasses
    @Override
    public abstract String provideService();

}

public class StandardRide extends Ride implements Serviceable {
    public StandardRide(int rideId, int distance, double baseFare) {
        super(rideId, distance, baseFare);
    }

    // implements calculateFare() (simple rate per mile + base fare)
    @Override
    public double calculateFare() {
        return baseFare + distance * 2.0;
    }

    // implements provideService() (basic ride experience)
    @Override
    public String provideService() {
        return "Service: Providing standard ride service";
    }

    // override displayRideDetails()
    @Override
    public void displayRideDetails() {
        super.displayRideDetails();
        System.out.println("Ride Type: Standard");
    }
}

public class LuxuryRide extends Ride implements Serviceable {
    public LuxuryRide(int rideId, int distance, double baseFare) {
        super(rideId, distance, baseFare);
    }

    // implements calculateFare() (higher rate per mile + luxury fare)
    @Override
    public double calculateFare() {
        return baseFare + distance * 3.0 + 15.0;
    }

    // implements provideService() (premium ride experience)
    @Override
    public String provideService() {
        return "Service: Providing luxury ride with premium amenities";
    }

    // override displayRideDetails()
    @Override
    public void displayRideDetails() {
        super.displayRideDetails();
        System.out.println("Ride Type: Luxury");
        System.out.println("Luxury Fee: $15.0");
    }
}

public class UberLyft {

    public static void main(String[] args) {

        ArrayList<Ride> rides = new ArrayList<Ride>();

        // create instances of StandardRide and LuxuryRide
        StandardRide standard = new StandardRide(201, 10, 5.00);
        LuxuryRide luxury = new LuxuryRide(202, 10, 5.00);

        // store in collection of type Ride
        rides.add(standard);
        rides.add(luxury);

        // loop through rides and call: displayRideDetails(), calculateFare(), and
        // provideService()
        for (Ride ride : rides) {
            ride.displayRideDetails();
            System.out.println("Fare: $" + ride.calculateFare());
            System.out.println(ride.provideService());
            System.out.println("-----------------------");
        }
    }

}

/*
 * Sample Output:
 * 
 * Ride ID: 201
 * Distance: 10 miles
 * Base Fare: $5.00
 * Ride Type: Standard
 * Fare: $25.0
 * Service: Providing standard ride service
 * 
 * ------------------
 * etc.
 */
