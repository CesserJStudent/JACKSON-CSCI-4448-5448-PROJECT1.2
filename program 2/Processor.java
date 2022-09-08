import java.util.ArrayList;
import java.util.Scanner; // import scanner for console input
public class Processor {

    public static String read() {
        Scanner consoleInput = new Scanner(System.in); //create scanner object
        System.out.println("Press enter to read string from console");
        return consoleInput.nextLine(); //read console string
    }

    public static String clean(String convert) {
        //to find the method to remove whitespace I referred to https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
        String upper = convert.toUpperCase(); // convert to upper case

        return upper.replaceAll("\\s", ""); //replace all spaces with whitespace
    }

    public static String sort(String sorter) {
        //to sort alphabetically I referred to this webpage https://www.geeksforgeeks.org/sort-a-string-in-java-2-different-ways/
        //To convert back to string I also used https://www.tutorialspoint.com/copy-char-array-to-string-in-java#:~:text=Use%20the%20valueOf()%20method,of%20array%20to%20be%20copied.
        char sortArr[] = sorter.toCharArray(); //convert string to char array
        char temp; //temp char
        int i = 0;
        while (i < sortArr.length) {
            int j = i + 1;
            while(j < sortArr.length) {
                //check if the letter comes before
                if(sortArr[j] < sortArr[i]) {
                    temp = sortArr[i]; //temp is current value
                    sortArr[i] = sortArr[j]; //swap value with next value
                    sortArr[j] = temp; // swap next value with previous.
                }
                j += 1;
            }
            i += 1;
        }
        return String.valueOf(sortArr);
    }

    public static String palindrome(String convert) {
        //for help with reversing a string I referred to https://www.geeksforgeeks.org/reverse-a-string-in-java/
        String reverseD = ""; //string to hold reverse
        char temp; // temp to hold char
        for (int i=1; i<convert.length();i++) {
            temp = convert.charAt(i); //set temp to current vhar
            reverseD = temp + reverseD; //add to reverse string
        }

        return (reverseD + convert); //return palindrome
    }

    public static void process() {
        String word;
        do {
            word = read();
            //if blank break
            if (word.equals("")){
                break;
            }
            String cleanW = clean(word); //clean
            String sortW = sort(cleanW); //sort cleaned word
            String finalW = palindrome(sortW); //palindrome of sorted word.
            System.out.println("String after clean is: " + cleanW);
            System.out.println("String after sort is: " + sortW);
            System.out.println("The final String is: " + finalW);
        }
        while(!word.equals(""));

    }

    public static void main(String args[])  //main method for the program
    {
        Processor processor = new Processor(); // nerw processor object
        Processor.process(); // process data


    }
}
