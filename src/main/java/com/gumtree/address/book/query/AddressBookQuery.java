package com.gumtree.address.book.query;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class AddressBookQuery {

    public static final String NAME_DELIMITER = " ";
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


    public long daysOlder(String person1FirstName, String person2FirstName) {
        Map<String, LocalDate> firstNameToDateOfBirth = addressBookEntries.stream()
                                                                          .collect(Collectors.toMap(addressBookEntry -> addressBookEntry.name().split(NAME_DELIMITER)[0],
                                                                                                    AddressBookEntry::dateOfBirth));

        return DAYS.between(firstNameToDateOfBirth.get(person1FirstName), firstNameToDateOfBirth.get(person2FirstName));
    }
}
