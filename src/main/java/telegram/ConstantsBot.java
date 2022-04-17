package telegram;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConstantsBot {
    public String  NAME;
    public String  TOKEN;

    public ConstantsBot() {
        try (FileReader fail = new FileReader("constants.txt")) {
            int count;
            StringBuilder result = new StringBuilder();
            while ((count = fail.read()) != -1) {
                if ((char) count == '\n') {
                    NAME = result.toString();
                    result = new StringBuilder();
                } else {
                    result.append((char) count);
                }
            }
            TOKEN = result.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}