package com.fherdelpino.strings;

public class StringTest {

    public static void main(String[] args) {
        new StringTest().run("world");
    }

    public void run(String word) {
        for (int n = 1; n <= word.length(); n++)
            permutations(word, n);
    }

    public void permutations(String word, int n) {
        for (int i = 0; i < word.length() - (n - 1); i++) {
            System.out.println(word.substring(i, i + n));
        }
    }

    String twoStrings(String s1, String s2) {
        for(int n=1; n<=s2.length(); n++)
            for (int i=0; i<s2.length()-(n-1); i++) {
                if (s1.contains(s2.substring(i, i+n)))
                    return "YES";
            }
        return "NO";
    }
}
