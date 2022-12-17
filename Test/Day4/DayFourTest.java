package Day4;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTest {
    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-test.txt");
        assertEquals(6, list.size());
    }

    @Test
    void findPairsTestPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-test.txt");
        assertEquals(2, list.stream().map(element -> {
                    Function<String, Integer> findPair = stringFromList -> {

                        int result = 0;
                        String regEx = "^(\\d+-\\d+),(\\d+-\\d+)";
                        Pattern pattern = Pattern.compile(regEx);
                        Matcher matcher = pattern.matcher(stringFromList);

                        String firstGroup = null, secondGroup = null;

                        if (matcher.find()) {
                            firstGroup = matcher.group(1);
                            secondGroup = matcher.group(2);
                        }

                        int firstValue = Integer.parseInt(firstGroup.substring(0, firstGroup.indexOf("-")));
                        int secondValue = Integer.parseInt(firstGroup.substring(firstGroup.indexOf("-") + 1));
                        int thirdValue = Integer.parseInt(secondGroup.substring(0, secondGroup.indexOf("-")));
                        int fourthValue = Integer.parseInt(secondGroup.substring(secondGroup.indexOf("-") + 1));

                        if (firstValue >= thirdValue && secondValue <= fourthValue) {
                            result += 1;
                        } else if (thirdValue >= firstValue && fourthValue <= secondValue) {
                            result += 1;
                        }
                        return result;
                    };
                    return findPair.apply(element);
                }).reduce(0, (a, b) -> a + b)
        );
    }

    @Test
    void findPairsActualPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-actual.txt");
        System.out.println(
                list.stream().map(element -> {
                    Function<String, Integer> findPair = stringFromList -> {
                        int result = 0;
                        String regEx = "^(\\d+-\\d+),(\\d+-\\d+)";
                        Pattern pattern = Pattern.compile(regEx);
                        Matcher matcher = pattern.matcher(stringFromList);

                        String firstGroup = null, secondGroup = null;
                        if (matcher.find()) {
                            firstGroup = matcher.group(1);
                            secondGroup = matcher.group(2);
                        }

                        int firstValue = Integer.parseInt(firstGroup.substring(0, firstGroup.indexOf("-")));
                        int secondValue = Integer.parseInt(firstGroup.substring(firstGroup.indexOf("-") + 1));
                        int thirdValue = Integer.parseInt(secondGroup.substring(0, secondGroup.indexOf("-")));
                        int fourthValue = Integer.parseInt(secondGroup.substring(secondGroup.indexOf("-") + 1));

                        if (firstValue >= thirdValue && secondValue <= fourthValue) {
                            result += 1;
                        } else if (thirdValue >= firstValue && fourthValue <= secondValue) {
                            result += 1;
                        }
                        return result;
                    };
                    return findPair.apply(element);
                }).reduce(0, (a, b) -> a + b)
        );
    }

    @Test
    void findPairsTestPartTwo() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-test.txt");
        assertEquals(4, list.stream().map(element -> {
                    Function<String, Integer> findPair = stringFromList -> {

                        int result = 0;
                        String regEx = "^(\\d+-\\d+),(\\d+-\\d+)";
                        Pattern pattern = Pattern.compile(regEx);
                        Matcher matcher = pattern.matcher(stringFromList);

                        String firstGroup = null, secondGroup = null;

                        if (matcher.find()) {
                            firstGroup = matcher.group(1);
                            secondGroup = matcher.group(2);
                        }

                        int firstValue = Integer.parseInt(firstGroup.substring(0, firstGroup.indexOf("-")));
                        int secondValue = Integer.parseInt(firstGroup.substring(firstGroup.indexOf("-") + 1));
                        int thirdValue = Integer.parseInt(secondGroup.substring(0, secondGroup.indexOf("-")));
                        int fourthValue = Integer.parseInt(secondGroup.substring(secondGroup.indexOf("-") + 1));

                        List<Integer> firstList = new ArrayList<>();
                        for (int i = firstValue; i < secondValue + 1; i++) {
                            firstList.add(i);
                        }
                        List<Integer> secondList = new ArrayList<>();
                        for (int i = thirdValue; i < fourthValue + 1; i++) {
                            secondList.add(i);
                        }
                        for (Integer e : firstList) {
                            if (secondList.contains(e)) {
                                result += 1;
                                break;
                            }
                        }
                        return result;
                    };
                    return findPair.apply(element);
                }).reduce(0, (a, b) -> a + b)
        );
    }

    @Test
    void findPairsActualPartTwo() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-actual.txt");
        System.out.println(list.stream().map(element -> {
                    Function<String, Integer> findPair = stringFromList -> {

                        int result = 0;
                        String regEx = "^(\\d+-\\d+),(\\d+-\\d+)";
                        Pattern pattern = Pattern.compile(regEx);
                        Matcher matcher = pattern.matcher(stringFromList);

                        String firstGroup = null, secondGroup = null;

                        if (matcher.find()) {
                            firstGroup = matcher.group(1);
                            secondGroup = matcher.group(2);
                        }

                        int firstValue = Integer.parseInt(firstGroup.substring(0, firstGroup.indexOf("-")));
                        int secondValue = Integer.parseInt(firstGroup.substring(firstGroup.indexOf("-") + 1));
                        int thirdValue = Integer.parseInt(secondGroup.substring(0, secondGroup.indexOf("-")));
                        int fourthValue = Integer.parseInt(secondGroup.substring(secondGroup.indexOf("-") + 1));

                        List<Integer> firstList = new ArrayList<>();
                        for (int i = firstValue; i < secondValue + 1; i++) {
                            firstList.add(i);
                        }
                        List<Integer> secondList = new ArrayList<>();
                        for (int i = thirdValue; i < fourthValue + 1; i++) {
                            secondList.add(i);
                        }
                        for (Integer e : firstList) {
                            if (secondList.contains(e)) {
                                result += 1;
                                break;
                            }
                        }
                        return result;

                    };
                    return findPair.apply(element);
                }).reduce(0, (a, b) -> a + b)
        );
    }
}