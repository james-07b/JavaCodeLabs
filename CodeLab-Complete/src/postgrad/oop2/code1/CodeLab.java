// James Burke: 
package postgrad.oop2.code1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
// extra imports will be required...
import java.util.function.Predicate;

public class CodeLab {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int ENUMS_AND_LAMBDAS = 1, GENERICS = 2, SORT_NATURAL_ORDER = 3, EXIT = 4;
        String userContinue = "y";

        while (userContinue.equalsIgnoreCase("y")) {
            switch (userChoice()) {
                case ENUMS_AND_LAMBDAS:
                    enumsAndLambdas();
                    break;
                case GENERICS:
                    generics();
                    break;
                case SORT_NATURAL_ORDER:
                    sortNaturalOrder();
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
    // **********************************************************************************************
    // **********************************************************************************************
    // Enumerations and Lambdas
    // **********************************************************************************************
    // **********************************************************************************************

    public static void enumsAndLambdas() {
        // *** INSERT YOUR CODE HERE ***
    	Rose wRose = Rose.WHITE;
    	Rose yRose = Rose.YELLOW;
    	Rose rRose = Rose.RED;
    	Rose pRose = Rose.PINK;
		System.out.println(check(wRose, c -> c.getColour().equals("White")));
		System.out.println(check(rRose, c -> c.getColour().equals("Not Red")));
		System.out.println(check(yRose, c -> c.getColour().equals("Sort of Yellow")));
		System.out.println(check(pRose, c -> c.getColour().equals("bándearg(Irish for pink")));
    	
    	
    }

    // The generic "check" method is here... 
    public static <T> boolean check(T t, Predicate<T> lambda) {
		return lambda.test(t);
	}
    
    public static void sortNaturalOrder(){
    	Set<Person> people = new TreeSet<Person>();
        people.add(new Person("John Bloggs", 44));
        people.add(new Person("Ann Bloggs", 55));
        people.add(new Person("Charlie Bloggs", 33));
    	

        
        System.out.println("\nSorted by Name (alphabetically) :");
        System.out.println(people);

		for (Person person:people) {
			System.out.println(person);
		}
    }

    public static void generics(){
    	MyGenericType<String> myGenString = new MyGenericType<String>();
    	MyGenericType<Person> myGenPerson = new MyGenericType<Person>();
    	
    	myGenString.add("OOP2");
		System.out.println(myGenString.get());
		
		myGenPerson.add(new Person("April", 32));
		System.out.println(myGenPerson.get());

        
    }
   
    public static int userChoice() {
        System.out.println("What do you want to do ?");
        System.out.println("1. Enums and Lambdas");
        System.out.println("2. Generics");
        System.out.println("3. Sort");
        System.out.println("4. Exit");
        System.out.print("Enter choice --> ");
        return sc.nextInt();
    }
}
