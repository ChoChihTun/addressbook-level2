package seedu.addressbook.data.person;


import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
    protected boolean isPrivate;

    public final String value;

    /**
     * Validates given property.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Contact(String property, boolean isPrivate, String MESSAGE_PROPERTY_CONSTRAINTS, String PROPERTY_VALIDATION_REGEX) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedProperty = property.trim();
        if (!isValidProperty(trimmedProperty, PROPERTY_VALIDATION_REGEX)) {
            throw new IllegalValueException(MESSAGE_PROPERTY_CONSTRAINTS);
        }
        this.value = trimmedProperty;
    }

    /**
     * Returns true if the given string is a valid person property.
     */
    public static boolean isValidProperty(String test, String PROPERTY_VALIDATION_REGEX) {
        return test.matches(PROPERTY_VALIDATION_REGEX);
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && this.value.equals(((Phone) other).value)); // state check
    }

    public int hashCode(String value) {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
