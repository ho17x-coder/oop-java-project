package library.model;

import library.interfaces.Fineable;

public class Fine implements Fineable {

    private String fineId;
    private String readerId;

    private double totalFine;

    private boolean paid;

    public Fine(String fineId,
                String readerId) {

        this.fineId = fineId;
        this.readerId = readerId;

        this.totalFine = 0;
        this.paid = false;
    }

    @Override
    public void addFine(double amount) {

        if (Fineable.isValidFineAmount(amount)) {
            totalFine += amount;
        }
    }

    @Override
    public double getTotalFine() {
        return totalFine;
    }

    @Override
    public boolean hasPaidFine() {
        return paid;
    }

    @Override
    public void payFine() {

        System.out.println(
                "Thanh toán: "
                        + totalFine
                        + " VND");

        paid = true;
        totalFine = 0;
    }
}