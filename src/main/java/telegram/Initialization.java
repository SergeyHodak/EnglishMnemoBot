package telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Initialization {
    private BotConnection botConnection;

    public Initialization() {
        botConnection = new BotConnection();

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot((LongPollingBot) botConnection);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}