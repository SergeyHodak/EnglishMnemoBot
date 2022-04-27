package telegram;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.nio.charset.StandardCharsets;


public class StartCommand extends BotCommand {

    public StartCommand() {
        super("start", "Команда Старт");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        String text = "Ну здравствуй";

        SendMessage message = new SendMessage();
        message.setText(convert(text)); // что отправляем
        message.setChatId(Long.toString(chat.getId())); // кому

        try {
            absSender.execute(message); // отправили
        } catch (TelegramApiException e) {
            System.out.println("не получилось отправить из-за:");
            e.printStackTrace();
        }
    }

    private String convert(String text) {
        return  new String(text.getBytes(), StandardCharsets.UTF_8);
    }
}