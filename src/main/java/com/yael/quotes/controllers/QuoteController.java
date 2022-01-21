package com.yael.quotes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
public class QuoteController {
    public QuoteController() {}

    @RequestMapping("/api/quote")
    public String getQuoate() throws FileNotFoundException {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("quotes.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray quotesList = new JSONArray();
            quotesList.add(obj);
            Map temp = (Map) quotesList.get(0);
            // cannot get the array
//            ArrayList<String> al = new ArrayList<String>(temp.get(""));
            System.out.println(quotesList.get(0));
            return quotesList.toString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}


/*
    {"quotes":["When you make the decision to lie to someone, you are also making the decision of losing them as well.","If you are out with the crows at night, you better be able to soar with the eagles in the morning.","Your tree is only as strong as its roots. ","There is something you can do today to achieve your goal for tomorrow. ","You can't play chess without all your pieces on the board. ","How you do anything is how you do everything. Especially under duress.","Everyone is a blessing. Some are a blessing when they come into a room, and others are a blessing when they leave the room. ","Leverage assets, relationships, and resources to get the job done. ","It's not what they call you, it's what you answer too. ","You can't build a house on mud.","Its not where you start, its where you finish. ","Don't have a long road to success, have a long road of success. ","I rather shoot for the moon and miss than to shoot for the gutter and make it. ","Now or later gators. ","Who trusts people will be betrayed. Who depends on them will be disappointed. ","Microphone is more powerful than a grenade. ","Black culture is americas largest export. ","To improve is to change, to perfect is to change often. ","Alone and lonely are two different things. ","The people who fly coach land the same time as the people who fly first class. ","The fear does not go away, you just get more comfortable with it. ","Love is apart of the international lexicon that is understood by everyone. It is also the supreme unifying principle of life.","The day you plant the seed is not the day you eat the fruit. ","Where your focus goes, your energy flows. ","Those who are destined to be hanged do not drown. (Russian quote)","Cannot make diamonds out of diamonds. You have to go thru the process of  cutting, pressure, and heat. ","A failure rap sheet as long as your arm","Humiliation like rejection and critism is the external reflection of internal resistance. ","He lets the bird shit splash down on his slicker remembering that it comes clean with a heavy duty hosing. ","It's a good idea to get a lay of the land before you embark on your journey","Correlation does not bring causation. ","My shoes are not everyone's size so I don't expect everyone to know the experience of walking in them","A broken clock is right twice a day","Sometimes the view is better on the shoulders of giants."]}
 */