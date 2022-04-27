// James Burke: 
package code_2;
//package postgrad.oop2.code2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CodeLab {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        final int LOCALISATION=1, DATES_TIMES = 2, STREAMS = 3, EXIT = 4;  
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
            switch (userChoice()) {
                case DATES_TIMES:
                    datesAndTimes();
                    break;
                case STREAMS:
                    streams();
                    break;
                case LOCALISATION:
                    localisation();
                    break;
                case EXIT:
                    System.out.println("Exiting...");
                    userContinue = "n";
                    break;
                default:
                    System.out.println("Unknown entry : ");
                    break;
            }
        }
    }
    
    public static void localisation() {
    	Locale currentLocale = Locale.getDefault();
    	Locale fi = new Locale("fi","FI");
    	Locale nl = new Locale("nl","NL");
        System.out.println(currentLocale);
        ResourceBundle seasons = ResourceBundle.getBundle("code_2.SeasonsBundle",
                                                            currentLocale);
        
        System.out.println("Output the seasons in which language?\\n(D)utch, (F)innish or English (any other key): ");
        String lang = sc.next();
        if(lang.equalsIgnoreCase("F")){
            currentLocale = fi;
            seasons = ResourceBundle.getBundle("code_2.SeasonsBundle",currentLocale);
        }else if(lang.equalsIgnoreCase("D")){
            currentLocale = nl;
            seasons = ResourceBundle.getBundle("code_2.SeasonsBundle",currentLocale);
        }
        System.out.println("hello is "+seasons.getString("spring"));
        System.out.println("goodbye is "+seasons.getString("summer"));
        System.out.println("please is "+seasons.getString("autumn"));
        System.out.println("thanks is "+seasons.getString("winter"));

    }
    public static void datesAndTimes(){
    	LocalDate today  = LocalDate.now();
    	LocalDate joeDOB  = LocalDate.of(2000, Month.JANUARY, 3);
    	LocalDate maryDOB  = LocalDate.of(2011, Month.AUGUST, 13);
    	System.out.println("Joe's DOB is "+joeDOB);
    	System.out.println("Mary's DOB is "+maryDOB);

    	long jAge = ChronoUnit.YEARS.between(joeDOB, today);
    	long mAge = ChronoUnit.YEARS.between(maryDOB, today);
    	if(jAge >= 18) {
    		System.out.println("Yes. Joe is old enough to drink.");
    	}
    	else {
    		System.out.println("No. Joe is too young to drink.");
    	}
    	if(mAge >= 18) {
    		System.out.println("Yes. Mary is old enough to drink.");
    	}
    	else {
    		System.out.println("No. Mary is too young to drink.");
    	}
        
    }
    public static void streams() {
        // This code is given - DO NOT CHANGE. 
        List<Book> books = new ArrayList<>();
        books.add(new Book("Thinking in Java", "Computer Science", 50.0));
        books.add(new Book("Thinking in C++", "Computer Science", 45.0));
        books.add(new Book("Head First Java", "Computer Science", 55.0));
        books.add(new Book("Basic Cooking", "House and Home", 50.0));
        books.add(new Book("Learn the Guitar", "Music", 30.0));
        
        Map<Object, List<Book>> booksByPrice =   books
                .stream()
                //.filter(bookDetails -> bookDetails.getPrice(45.0))
                .collect(Collectors.groupingBy(b -> b.getPrice()));
        	
        
        booksByPrice
        .forEach((price, listBooks) -> System.out.println("Cheapest book is : "+price + " --> "+ listBooks));
        
    }

    public static int userChoice() {
        System.out.println("\nWhat do you want to do ?");
        System.out.println("1. Localisation");  
        System.out.println("2. Dates/Times"); 
        System.out.println("3. Streams"); 
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}