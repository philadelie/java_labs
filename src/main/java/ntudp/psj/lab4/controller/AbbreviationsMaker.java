package ntudp.psj.lab4.controller;

public interface AbbreviationsMaker {
    default String makeAbbreviation(String str) {
        String abb = "";
        String[] words = str.split(" ");
        for (String word : words) abb += word.charAt(0);
        return abb;
    }
}
