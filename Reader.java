import java.util.ArrayList; //import ArrayList
import java.util.Scanner; // import scanner for user input

public class Reader {
    static ArrayList<Double> numberList = new ArrayList<Double>(); //Create arraylist to store user input as a double as any real number needs to be accepted

    public static ArrayList<Double> read() {

        while (true) {
            Scanner userNumbers = new Scanner(System.in); //create scanner object
            System.out.println("Enter a real or integer value. If no value is entered calculations will be preformed on all previously entered numbers."); //ask for user input
            String userInput = userNumbers.nextLine(); //read next string

            //if null end loop
            if (userInput.equals("")) {
                break;
            }
            //if a number was entered add it to the list
            else {
                numberList.add(Double.parseDouble(userInput));
                System.out.println(numberList);
            }
        }
        return numberList;
    }
}
