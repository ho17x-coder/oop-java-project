package library.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReaderValidation {

    public static long calculateLateDays(
            String dueDate,
            String returnDate){

        return ChronoUnit.DAYS.between(
                LocalDate.parse(dueDate),
                LocalDate.parse(returnDate)
        );
    }

    public static double calculateFine(
            long lateDays){

        return lateDays*5000;
    }

}