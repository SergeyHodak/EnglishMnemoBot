package telegram;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BotConnection extends TelegramLongPollingCommandBot {
    public BotConnection() {
        register(new StartCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            System.out.println("это кнопка: ");
        } else {
            System.out.println("нема такой команди: " + update.getMessage().getText());
        }
    }

    @Override
    public String getBotUsername() {
        return new ConstantsBot().NAME;
    }

    @Override
    public String getBotToken() {
        return new ConstantsBot().TOKEN;
    }
}