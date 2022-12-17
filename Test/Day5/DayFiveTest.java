package Day5;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class DayFiveTest {
    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day5/day-5-test.txt");
        assertEquals(4, list.size());
    }

    @Test
    void moveCrateTestPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day5/day-5-test.txt");

        List<String> one = new ArrayList<>(List.of("Z", "N"));
        List<String> two = new ArrayList<>(List.of("M", "C", "D"));
        List<String> three = new ArrayList<>(List.of("P"));
        List<List<String>> stacks = new ArrayList<>(List.of(one, two, three));

        list.stream().peek(e -> {
            Consumer<String> moveCrate = instruction -> {
                Pattern pattern = Pattern.compile("\\bmove\\s+(\\d+)\\s+from\\s+(\\d+)\\s+to\\s+(\\d+)\\b");
                Matcher matcher = pattern.matcher(instruction);
                Integer moveAmount = null, fromStack = null, toStack = null;
                if (matcher.find()) {
                    moveAmount = Integer.parseInt(matcher.group(1));
                    fromStack = Integer.parseInt(matcher.group(2)) - 1;
                    toStack = Integer.parseInt(matcher.group(3)) - 1;
                }

                for (int i = 0; i < moveAmount; i++) {
                    //get the object to move
                    List<String> tempListFrom = stacks.get(fromStack);
                    String s = tempListFrom.get(tempListFrom.size() - 1);
                    //remove the object inside the old list
                    stacks.get(fromStack).remove(tempListFrom.size() - 1);
                    //put it into new list
                    stacks.get(toStack).add(s);
                }
            };
            moveCrate.accept(e);
        }).toList();
        System.out.println(stacks);
    }

    @Test
    void moveCrateActualPartOne() throws FileNotFoundException {

        List<String> list = readFromFile.getInput("src/Day5/day-5-actual.txt");

        List<String> one = new ArrayList<>(List.of("F", "C", "J", "P", "H", "T", "W"));
        List<String> two = new ArrayList<>(List.of("G", "R", "V", "F", "Z", "J", "B", "H"));
        List<String> three = new ArrayList<>(List.of("H", "P", "T", "R"));
        List<String> four = new ArrayList<>(List.of("Z", "S", "N", "P", "H", "T"));
        List<String> five = new ArrayList<>(List.of("N", "V", "F", "Z", "H", "J", "C", "D"));
        List<String> six = new ArrayList<>(List.of("P", "M", "G", "F", "W", "D", "Z"));
        List<String> seven = new ArrayList<>(List.of("M", "V", "Z", "W", "S", "J", "D", "P"));
        List<String> eight = new ArrayList<>(List.of("N", "D", "S"));
        List<String> nine = new ArrayList<>(List.of("D", "Z", "S", "F", "M"));
        List<List<String>> stacks = new ArrayList<>(List.of(one, two, three, four, five, six, seven, eight, nine));
        list.stream().peek(e -> {
            Consumer<String> moveCrate = instruction -> {
                Pattern pattern = Pattern.compile("\\bmove\\s+(\\d+)\\s+from\\s+(\\d+)\\s+to\\s+(\\d+)\\b");
                Matcher matcher = pattern.matcher(instruction);
                Integer moveAmount = null, fromStack = null, toStack = null;
                if (matcher.find()) {
                    moveAmount = Integer.parseInt(matcher.group(1));
                    fromStack = Integer.parseInt(matcher.group(2)) - 1;
                    toStack = Integer.parseInt(matcher.group(3)) - 1;
                }
                for (int i = 0; i < moveAmount; i++) {
                    //get the object to move
                    List<String> tempListFrom = stacks.get(fromStack);
                    String s = tempListFrom.get(tempListFrom.size() - 1);
                    //remove the object inside the old list
                    stacks.get(fromStack).remove(tempListFrom.size() - 1);
                    //put it into new list
                    stacks.get(toStack).add(s);
                    System.out.println("You just moved " + s);
                }
            };
            moveCrate.accept(e);
        }).toList();
        System.out.println(stacks);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void moveCrateTestPartTwo() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day5/day-5-test.txt");

        List<String> one = new ArrayList<>(List.of("Z", "N"));
        List<String> two = new ArrayList<>(List.of("M", "C", "D"));
        List<String> three = new ArrayList<>(List.of("P"));
        List<List<String>> stacks = new ArrayList<>(List.of(one, two, three));

        list.stream().peek(e -> {
            Consumer<String> moveCrate = instruction -> {
                Pattern pattern = Pattern.compile("\\bmove\\s+(\\d+)\\s+from\\s+(\\d+)\\s+to\\s+(\\d+)\\b");
                Matcher matcher = pattern.matcher(instruction);
                Integer moveAmount = 0, fromStack = 0, toStack = 0;
                if (matcher.find()) {
                    moveAmount = Integer.parseInt(matcher.group(1));
                    fromStack = Integer.parseInt(matcher.group(2)) - 1;
                    toStack = Integer.parseInt(matcher.group(3)) - 1;
                }

                List<String> container = new ArrayList<>();

                for (int i = 0; i < moveAmount; i++) {
                    //get the object to move
                    List<String> tempListFrom = stacks.get(fromStack);
                    String s = tempListFrom.get(tempListFrom.size() - 1);
                    //remove the object inside the old list
                    stacks.get(fromStack).remove(tempListFrom.size() - 1);
                    //put it into new list
                    container.add(s);
                }
                for (int i=container.size(); i>0;i--) {
                    //add the object to the new list
                    stacks.get(toStack).add(container.get(i-1));
                }
            };
            moveCrate.accept(e);
        }).toList();
        System.out.println(stacks);
    }

    @Test
    void moveCrateActualPartTwo() throws FileNotFoundException {

        List<String> list = readFromFile.getInput("src/Day5/day-5-actual.txt");

        List<String> one = new ArrayList<>(List.of("F", "C", "J", "P", "H", "T", "W"));
        List<String> two = new ArrayList<>(List.of("G", "R", "V", "F", "Z", "J", "B", "H"));
        List<String> three = new ArrayList<>(List.of("H", "P", "T", "R"));
        List<String> four = new ArrayList<>(List.of("Z", "S", "N", "P", "H", "T"));
        List<String> five = new ArrayList<>(List.of("N", "V", "F", "Z", "H", "J", "C", "D"));
        List<String> six = new ArrayList<>(List.of("P", "M", "G", "F", "W", "D", "Z"));
        List<String> seven = new ArrayList<>(List.of("M", "V", "Z", "W", "S", "J", "D", "P"));
        List<String> eight = new ArrayList<>(List.of("N", "D", "S"));
        List<String> nine = new ArrayList<>(List.of("D", "Z", "S", "F", "M"));
        List<List<String>> stacks = new ArrayList<>(List.of(one, two, three, four, five, six, seven, eight, nine));


        list.stream().peek(e -> {
            Consumer<String> moveCrate = instruction -> {
                Pattern pattern = Pattern.compile("\\bmove\\s+(\\d+)\\s+from\\s+(\\d+)\\s+to\\s+(\\d+)\\b");
                Matcher matcher = pattern.matcher(instruction);
                Integer moveAmount = 1, fromStack = 2, toStack = 3;
                if (matcher.find()) {
                    moveAmount = Integer.parseInt(matcher.group(1));
                    fromStack = Integer.parseInt(matcher.group(2)) - 1;
                    toStack = Integer.parseInt(matcher.group(3)) - 1;
                }
                List<String> container = new ArrayList<>();
                for (int i = 0; i < moveAmount; i++) {
                    //get the object to move
                    List<String> tempListFrom = stacks.get(fromStack);
                    String s = tempListFrom.get(tempListFrom.size() - 1);
                    //remove the object inside the old list
                    stacks.get(fromStack).remove(tempListFrom.size() - 1);
                    //put it into new list
                    container.add(s);
                }
                for (int i=container.size(); i>0;i--) {
                    //add the object to the new list
                    stacks.get(toStack).add(container.get(i-1));
                }
            };
            moveCrate.accept(e);
        }).toList();
        System.out.println(stacks);
    }

}