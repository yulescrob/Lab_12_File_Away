import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class Main {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        chooser.setCurrentDirectory(target.toFile());
        int totalLines=0;
        int totalWords=0;
        int totalChars=0;

        try {
            if (chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
                target = chooser.getSelectedFile().toPath();
                inFile = new Scanner(target);
                System.out.println("File: " + target.getFileName());// the name of the file
                while (inFile.hasNextLine()){
                    line = inFile.nextLine();
                    totalLines++;
                    String [] array = line.split(" ");
                    totalWords  = totalWords + array.length;
                    totalChars += line.length();

                }
                inFile.close(); //closing the file
                System.out.printf("Number of lines: %d\nNumber of words: %d\nNumber of Characters: %d\n", totalLines, totalWords, totalChars);
            }else {//did not select a file and terminates
                System.out.println("Must select a file. Terminating!");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}