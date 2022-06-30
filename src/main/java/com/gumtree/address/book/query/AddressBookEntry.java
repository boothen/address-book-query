package com.gumtree.address.book.query;

import java.time.LocalDate;

public record AddressBookEntry(String name, Gender gender, LocalDate dateOfBirth) {

}
