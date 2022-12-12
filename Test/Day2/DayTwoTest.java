package Day2;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class DayTwoTest {

    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day2/day-2-test.txt");
        assertEquals(3, list.size());
    }

    @Test
    void totalPointsTest() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day2/day-2-test.txt");

        System.out.println(list.stream().map(e -> {
            Function<String, Integer> evaluateGame = ex -> {
                int playerPoints = 0;
                char opponent = ex.charAt(0);
                //rock (A, X)
                if (ex.substring(2).equalsIgnoreCase("X")) {
                    switch (opponent) {
                        case 'A' -> playerPoints = playerPoints + 3; //draw
                        case 'C' -> playerPoints = playerPoints + 6; //i win
                    }
                    playerPoints = playerPoints + 1;
                }
                //paper (B, Y)
                else if (ex.substring(2).equals("Y")) {
                    playerPoints = switch (opponent) {
                        case 'B' -> playerPoints + 3; //draw
                        case 'A' -> playerPoints + 6; //i win
                        default -> playerPoints;
                    };
                    playerPoints = playerPoints + 2;
                }
                //scissor (C, Z)
                else {
                    playerPoints = switch (opponent) {
                        case 'C' -> playerPoints + 3; //draw
                        case 'B' -> playerPoints + 6; //i win
                        default -> playerPoints;
                    };
                    playerPoints = playerPoints + 3;
                }
                return playerPoints;
            };
            return evaluateGame.apply(e);
        }).reduce(0,(a,b) -> a+b));
    }

    @Test
    void totalPointsActual() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day2/day-2-actual.txt");

        System.out.println(list.stream().map(e -> {
            Function<String, Integer> evaluateGame = ex -> {
                int playerPoints = 0;
                char opponent = ex.charAt(0);
                //rock (A, X)
                if (ex.substring(2).equalsIgnoreCase("X")) {
                    switch (opponent) {
                        case 'A' -> playerPoints = playerPoints + 3; //draw
                        case 'C' -> playerPoints = playerPoints + 6; //i win
                    }
                    playerPoints = playerPoints + 1;
                }
                //paper (B, Y)
                else if (ex.substring(2).equals("Y")) {
                    playerPoints = switch (opponent) {
                        case 'B' -> playerPoints + 3; //draw
                        case 'A' -> playerPoints + 6; //i win
                        default -> playerPoints;
                    };
                    playerPoints = playerPoints + 2;
                }
                //scissor (C, Z)
                else {
                    playerPoints = switch (opponent) {
                        case 'C' -> playerPoints + 3; //draw
                        case 'B' -> playerPoints + 6; //i win
                        default -> playerPoints;
                    };
                    playerPoints = playerPoints + 3;
                }
                return playerPoints;
            };
            return evaluateGame.apply(e);
        }).reduce(0,(a,b) -> a+b));
    }
}