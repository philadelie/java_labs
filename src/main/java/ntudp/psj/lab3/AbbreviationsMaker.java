package ntudp.psj.lab3;

import ntudp.psj.lab3.model.Department;

public interface AbbreviationsMaker {
    default String makeAbbreviation(String str) {
        String abb = "";
        String[] words = str.split(" ");
        for (String word : words) abb += word.charAt(0);
        return abb;
    }
}
