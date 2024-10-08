package org.example.it_sakerhet_java23_alexander_jansson;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface interfaceUI {


    default void header(){};

    default void table(String tableHeader, String... fullData){
        System.out.println(tableHeader);
        for (int i = 0; i < fullData.length; i++) {
            for (String data : fullData) {
                System.out.println(i + data);
            }
        }
    }

    default  void navigationMenu(String... buttons){
        System.out.println("MENU: ");
        for(String button : buttons){
            System.out.println(button);
        }

    }


    default void textSection(String... paragraphs){
        String line = breakLine();
        for(String paragraph : paragraphs){
            System.out.println(paragraph + line);
        }
    }


    default void footer(String location, String phone, int openHours){
        System.out.println("Location: " + location + "Contact us"  + phone + "Opening hours: " + openHours);
    };

    default void form(){}



    default void searchBar(String... parameters){
        Scanner scanner = new Scanner(System.in);
        Alert("Type in: " + Arrays.toString(parameters) + " to search");
    }

    default <T> void list(String header, List<T> listContent) {
        System.out.println(breakLine() + header + breakLine());
        breakLine();

        int level = 4;
        String indent = " ".repeat(level * 4);

        for (T item : listContent) {
            System.out.println(breakLine());
            System.out.println(item.toString());
        }
        breakLine();
        button("ADD", "REMOVE", "UPDATE");
    }


    default void Alert(String error){
        System.out.println("ALERT: " + error);
    }
    default String breakLine(){
        return "------------------------------";
    }

    default String button(String... button){
        return "[" + Arrays.toString(button) + "]";
    }

    default String redirect(){
        return "redirect:/";
    }


}
