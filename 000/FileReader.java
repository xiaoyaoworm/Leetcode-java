import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader {

    public void readLastNLines(int n_lines){
        File file = new File("./src/123.txt");
        try {
            ReversedLinesFileReader rlfr = new ReversedLinesFileReader(file, StandardCharsets.UTF_8);
            while (n_lines > 0) {
                String line = rlfr.readLine();
                if(line == null) break;
                System.out.println(line);
                n_lines--;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readFirstNLines(int n_lines){
        File file = new File("./src/123.txt");
        try {
            Scanner sc = new Scanner(file);
            while(n_lines > 0 && sc.hasNextLine()){
                System.out.println(sc.nextLine());
                n_lines--;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readNextFewLinesFromStart(int n_lines, int start_offset){
        File file = new File("./src/123.txt");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long file_length = file.length();
            if(start_offset >= file_length) return;
            randomAccessFile.seek(start_offset);

            while(n_lines > 0){
                String line = randomAccessFile.readLine();
                if(line == null) break;
                System.out.println(line);
                n_lines--;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
        FileReader fr = new FileReader();
        fr.readFirstNLines(5);
        System.out.println("-------");
        fr.readLastNLines(5);
        System.out.println("-------");
        fr.readNextFewLinesFromStart(5, 10);
    }
}
