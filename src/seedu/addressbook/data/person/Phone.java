package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPhone(String)}
 */
public class Phone {

    public static final String EXAMPLE = "123456789";
    public static final String MESSAGE_PHONE_CONSTRAINTS = "Person phone numbers should only contain numbers";
    public static final String PHONE_VALIDATION_REGEX = "\\d+";

    private String value;
    private boolean isPrivate;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given phone string is invalid.
     */
    public Phone(String phone, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedPhone = phone.trim();
        if (!isValidPhone(trimmedPhone)) {
            throw new IllegalValueException(MESSAGE_PHONE_CONSTRAINTS);
        }
        this.value = trimmedPhone;
    }

    /**
     * Edits current phone.
     *
     * @param newPhone replaces current phone with this phone
     * @throws IllegalValueException if given phone string is invalid.
     */
    public void editCurrentPhone(String newPhone) throws IllegalValueException {
        String trimmedNewPhone = newPhone.trim();
        if (!isValidPhone(trimmedNewPhone)) {
            throw new IllegalValueException(MESSAGE_PHONE_CONSTRAINTS);
        }
        this.value = new String(trimmedNewPhone);
    }

    /**
     * Returns true if the given string is a valid person phone number.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(PHONE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Returns person's phone number
     */
    public String getValue() {
        return value;
    }
}
