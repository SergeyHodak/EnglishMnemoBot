package telegram;

import java.io.FileReader;
import java.io.IOException;

public class ConstantsBot {
    public String NAME;
    public String TOKEN;

    public ConstantsBot() {
        try (FileReader fail = new FileReader("D:\\constants.txt")) { // путь к файлу, где записаны данные токен имя
            int count; // переменная для хранения значения прочитанного байта
            StringBuilder result = new StringBuilder(); // временное хранилище данных
            while ((count = fail.read()) != -1) { // выполняем пока в файле еще есть биты
                if ((char) count == '\n') { // если это бит переноса строки
                    NAME = result.toString(); // сгружаем в имя все что во временном хранилище
                    result = new StringBuilder(); // обнуляем временное хранилище
                } else { // иначе
                    result.append((char) count); // записываем бит во временное хранилище
                }
            }
            TOKEN = result.toString(); // все что было в хранилище, записываем в токен
        } catch (IOException e) {
            System.out.println("не удалось получить токен и имя с файла, по причине:");
            e.printStackTrace();
        }
    }
}