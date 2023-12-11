package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create a new array list to store user inputs
        ArrayList<String> inputList = new ArrayList<>();

        Boolean response = true;

        /*
            read user inputs
            store the strings in the array
            loop will terminate by type 'exit'
         */
        while(response){
            System.out.println("Enter the string : ");
            System.out.println("If you want to continue type 'exit'");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("exit")){
                response = false;
            }else{
                inputList.add(input);
            }
        }

        //sort the array
        Collections.sort(inputList);

        System.out.println();
        System.out.println("====== Sorted Array =======");

        //output
        for(String str : inputList){
            System.out.println(str);
        }
    }
}