package OCAPrep.Ch3.DatesAndTimes;
/*
Dates are immutable, like strings.
 */
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class CreatingDatesAndTimes {
    public static void main(String[] args){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        //Same date
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);            //Month month is a special class called enum
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        //Showing time
        LocalTime time1 = LocalTime.of(6, 15, 39, 200);

        //Illegal
        //LocalDate d = new LocalDate(); //DOES NOT COMPILE
        //LocalDate.of(2015, Month.JANUARY, 32)   //Exception, there are no months with 32 days
    }
}
