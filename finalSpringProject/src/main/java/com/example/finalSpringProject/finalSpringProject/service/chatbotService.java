package com.example.finalSpringProject.finalSpringProject.service;

import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class chatbotService {

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
            Arrays.asList("Hello!", "Hi!", "Hey!", "Hi there!"),
            Arrays.asList("Okay"),
            Arrays.asList("Yes I am!"),
            Arrays.asList("I'm sorry about that. But I like you dude."),
            Arrays.asList("Fine... how are you?", "Pretty well, how are you?", "Fantastic, how are you?"),
            Arrays.asList("Getting better. There?", "Somewhat okay!", "Yeah fine. Better stay home!"),
            Arrays.asList("Nothing much", "About to go to sleep", "Can you guess?", "I don't know actually"),
            Arrays.asList("I am always young."),
            Arrays.asList("I am just a bot", "I am a bot. What are you?"),
            Arrays.asList("Sabitha Kuppusamy"),
            Arrays.asList("I am nameless", "I don't have a name"),
            Arrays.asList("I love you too", "Me too"),
            Arrays.asList("Have you ever felt bad?", "Glad to hear it"),
            Arrays.asList("Why?", "Why? You shouldn't!", "Try watching TV", "Chat with me."),
            Arrays.asList("What about?", "Once upon a time..."),
            Arrays.asList("Tell me a story", "Tell me a joke", "Tell me about yourself"),
            Arrays.asList("You're welcome"),
            Arrays.asList("Biryani", "Burger", "Sushi", "Pizza"),
            Arrays.asList("Dude!"),
            Arrays.asList("Yes?"),
            Arrays.asList("Please stay home"),
            Arrays.asList("Glad to hear it"),
            Arrays.asList("Say something interesting"),
            Arrays.asList("Sorry for that. Let's chat!"),
            Arrays.asList("Take some rest, Dude!")
    );

    private static final List<String> alternatives = Arrays.asList(
            "Same here, dude.",
            "That's cool! Go on...",
            "Dude...",
            "Ask something else...",
            "Hey, I'm listening..."
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


