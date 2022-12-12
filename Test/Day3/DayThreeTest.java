package Day3;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class DayThreeTest {
    ReadFromFile readFromFile = new ReadFromFile();
    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day3/day-3-test.txt");
        System.out.println(list);
    }

    @Test
    void prioritySumTestPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day3/day-3-test.txt");
        assertEquals(157,list.stream().map(e -> {
            Function<String, Integer> evalContents = ex -> {
                //Defining two arrays for evaluating sum
                    //Character Arrays
                    List<String> charsLC = new ArrayList<>(List.of("a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
                    List<String> charsUC = charsLC.stream().map(String::toUpperCase).toList();
                    //List of Integers
                    List<Integer> integerArray = new ArrayList<>();
                    for (int i=1; i<27; i++) {
                        integerArray.add(i);
                    }
                    List<Integer> integerArrayTwo = new ArrayList<>();
                    for (int i=27; i<53; i++) {
                        integerArrayTwo.add(i);
                    }
                //split string into two - OK
                //substring range: inclusive - exclusive
                String compartmentOne = ex.substring(0, ex.length()/2);
                String compartmentTwo = ex.substring(ex.length()/2);

                //find common content - OK
                String foundCharacter = "";
                for (int i=0; i<compartmentOne.length();i++) {
                    String stringToCompare = String.valueOf(compartmentOne.charAt(i));
                    for (int j=0; j<compartmentTwo.length();j++) {
                        if (stringToCompare.equals(String.valueOf(compartmentTwo.charAt(j)))) {
                            foundCharacter = stringToCompare;
                            break;
                        }
                    }
                }
                //lookup value in prop - OK
                int returnValue;
                if (charsLC.contains(foundCharacter)) {
                    returnValue = integerArray.get(charsLC.indexOf(foundCharacter));
                } else {
                    returnValue = integerArrayTwo.get(charsUC.indexOf(foundCharacter));
                }
                return returnValue;
            };
            return evalContents.apply(e);
        }).reduce(0, Integer::sum));
    }

    @Test
    void prioritySumActualPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day3/day-3-actual.txt");
        System.out.println(list.stream().map(e -> {
            Function<String, Integer> evalContents = ex -> {
                //Defining two arrays for evaluating sum
                //Character Arrays
                List<String> charsLC = new ArrayList<>(List.of("a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));
                List<String> charsUC = charsLC.stream().map(String::toUpperCase).toList();
                //List of Integers
                List<Integer> integerArray = new ArrayList<>();
                for (int i=1; i<27; i++) {
                    integerArray.add(i);
                }
                List<Integer> integerArrayTwo = new ArrayList<>();
                for (int i=27; i<53; i++) {
                    integerArrayTwo.add(i);
                }
                //split string into two - OK
                //substring range: inclusive - exclusive
                String compartmentOne = ex.substring(0, ex.length()/2);
                String compartmentTwo = ex.substring(ex.length()/2);

                //find common content - OK
                String foundCharacter = "";
                for (int i=0; i<compartmentOne.length();i++) {
                    String stringToCompare = String.valueOf(compartmentOne.charAt(i));
                    for (int j=0; j<compartmentTwo.length();j++) {
                        if (stringToCompare.equals(String.valueOf(compartmentTwo.charAt(j)))) {
                            foundCharacter = stringToCompare;
                            break;
                        }
                    }
                }
                //lookup value in prop - OK
                return charsLC.contains(foundCharacter) ? integerArray.get(charsLC.indexOf(foundCharacter)) : integerArrayTwo.get(charsUC.indexOf(foundCharacter));
            };
            return evalContents.apply(e);
        }).reduce(0, Integer::sum));

    }

}