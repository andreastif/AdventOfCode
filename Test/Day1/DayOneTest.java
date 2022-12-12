package Day1;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.*;


class DayOneTest {
    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> myList = readFromFile.getInput("src/Day1/day-1-test.txt");
        assertEquals(14, myList.size());
    }


    //part one test
    @Test
    void findElfWithMostCaloriesTest() throws FileNotFoundException {
        List<String> myList = readFromFile.getInput("src/Day1/day-1-test.txt");

        long biggestNumber = 0;
        long currentNumber = 0;
        for (String line : myList) {
            if (!line.isBlank()) {
                currentNumber = currentNumber + Integer.parseInt(line);
                if (currentNumber > biggestNumber) {
                    biggestNumber = currentNumber;
                }
            } else
                currentNumber = 0;
        }
        assertEquals(24000, biggestNumber);
        System.out.println(biggestNumber);
    }

    //part one actual
    @Test
    void findElfWithMostCaloriesActual() throws FileNotFoundException {
        List<String> myList = readFromFile.getInput("src/Day1/day-1-actual.txt");

        long biggestNumber = 0;
        long currentNumber = 0;
        for (String line : myList) {
            if (!line.isBlank()) {
                currentNumber = currentNumber + Integer.parseInt(line);
                if (currentNumber > biggestNumber) {
                    biggestNumber = currentNumber;
                }
            } else
                currentNumber = 0;
        }
        System.out.println(biggestNumber);
    }

    //part two actual but better (with streams) -New-
    @Test
    void findElfWithMostCaloriesPartTwoActualStream() throws FileNotFoundException {
        List<String> strings = readFromFile.getInput("src/Day1/day-1-actual.txt");
        List<Integer> listOfBiggestNumbers = new ArrayList<>();

        List<Integer> anotherList = strings.stream()
                .map(e -> Arrays.stream(e.split("\r\n"))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .sum())
                .toList();

        List<Integer> finalList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < anotherList.size(); i++) {
            try {
                if (anotherList.get(i) != 0) {
                    sum = sum + anotherList.get(i);
                } else {
                    finalList.add(sum);
                    sum = 0;
                }
                if (anotherList.get(i + 1) == 0) {
                    //do nothing, just break
                }
            } catch (IndexOutOfBoundsException ioobe) {
                finalList.add(sum);
            }
        }
        Collections.sort(finalList);
        Collections.reverse(finalList);
        for (int i=0; i<3;i++) {
            listOfBiggestNumbers.add(finalList.get(i));
        }
        System.out.println(listOfBiggestNumbers);
    }


    //part two test but better (with streams) -New-
    @Test
    void findElfWithMostCaloriesPartTwoActualStreamTest() throws FileNotFoundException {
        List<String> strings = readFromFile.getInput("src/Day1/day-1-test.txt");
        List<Integer> listOfBiggestNumbers = new ArrayList<>(List.of());

        List<Integer> anotherList = strings.stream()
                .map(e -> Arrays.stream(e.split("^0$"))
                        .filter(s -> !s.isEmpty())
                        .mapToInt(Integer::parseInt)
                        .sum()).toList();

        List<Integer> finalList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < anotherList.size(); i++) {
            try {

                if (anotherList.get(i) != 0) {
                    sum = sum + anotherList.get(i);
                } else {
                    finalList.add(sum);
                    sum = 0;
                }
                if (anotherList.get(i + 1) == 0) {
                    //do nothing, just break
                }
            } catch (IndexOutOfBoundsException ioobe) {
                finalList.add(sum);
            }
        }
        Collections.sort(finalList);
        Collections.reverse(finalList);
        for (int i=0; i<3;i++) {
            listOfBiggestNumbers.add(finalList.get(i));
        }
        System.out.println(finalList);
        System.out.println(anotherList);
        System.out.println(listOfBiggestNumbers);
    }
    //part two actual -Old-
    /*
    @Test
    void findElfWithMostCaloriesPartTwoActual() throws FileNotFoundException {
        List<String> myList = readFromFile.getInput("src/Day1/day-1-actual.txt");
        List<Long> listOfBiggestNumbers = new ArrayList<>(List.of());

        long currentNumber = 0L;
        long totalCal;

        for (int i = 0; i < myList.size(); i++) {
            String line = myList.get(i);
            try {
                currentNumber = currentNumber + Long.parseLong(line);
                if (i == myList.size() - 1) {
                    Long lowestVal = Long.MAX_VALUE;
                    for (Long num : listOfBiggestNumbers) {
                        lowestVal = num < lowestVal ? num : lowestVal;
                    }
                    if (currentNumber > lowestVal) {
                        listOfBiggestNumbers.set(listOfBiggestNumbers.indexOf(lowestVal), currentNumber);
                    }
                }
            } catch (NumberFormatException nfe) {
                if (listOfBiggestNumbers.size() < 3) {
                    listOfBiggestNumbers.add(currentNumber);
                } else {
                    Long lowestVal = Long.MAX_VALUE;
                    for (Long num : listOfBiggestNumbers) {
                        lowestVal = num < lowestVal ? num : lowestVal;
                    }
                    if (currentNumber > lowestVal) {
                        listOfBiggestNumbers.set(listOfBiggestNumbers.indexOf(lowestVal), currentNumber);
                    }
                }
                currentNumber = 0;
            }
        }
        totalCal = listOfBiggestNumbers
                .stream()
                .mapToLong(e -> e)
                .sum();
        System.out.println(totalCal);
        System.out.println(listOfBiggestNumbers);
    }

    //part two test
    @Test
    void findElfWithMostCaloriesPartTwoTest() throws FileNotFoundException {
        List<String> myList = readFromFile.getInput("src/Day1/day-1-test.txt");
        List<Long> listOfBiggestNumbers = new ArrayList<>(List.of());

        long currentNumber = 0L;
        long totalCal;

        for (int i = 0; i < myList.size(); i++) {
            String line = myList.get(i);
            try {
                currentNumber = currentNumber + Long.parseLong(line);
                if (i == myList.size() - 1) {
                    Long lowestVal = Long.MAX_VALUE;
                    for (Long num : listOfBiggestNumbers) {
                        lowestVal = num < lowestVal ? num : lowestVal;
                    }
                    if (currentNumber > lowestVal) {
                        listOfBiggestNumbers.set(listOfBiggestNumbers.indexOf(lowestVal), currentNumber);
                    }
                }
            } catch (NumberFormatException nfe) {
                if (listOfBiggestNumbers.size() < 3) {
                    listOfBiggestNumbers.add(currentNumber);
                } else {
                    Long lowestVal = Long.MAX_VALUE;
                    for (Long num : listOfBiggestNumbers) {
                        lowestVal = num < lowestVal ? num : lowestVal;
                    }
                    if (currentNumber > lowestVal) {
                        listOfBiggestNumbers.set(listOfBiggestNumbers.indexOf(lowestVal), currentNumber);
                    }
                }
                currentNumber = 0;
            }
        }
        totalCal = listOfBiggestNumbers
                .stream()
                .mapToLong(e -> e)
                .sum();
        System.out.println(totalCal);
        System.out.println(listOfBiggestNumbers);
        assertEquals(45000, totalCal);

    }
  */
}