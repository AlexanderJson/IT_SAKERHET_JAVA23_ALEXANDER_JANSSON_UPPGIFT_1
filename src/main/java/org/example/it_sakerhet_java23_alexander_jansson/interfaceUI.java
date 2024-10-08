package org.example.it_sakerhet_java23_alexander_jansson;

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



    default void searchBar(){}
    default void list(){}
    default void Alert(String error){
        System.out.println("ALERT: " + error);
    }
    default String breakLine(){
        return "------------------------------";
    }

    default String redirect(){
        return "redirect:/";
    }


}
