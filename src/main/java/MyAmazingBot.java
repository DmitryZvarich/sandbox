import org.telegram.telegrambots.api.methods.send.SendLocation;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyAmazingBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        Set<String> keywords = new HashSet<>(Arrays.asList("/Jeka", "/ship"));



        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {

            if (keywords.contains(update.getMessage().getText()))
            {

                long chat_id = update.getMessage().getChatId();

                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Jeka is here");

            /*
            // build a URL
            String s = "http://services.marinetraffic.com/api/exportvessel/v:5/417cb1c62b7fc86bfa771bf58d9eff370a5d7f63/mmsi:240447000/timespan:2000/protocol:jsono";
            URL url = null;
            StringBuilder str = new StringBuilder();
            try {
                url = new URL(s);
                // read from the URL
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext())
                    str.append(scan.nextLine());
                scan.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String jsonStr = str.toString().replace("[","").replace("]","");
            System.out.println(jsonStr);
            JSONObject jsonObject = new JSONObject(jsonStr);

            SendLocation location = new SendLocation(Float.valueOf(jsonObject.get("LAT").toString()), Float.valueOf(jsonObject.get("LON").toString()))
                    .setChatId(chat_id);
            */


                SendLocation location = new SendLocation(Float.valueOf("58.461120"), Float.valueOf("-1.513533"))
                        .setChatId(chat_id);


                try {
                    execute(message); // Sending our message object to user
                    execute(location);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            else
            {
                long chat_id = update.getMessage().getChatId();
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Use commands: " + keywords);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getBotUsername()
    {
        return "SandboxJavaUaBot";
    }

    public String getBotToken()
    {
        return "383246512:AAEkOiACMroaUtT8DkhoJooaDJ3d-G2vi-o";
    }
}
