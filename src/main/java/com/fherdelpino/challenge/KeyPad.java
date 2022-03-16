package com.fherdelpino.challenge;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeyPad {

    private static Map<Integer, String[]> KEY_PAD = Map.of(
            0, new String[] {""},
            1, new String[] {""},
            2, new String[] {"A", "B", "C"},
            3, new String[] {"D", "E", "F"},
            4, new String[] {"G", "H", "I"},
            5, new String[] {"J", "K", "L"},
            6, new String[] {"M", "N", "O"},
            7, new String[] {"P", "Q", "R", "S"},
            8, new String[] {"T", "U", "V"},
            9, new String[] {"W", "X", "Y", "Z"}
    );

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[] phoneNumber = "9626260251".split("");
        new KeyPad().recursiveListWords(phoneNumber, new String[phoneNumber.length], 0);
        System.out.println(result);
    }

    public void recursiveListWords(String[] phoneNumber, String[] letters, int index) {
        if (index == letters.length) {
            result.add(buildString(letters));
            return;
        }
        var lettersFromNumber = KEY_PAD.get(Integer.parseInt(phoneNumber[index]));

        for (String letterFromNumber : lettersFromNumber) {
            letters[index] = letterFromNumber;
            recursiveListWords(phoneNumber, letters, index + 1);
        }
    }

    public String buildString(String[] letters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : letters) {
            if (!letter.equals("")) {
                stringBuilder.append(letter);
            }
        }
        return stringBuilder.toString();
    }

}
