package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    @Test
    void givenDistanceAndTime_shouldReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateFare(10.0, 4.0);
        Assertions.assertEquals(104.0, totalFare);
    }

    @Test
    void givenDistanceAndTime_shouldReturnMinimumFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFare = cabInvoice.calculateFare(0.1, 1.0);
        Assertions.assertEquals(5.0, totalFare);
    }

    @Test
    void givenMultipleRides_shouldReturnAggregateFare() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0, 4.0), new Ride(12.0, 5.0), new Ride(0.1, 1.0)};
        double totalFare = cabInvoice.calculateFare(rides);
        Assertions.assertEquals(234.0, totalFare);
    }

    @Test
    void givenMultipleRides_shouldReturnInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        Ride[] rides = {new Ride(10.0, 4.0), new Ride(12.0, 5.0), new Ride(0.1, 1.0)};
        Invoice expectedInvoice = new Invoice(3, 234.0, 78.0);
        Invoice actualInvoice = cabInvoice.generateInvoice(rides);
        //double totalFare=cabInvoice.calculateFare(rides);
        Assertions.assertEquals(expectedInvoice, actualInvoice);
    }

    @Test
    void givenUserId_shouldReturnInvoice() {
        CabInvoice cabInvoice = new CabInvoice();
        RideRepository rideRepository = new RideRepository();
        Ride[] rides1 = {new Ride(10.0, 4.0), new Ride(12.0, 5.0), new Ride(0.1, 1.0)};
        Ride[] rides2 = {new Ride(10.0, 4.0), new Ride(12.0, 5.0), new Ride(0.1, 1.0)};
        rideRepository.getRides("User01", rides1);
        rideRepository.getRides("User02", rides2);
        Invoice actualInvoice1 = rideRepository.getInvoiceFromUserId("User01");
        Invoice actualInvoice2 = rideRepository.getInvoiceFromUserId("User02");
        Invoice expectedInvoice1 = new Invoice(3, 234.0, 78.0);
        Invoice expectedInvoice2 = new Invoice(3, 234.0, 78.0);
        Assertions.assertEquals(expectedInvoice1, actualInvoice1);
        Assertions.assertEquals(expectedInvoice2, actualInvoice2);
    }
    @Test
    void givenDistanceAndTime_shouldReturnTotalFareForPremiumRides() {
        CabInvoice cabInvoice = new CabInvoice();
        double totalFareForPremiumRides = cabInvoice.calculateFareForPremiumRides(10.0, 4.0);
        Assertions.assertEquals(158.0, totalFareForPremiumRides);
    }
}
