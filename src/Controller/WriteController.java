package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteController {
    public void WriteToFile(String text){
        File myFile = new File("file.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
