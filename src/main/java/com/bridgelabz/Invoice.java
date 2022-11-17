package com.bridgelabz;

import java.util.Objects;

public class Invoice {
    int totalRides;
    double aggregateFare;
    double averageFare;

    public Invoice(int totalRides, double aggregateFare, double averageFare) {
        this.totalRides = totalRides;
        this.aggregateFare = aggregateFare;
        this.averageFare = averageFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return totalRides == invoice.totalRides && Double.compare(invoice.aggregateFare, aggregateFare) == 0 && Double.compare(invoice.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalRides, aggregateFare, averageFare);
    }
}
