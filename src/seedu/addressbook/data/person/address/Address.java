package seedu.addressbook.data.person.address;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = "(\\d{1,3}.)?.+\\s(\\d{6})$";
    public static final int BLOCK = 0;
    public static final int STREET = 1;
    public static final int UNIT = 2;
    public static final int POSTAL_CODE = 3;
    public static final String COMMA_SEPARATOR = ", ";

    public final Block block = new Block();
    public final Street street = new Street();
    public final Unit unit = new Unit();
    public final PostalCode postalCode = new PostalCode();
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        inputAddressDetails(trimmedAddress);
    }

    /**
     * Inputs address details into respective detail object
     *
     * @param trimmedAddress full address to be separated and input into respective detail object
     */
    private void inputAddressDetails(String trimmedAddress) {
        String[] separatedAddressDetails = trimmedAddress.split("\\s*,\\s*");
        block.inputBlock(separatedAddressDetails[BLOCK]);
        street.inputStreet(separatedAddressDetails[STREET]);
        unit.inputUnit(separatedAddressDetails[UNIT]);
        postalCode.inputPostalCode(separatedAddressDetails[POSTAL_CODE]);
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String stringAddress = block.getBlock() + COMMA_SEPARATOR + street.getStreet() + COMMA_SEPARATOR
                + unit.getUnit() + COMMA_SEPARATOR + postalCode.getPostalCode();
        stringAddress = stringAddress.replaceAll(", $", "");
        return stringAddress;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(other.toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
