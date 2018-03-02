import java.io.*;

/**
 * Created by Ariana on 2018/2/7.
 */
public class test {
    public static void main(String[] args) {
        File file =new File("test");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");

            PrintStream printStream = new PrintStream(new FileOutputStream(file));
            printStream.append("666");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
