package com.gumtree.address.book.query;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.gumtree.address.book.query.Gender.Female;
import static com.gumtree.address.book.query.Gender.Male;
import static org.assertj.core.api.Assertions.assertThat;


class AddressBookParserTest {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final AddressBookParser addressBookParser = new AddressBookParser();

    @Test
    void shouldParseAddressBook() throws Exception {
        List<AddressBookEntry> addressBookEntries = addressBookParser.addressBookEntries("AddressBook");
        assertThat(addressBookEntries).hasSize(5)
                                      .containsExactly(new AddressBookEntry("Bill McKnight", Male, LocalDate.parse("16/03/1977", DATE_TIME_FORMATTER)),
                                                       new AddressBookEntry("Paul Robinson", Male, LocalDate.parse("15/01/1985", DATE_TIME_FORMATTER)),
                                                       new AddressBookEntry("Gemma Lane", Female, LocalDate.parse("20/11/1991", DATE_TIME_FORMATTER)),
                                                       new AddressBookEntry("Sarah Stone", Female, LocalDate.parse("20/09/1980", DATE_TIME_FORMATTER)),
                                                       new AddressBookEntry("Wes Jackson", Male, LocalDate.parse("14/08/1974", DATE_TIME_FORMATTER)));
    }

}