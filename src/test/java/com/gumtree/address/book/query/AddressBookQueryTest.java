package com.gumtree.address.book.query;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookQueryTest {

    private AddressBookQuery addressBookQuery;

    @BeforeEach
    void setup() throws Exception {
        addressBookQuery = new AddressBookQuery("AddressBook");
    }

    @Test
    void numberOfMalesTest() throws Exception {
        long numberOfGender = addressBookQuery.numberOfGender(Gender.Male);
        assertThat(numberOfGender).isEqualTo(3);
    }

    @Test
    void oldestPersonTest() {
        Optional<String> name = addressBookQuery.oldestPerson();
        assertThat(name).isPresent()
                        .get()
                        .isEqualTo("Wes Jackson");
    }

    @Test
    void personDaysOlderTest() {
        long daysOlder = addressBookQuery.daysOlder("Bill", "Paul");
        assertThat(daysOlder).isEqualTo(2862L);
    }
}
