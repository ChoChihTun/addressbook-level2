package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's email in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email extends Contact{

    public static final String EXAMPLE = "valid@e.mail";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Person emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedEmail = email.trim();
        if (!isValidEmail(trimmedEmail)) {
            throw new IllegalValueException(MESSAGE_EMAIL_CONSTRAINTS);
        }
        this.value = trimmedEmail;
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    /**
     * Returns true if the given string is a valid person phone number.
     */
    public static boolean isValidEmail(String test) {
        return isValidProperty(test, EMAIL_VALIDATION_REGEX);
    }

    public String toString() {
        return super.toString(value);
    }

    public boolean equals(Object other) {
        return super.equals(other, value);
    }

    public int hashCode(String value) {
        return super.hashCode();
    }

    public boolean isPrivate() {
        return super.isPrivate(isPrivate);
    }
}
