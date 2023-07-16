package com.fherdelpino.java17;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BookTest {

    @Test
    public void testBook() {
        String bookId = "1";
        String bookName = "The picture of dorian gray";
        BookRecord book = new BookRecord(bookId, bookName);
        assertThat(book.id()).isEqualTo(bookId);
        assertThat(book.name()).isEqualTo(bookName);
        log.info("{}", book); //testing toString() method from record
    }
}
