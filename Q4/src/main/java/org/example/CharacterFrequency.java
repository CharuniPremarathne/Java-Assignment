package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {

        //read the input string
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String inputString = scanner.nextLine();

        /*
            create the hashmap <Character, Integer>
            store the count of each character
         */
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        //int count = 1;
        //count the characters
        for(char c : inputString.toCharArray()){
            if(Character.isAlphabetic(c)){
                characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c,0) + 1);
            }
        }

        //display the output
        for(char c: characterFrequencyMap.keySet()){
            System.out.println( "Character : " + c + " Frequency : " + characterFrequencyMap.get(c));
        }
    }
}