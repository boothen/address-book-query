package com.gumtree.address.book.query;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AddressBookQuery {

    private final List<AddressBookEntry> addressBookEntries;

    public AddressBookQuery(String filename) throws Exception {
        this.addressBookEntries = new AddressBookParser().addressBookEntries(filename);
    }

    public long numberOfGender(Gender gender) {
        return addressBookEntries.stream()
                                 .collect(Collectors.groupingBy(AddressBookEntry::gender, Collectors.counting()))
                                 .get(gender);
    }

    public Optional<String> oldestPerson() {
        return addressBookEntries.stream()
                                 .sorted(Comparator.comparing(AddressBookEntry::dateOfBirth))
                                 .map(AddressBookEntry::name)
                                 .findFirst();
    }

    
}
