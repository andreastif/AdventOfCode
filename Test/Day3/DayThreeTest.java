package Day3;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                //Character Arrays
                List<String> chars = new ArrayList<>(List.of(
                        "a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
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
                return chars.contains(foundCharacter) ? chars.indexOf(foundCharacter)+1: null ;
            };
            return evalContents.apply(e);
        }).reduce(0, Integer::sum));
    }

    @Test
    void prioritySumActualPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day3/day-3-actual.txt");
        System.out.println(list.stream().map(e -> {
            Function<String, Integer> evalContents = ex -> {
                //Character Arrays
                List<String> chars = new ArrayList<>(List.of(
                        "a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
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
                return chars.contains(foundCharacter) ? chars.indexOf(foundCharacter)+1: null ;
            };
            return evalContents.apply(e);
        }).reduce(0, Integer::sum));
    }

    @Test
    void prioritySumTestPartTwo() throws FileNotFoundException {

        List<String> list = readFromFile.getInput("src/Day3/day-3-test.txt");

        //Take the three first elements in the list
        //find the char that is shared between the three lists (loop)
        //get the value of the char and store it
        //repeat the above mentioned code for all elements in the list
        //accumulate the value of all the found chars
        //submit the sum of all chars.

        int result = 0;
        List<String> stringSequenceContainer = new ArrayList<>();
        List<String> chars = new ArrayList<>(List.of(
                "a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        for (String s :list) {
            stringSequenceContainer.add(s);
            if (stringSequenceContainer.size() == 3) {
                String foundCharacter = "";
                loop:
                for (int i=0; i<stringSequenceContainer.get(0).length();i++) {
                    String stringToCompare = String.valueOf(stringSequenceContainer.get(0).charAt(i));
                    for (int j=0; j<stringSequenceContainer.get(1).length();j++) {
                        if (stringToCompare.equals(String.valueOf(stringSequenceContainer.get(1).charAt(j)))) {
                            for (int k=0; k<stringSequenceContainer.get(2).length(); k++) {
                                if (stringToCompare.equals(String.valueOf(stringSequenceContainer.get(2).charAt(k)))) {
                                    foundCharacter = stringToCompare;
                                    stringSequenceContainer.clear();
                                    break loop;
                                }
                            }
                        }
                    }
                }
                result += chars.contains(foundCharacter) ? chars.indexOf(foundCharacter)+1: null ;
            }
        }
        System.out.println(result);
        assertEquals(70, result);
    }

    @Test
    void prioritySumActualPartTwo() throws FileNotFoundException {

        List<String> list = readFromFile.getInput("src/Day3/day-3-actual.txt");

        //Take the three first elements in the list
        //find the char that is shared between the three lists (loop)
        //get the value of the char and store it
        //repeat the above mentioned code for all elements in the list
        //accumulate the value of all the found chars
        //submit the sum of all chars.

        int result = 0;
        List<String> stringSequenceContainer = new ArrayList<>();
        List<String> chars = new ArrayList<>(List.of(
                "a", "b", "c", "d" ,"e", "f", "g", "h", "i", "j", "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        for (String s :list) {
            stringSequenceContainer.add(s);
            if (stringSequenceContainer.size() == 3) {
                String foundCharacter = "";
                loop:
                for (int i=0; i<stringSequenceContainer.get(0).length();i++) {
                    String stringToCompare = String.valueOf(stringSequenceContainer.get(0).charAt(i));
                    for (int j=0; j<stringSequenceContainer.get(1).length();j++) {
                        if (stringToCompare.equals(String.valueOf(stringSequenceContainer.get(1).charAt(j)))) {
                            for (int k=0; k<stringSequenceContainer.get(2).length(); k++) {
                                if (stringToCompare.equals(String.valueOf(stringSequenceContainer.get(2).charAt(k)))) {
                                    foundCharacter = stringToCompare;
                                    stringSequenceContainer.clear();
                                    break loop;
                                }
                            }
                        }
                    }
                }
                result += chars.contains(foundCharacter) ? chars.indexOf(foundCharacter)+1: null ;
            }
        }
        System.out.println(result);
    }
}