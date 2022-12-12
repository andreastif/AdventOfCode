package ReaderPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class ReadFromFile {

    public ReadFromFile() {
    }

    public List<String> getInput(String path) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        String currentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((currentLine = br.readLine()) != null) {
                lines.add(currentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

}
