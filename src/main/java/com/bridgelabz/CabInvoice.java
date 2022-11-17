package com.bridgelabz;

public class CabInvoice {
    static final int COST_PER_KM = 10;
    static final int COST_PER_MIN = 1;
    static final int MINIMUM_FARE = 5;
    static final int COST_PER_KM_FOR_PREMIUM_RIDES = 15;
    static final int COST_PER_MIN_FOR_PREMIUM_RIDES = 2;
    static final int MINIMUM_FARE_FOR_PREMIUM_RIDES = 20;

    public double calculateFare(double distance, double time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        return totalFare < MINIMUM_FARE ? MINIMUM_FARE : totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double aggregateFare = 0;
        for (Ride ride : rides) {
            double rideFare = calculateFare(ride.distance, ride.time);
            aggregateFare += rideFare;
        }
        return aggregateFare;
    }

    public Invoice generateInvoice(Ride[] rides) {
        double aggregateFare = calculateFare(rides);
        int totalRides = rides.length;
        double averageFare = aggregateFare / totalRides;
        return new Invoice(totalRides, aggregateFare, averageFare);
    }

    public double calculateFareForPremiumRides(double distance, double time) {
        double totalFareForPremiumRides=distance*COST_PER_KM_FOR_PREMIUM_RIDES+time*COST_PER_MIN_FOR_PREMIUM_RIDES;
        return totalFareForPremiumRides;
    }
}
