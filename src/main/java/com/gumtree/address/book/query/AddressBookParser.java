package com.gumtree.address.book.query;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class AddressBookParser {

    private static final String DELIMITER = ",";

    public List<AddressBookEntry> addressBookEntries(String filename) throws Exception {
        return Files.readAllLines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))
                    .stream()
                    .map(this::convertToAddressBookEntry)
                    .toList();
    }

    private AddressBookEntry convertToAddressBookEntry(String line) {
        String[] split = line.split(DELIMITER);
        String name = split[0].trim();
        Gender gender = Gender.valueOf(split[1].trim());
        String dateOfBirthString = split[2].trim();
        String[] dateOfBirthParts = dateOfBirthString.split("/");
        LocalDate dateOfBirth = LocalDate.parse(String.format("19%s-%s-%s", dateOfBirthParts[2], dateOfBirthParts[1], dateOfBirthParts[0]));
        return new AddressBookEntry(name, gender, dateOfBirth);
    }
}
