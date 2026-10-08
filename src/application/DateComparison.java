package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the date #1 (dd/mm/yyyy): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Enter the date #2 (dd/mm/yyyy): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine(), dtf);

        System.out.println();
        System.out.println("Date #1: " + date1.format(dtf));
        System.out.println("Date #2: " + date2.format(dtf));

        System.out.println();
        if (date1.isAfter(date2)) {
            System.out.println("Date #1 is after date #2");
        }
        else if (date1.isBefore(date2)) {
            System.out.println("Date #1 is before date #2");
        }
        else {
            System.out.println("The dates are equal");
        }

        sc.close();

    }

}
