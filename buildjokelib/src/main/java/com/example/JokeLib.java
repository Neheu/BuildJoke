package com.example;

import java.util.Random;

public class JokeLib {
    String [] arrayOfJokes ;
    public JokeLib()
    {
        arrayOfJokes = new String[]{
                "A computer lets you make more mistakes faster than any invention in human history – with the possible exceptions of handguns and tequila.",
                "There are 10 types of people in the world: those who understand binary, and those who don’t.",
                "Computers make very fast, very accurate mistakes",
                "Whenever I find the key to success, someone changes the lock.",
                "Why did the bee get married? Because he found his honey.",
                "I like work: it fascinates me. I can sit and look at it for hours."
        };
    }
    private static final Random PRNG = new Random();

    public String getRandomJoke() {
        return arrayOfJokes[PRNG.nextInt(arrayOfJokes.length)];
    }

}
