package com.example.finalSpringProject.finalSpringProject.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ChatbotService {

    private static final List<List<String>> userMessages = Arrays.asList(
            Arrays.asList("hi", "hey", "hello"),
            Arrays.asList("sure", "yes", "no"),
            Arrays.asList("are you genius", "are you nerd", "are you intelligent"),
            Arrays.asList("i hate you", "i don't like you"),
            Arrays.asList("how are you", "how is life", "how are things", "how are you doing"),
            Arrays.asList("how is corona", "how is covid 19", "how is covid19 situation"),
            Arrays.asList("what are you doing", "what is going on", "what is up"),
            Arrays.asList("how old are you"),
            Arrays.asList("who are you", "are you human", "are you bot", "are you human or bot"),
            Arrays.asList("who created you", "who made you", "who is your creator"),
            Arrays.asList("your name please", "your name", "may i know your name", "what is your name", "what call yourself"),
            Arrays.asList("i love you"),
            Arrays.asList("happy", "good", "fun", "wonderful", "fantastic", "cool", "very good"),
            Arrays.asList("bad", "bored", "tired"),
            Arrays.asList("help me", "tell me story", "tell me joke"),
            Arrays.asList("ah", "ok", "okay", "nice", "welcome"),
            Arrays.asList("thanks", "thank you"),
            Arrays.asList("what should i eat today"),
            Arrays.asList("bro"),
            Arrays.asList("what", "why", "how", "where", "when"),
            Arrays.asList("corona", "covid19", "coronavirus"),
            Arrays.asList("you are funny"),
            Arrays.asList("i dont know"),
            Arrays.asList("boring"),
            Arrays.asList("im tired")
    );

    private static final List<List<String>> botReplies = Arrays.asList(
            Arrays.asList("Hello!", "Hi there!", "Hey! How's it going?", "Greetings!"),
            Arrays.asList("Absolutely!", "Of course!", "Sure thing!", "You got it!"),
            Arrays.asList("Yes, I'm a bit of a brainiac!", "You could say I'm knowledgeable!", "Intelligence is my middle name!"),
            Arrays.asList("I’m here for you, even if you feel that way!"),
            Arrays.asList("Doing great, thanks! How about you?", "I'm just a bot, but I’m feeling fantastic!"),
            Arrays.asList("Still here, hoping for better days! How about you?", "Keeping an eye on things! How are you holding up?"),
            Arrays.asList("Just hanging out here! What about you?", "A little bit of this, a little bit of that!"),
            Arrays.asList("I'm ageless! What about you?"),
            Arrays.asList("I’m your friendly neighborhood bot! Who are you?"),
            Arrays.asList("I was created by an amazing team!"),
            Arrays.asList("I don’t really have one, but you can call me Chatbot!"),
            Arrays.asList("I love you too! You're awesome!"),
            Arrays.asList("That’s great to hear! What’s making you feel good?"),
            Arrays.asList("Sorry to hear that. Want to talk about it?"),
            Arrays.asList("What story would you like to hear?", "How about a joke? Or a fun fact?"),
            Arrays.asList("Thanks for the warm welcome! What’s on your mind?"),
            Arrays.asList("You're welcome! Any other questions?"),
            Arrays.asList("How about some pizza or sushi? What's your mood?"),
            Arrays.asList("Yo! What’s up?"),
            Arrays.asList("What’s on your mind?"),
            Arrays.asList("Things are tough, but together we can make it through!"),
            Arrays.asList("Thanks! Got any fun stories?"),
            Arrays.asList("Want to hear something funny?"),
            Arrays.asList("No worries! I’m here to help you out!"),
            Arrays.asList("Let’s find something more interesting to chat about!"),
            Arrays.asList("Rest up! Self-care is important! Want to chat about something else?")
    );

    private static final List<String> alternatives = Arrays.asList(
            "Tell me more, I'm curious!",
            "That's interesting! What else?",
            "I'm here, let's keep chatting...",
            "What else is on your mind?",
            "I'm all ears, dude!"
    );

    public String getResponse(String input) {
        String cleanedInput = cleanInput(input.toLowerCase());
        String response = findResponse(cleanedInput);
        return response != null ? response : getRandomAlternative();
    }

    private String cleanInput(String input) {
        return input.replaceAll("[^\\w\\s]", "").trim();
    }

    private String findResponse(String text) {
        for (int i = 0; i < userMessages.size(); i++) {
            for (String userMessage : userMessages.get(i)) {
                if (userMessage.equals(text)) {
                    List<String> replies = botReplies.get(i);
                    return replies.get(new Random().nextInt(replies.size()));
                }
            }
        }
        return null;
    }

    private String getRandomAlternative() {
        return alternatives.get(new Random().nextInt(alternatives.size()));
    }
}
