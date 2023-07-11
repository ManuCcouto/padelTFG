package com.padelapp.telegram.config;


import com.padelapp.telegram.sercvice.MyTelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class MyTelegramBotConf {
    private static final Logger logger = LoggerFactory.getLogger(MyTelegramBotConf.class);


    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;


    @Bean
    public DefaultBotOptions defaultBotOptions() {

        logger.info("credenciales {} {}",botToken, botUsername);
        return new DefaultBotOptions();
    }

    @Bean
    public MyTelegramBot getBot() {
        return new MyTelegramBot();
    }


    @Bean
    public TelegramBotsApi telegramBotsApi() throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(getBot());
        return telegramBotsApi;
    }
}
