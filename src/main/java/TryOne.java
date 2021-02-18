/*
import org.json.simple.JSONArray;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TryOne {
    private static Throwable LoggerUtil;

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            String file = readFile("C:\\Users\\xuyin\\IdeaProjects\\Vi-project\\src\\main\\resources\\toy.json");
            JSONArray jsonArray = (JSONArray) parser.parse(file);

            for(int i=0;i<jsonArray.size();i++){
                System.out.println("array is " + jsonArray.get(i));

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filename) {
        FileInputStream fileInputStream = null;
        String data = "";
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            fileInputStream = new FileInputStream(filename);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                stringBuffer.append((char) i);
            }
            data = stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
*/
