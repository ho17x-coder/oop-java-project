package library.model;

import library.interfaces.Borrowable;
import library.interfaces.Notifiable;

import java.util.List;

public class LibraryManager {

    public void processAllBorrowable(
            List<Borrowable> items) {

        System.out.println(
                "\n=== BORROWABLE ITEMS ===");

        for (Borrowable item : items) {

            if (item.isAvailable()) {

                System.out.println(
                        "Available");

            } else {

                System.out.println(
                        "Borrowed by "
                                + item.getBorrowerId());
            }
        }
    }

    public void notifyAll(
            List<Notifiable> users,
            String message) {

        System.out.println(
                "\n=== NOTIFICATION ===");

        for (Notifiable user : users) {

            user.sendNotification(
                    message);
        }
    }
}