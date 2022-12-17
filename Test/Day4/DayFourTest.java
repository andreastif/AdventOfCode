package Day4;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTest {
    ReadFromFile readFromFile = new ReadFromFile();
    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day4/day-4-test.txt");
        assertEquals(6, list.size());
    }



}