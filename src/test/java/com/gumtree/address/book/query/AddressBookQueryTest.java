package com.gumtree.address.book.query;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBookQueryTest {

    @Test
    void numberOfMalesTest() throws Exception {
        AddressBookQuery addressBookQuery = new AddressBookQuery("AddressBook");
        long numberOfGender = addressBookQuery.numberOfGender(Gender.Male);
        assertThat(numberOfGender).isEqualTo(3);
    }
}
