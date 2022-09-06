import java.util.ArrayList; //import ArrayList
import java.util.Collection;
import java.util.*;

public class Analyzer {

    public static Double median(ArrayList<Double> numberList) {
        Collections.sort(numberList); // sort the list
        int arraySize = numberList.size();
        //check if even
        if (arraySize % 2 == 0) {
            int med1 = (arraySize - 1) / 2;
            int med2 = (arraySize + 1) / 2;
            return (numberList.get(med1) + numberList.get(med2))/2; //return the median
        }
        // if odd
        else {
            return numberList.get(arraySize/2); //return the median
        }

    }

    public static Double mean(ArrayList<Double> numberList) {
        Double numberSum = 0.0;
        //get sum of all numbers in the list
        for(int i = 0; i < numberList.size(); i++) {
            numberSum += numberList.get(i);
        }

        return numberSum / numberList.size(); //calculate mode

    }

    public static ArrayList<Double> mode(ArrayList<Double> numberList) {
        ArrayList<Double> mode = new ArrayList<Double>(); //crete an arraylist incase there are multiple modes
        int highestCount = 0;

        //first loop get the current mode to check for instances
        for(int i = 0; i < numberList.size(); i++){
            int count = 0;
            Double curMode = numberList.get(i);

            //second loop checks the rest of the list and counts instances
            for (int j = i; j < numberList.size(); j++){
                if (numberList.get(j).equals(curMode)) {
                    count += 1;
                }
            }

            //if count is more than any other clear the array and add this as the mode
            if(count > highestCount) {
                mode.clear();
                highestCount = count;
                mode.add(curMode);
            }
            //if count is equal to others in list then add as a multiple mode
            else if (count == highestCount && !mode.contains(curMode)) {
                mode.add(curMode);
            }
        }

        return mode;
    }

    public static Double variance(ArrayList<Double> numberList) {
        ArrayList<Double> varList = new ArrayList<Double>(numberList); //crete a new arraylist to work on
        Double mean = mean(varList);
        Double sumOSquares = 0.0;
        for (int i = 0; i < varList.size(); i++) {
            varList.set(i, (mean - varList.get(i))); //get the deviation from the mean
            varList.set(i, varList.get(i) * varList.get(i)); // get the squared deviation
            sumOSquares += varList.get(i); // get sum of squares


        }

        return sumOSquares / (varList.size() - 1); // return variance

    }

    public static Double stDev(ArrayList<Double> numberList) {
        //to get the algorithm to calculate the square root without imports I referred to https://www.javatpoint.com/java-program-to-find-square-root-of-a-number-without-sqrt-method
        Double var = variance(numberList);
        Double temp;
        Double sqrt = var /2;
        //calculate square root of variance
        do {
            temp = sqrt;
            sqrt = (temp+(var/temp))/2;
        }
        while((temp - sqrt) != 0);

        return sqrt;

    }

    public static Double minVal(ArrayList<Double> numberList) {
        Double min = numberList.get(0);

        //loop through to find min value
        for (int i = 1; i < numberList.size(); i ++) {
            if (numberList.get(i) < min) {
                min = numberList.get(i);
            }
        }

        return min;

    }

    public static Double maxVal(ArrayList<Double> numberList) {
        Double max = numberList.get(0);

        //loop through to find max value
        for (int i = 1; i < numberList.size(); i ++) {
            if (numberList.get(i) > max) {
                max = numberList.get(i);
            }
        }

        return max;

    }

    public static ArrayList maxOccur(ArrayList<Double> numberList) {
        ArrayList<Double> mode = mode(numberList); // get the mode/modes
        int count = 0; //count

        for (int i= 0; i < numberList.size(); i++) {
            //get count of mode
            if (numberList.get(i).equals(mode.get(0))) {
                count += 1;
            }
        }
        //store the mode/modes and the occur count in a list
        ArrayList maxOccur = new ArrayList();
        maxOccur.add(mode);
        maxOccur.add(count);

        return maxOccur;

    }

    public static void analyze(ArrayList<Double> numberList) {
        System.out.println("The median of the list is: " + median(numberList)); // calculate median
        System.out.println("The mean of the list is: " + mean(numberList)); // calculate mean
        System.out.println("The mode of the list is: " + mode(numberList)); // calculate mode
        System.out.println("The variance of the list is: " + variance(numberList)); //calculate variance
        System.out.println("The standard deviation of the list is: " + stDev(numberList)); //calculate stDev
        System.out.println("The minimum value of the list is: " + minVal(numberList)); //calculate min val
        System.out.println("The maximum value of the list is: " + maxVal(numberList)); //calculate max val
        System.out.println("The maximum occurrences of the list is: " + maxOccur(numberList)); //calculate max occur
    }

    public static void main(String args[])  //main method for the program
    {
        Reader reader = new Reader(); // new reader
        Analyzer analyzer = new Analyzer();
        ArrayList data = reader.read(); // read data from the user
        analyzer.analyze(data); // perform analyze calculations
    }
}
