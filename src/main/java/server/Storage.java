package server;

import java.io.FileReader;
import java.io.FileWriter;

public class Storage implements Repository {

    public static final String LOG_PATH = "C:\\Users\\sipatov\\Desktop\\Sipatov\\GB_Learning\\JDK\\homework\\homework02\\JDK_HW2\\src\\main\\java\\log.txt";

    @Override
    public void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}