package Day6;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaySixTest {

    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day6/day-6-test.txt");
        assertEquals(1, list.size());
    }

    @Test
    void checkBufferTestOne() throws FileNotFoundException {
        List<String> buffer = readFromFile.getInput("src/Day6/day-6-test.txt");
        System.out.println("buffer: " + buffer);
        mega:
        for (int i = 3; i < buffer.get(0).length(); i++) {

            String characterString = buffer.get(0).substring(i - 3, i + 1);
            System.out.println(characterString);
            int counter = 0;

            loops:
            for (int j = 0; j < characterString.length(); j++) {
                String characterToCompare = String.valueOf(characterString.charAt(j));

                for (int k = j + 1; k < characterString.length(); k++) {
                    String nextCharacter = String.valueOf(characterString.charAt(k));
                    if (!characterToCompare.equals(nextCharacter)) {
                        System.out.println("From if - characterToCompare: " + characterToCompare + " nextCharacter: " + nextCharacter);
                        counter++;
                    } else {
                        System.out.println("From else - characterToCompare: " + characterToCompare + " nextCharacter: " + nextCharacter);
                        System.out.println("Found duplicate!");
                        break loops;
                    }

                }
            }
            if (counter == 6) {
                System.out.println("index of character: " + (i+1));
                break mega;
            }
        }
    }

    @Test
    void checkBufferTestTwo() throws FileNotFoundException {
        List<String> buffer = readFromFile.getInput("src/Day6/day-6-test.txt");
        System.out.println("buffer: " + buffer);
        mega:
        for (int i = 13; i < buffer.get(0).length(); i++) {
            String characterString = buffer.get(0).substring(i - 13, i + 1);
            System.out.println(characterString);
            int counter = 0;
            loops:
            for (int j = 0; j < characterString.length(); j++) {
                String characterToCompare = String.valueOf(characterString.charAt(j));
                for (int k = j + 1; k < characterString.length(); k++) {
                    String nextCharacter = String.valueOf(characterString.charAt(k));
                    if (!characterToCompare.equals(nextCharacter)) {
                        System.out.println("From if - characterToCompare: " + characterToCompare + " nextCharacter: " + nextCharacter);
                        counter++;
                    } else {
                        System.out.println("From else - characterToCompare: " + characterToCompare + " nextCharacter: " + nextCharacter);
                        System.out.println("Found duplicate!");
                        break loops;
                    }
                }
            }
            System.out.println(counter);
            if (counter == 91) {
                System.out.println("index of character: " + (i+1));
                break mega;
            }
        }
    }

    @Test
    void checkBufferActualOne() throws FileNotFoundException {
        List<String> buffer = readFromFile.getInput("src/Day6/day-6-actual.txt");
        for (int i = 3; i < buffer.get(0).length(); i++) {
            String characterString = buffer.get(0).substring(i - 3, i + 1);
            int counter = 0;
            loops:
            for (int j = 0; j < characterString.length(); j++) {
                String characterToCompare = String.valueOf(characterString.charAt(j));
                for (int k = j + 1; k < characterString.length(); k++) {
                    String nextCharacter = String.valueOf(characterString.charAt(k));
                    if (!characterToCompare.equals(nextCharacter)) {
                        counter++;
                    } else {
                        break loops;
                    }
                }
            }
            if (counter == 6) {
                System.out.println("index of character: " + (i+1));
                break;
            }
        }
    }

    @Test
    void checkBufferActualTwo() throws FileNotFoundException {
        List<String> buffer = readFromFile.getInput("src/Day6/day-6-actual.txt");
        for (int i = 13; i < buffer.get(0).length(); i++) {
            String characterString = buffer.get(0).substring(i - 13, i + 1);
            int counter = 0;
            loops:
            for (int j = 0; j < characterString.length(); j++) {
                String characterToCompare = String.valueOf(characterString.charAt(j));
                for (int k = j + 1; k < characterString.length(); k++) {
                    String nextCharacter = String.valueOf(characterString.charAt(k));
                    if (!characterToCompare.equals(nextCharacter)) {
                        counter++;
                    } else {
                        break loops;
                    }
                }
            }
            if (counter == 91) {
                System.out.println("index of character: " + (i+1));
                break;
            }
        }
    }
}