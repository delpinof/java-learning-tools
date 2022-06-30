package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.Palindrome;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromeTest {

    @Test
    public void test() {
        var palindrome = "Dabale arroz a la zorra el abad";
        var isPalindrome = Palindrome.isPalindrome(palindrome);
        assertThat(isPalindrome).isTrue();
    }
}
