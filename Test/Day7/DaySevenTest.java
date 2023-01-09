package Day7;

import ReaderPackage.ReadFromFile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class DaySevenTest {

    ReadFromFile readFromFile = new ReadFromFile();

    @Test
    void checkInput() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day7/day-7-test.txt");
        assertEquals(23, list.size());
    }

    @Test
    void directorySizesActualPartOne() throws FileNotFoundException {
        List<String> list = readFromFile.getInput("src/Day7/day-7-actual.txt");

        Map<String, Integer> directoryMap = new HashMap<>();
        List<String> workingDir = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (String.valueOf(list.get(i).charAt(0)).equals("$")) {
                String[] userInput = list.get(i).split(" ");
                if (userInput[1].equals("cd")) {
                    if (!userInput[2].equals("..")) {
                        workingDir.add(userInput[2]);
                    } else {
                        workingDir.remove(workingDir.size() - 1); //backs out of dir
                    }
                }
            } else if (!list.get(i).startsWith("dir")) {

                //finds files and parses them. Adds to the directoryMap with corresponding key
                String[] file = list.get(i).split(" ");
                int fileSize = Integer.parseInt(file[0]);
                String directoryKey = String.join("/", workingDir).replaceAll("//", "/");
                directoryMap.put(directoryKey, directoryMap.getOrDefault(directoryKey, 0) + fileSize);

                //important to sum up root dir
                while (directoryKey.contains("/")) {
                    directoryKey = directoryKey.substring(0, directoryKey.lastIndexOf("/"));
                    directoryMap.put(directoryKey, directoryMap.getOrDefault(directoryKey, 0) + fileSize);
                }

                //finds values that are less than 100000 and adds to total size
                int totalSize = 0;
                for(Integer size : directoryMap.values()){
                    if(size <= 100000){
                        totalSize += size;
                    }
                }
                System.out.println("Total size: " + totalSize);

            }
        }
    }
}