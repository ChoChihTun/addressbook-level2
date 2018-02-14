package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;

public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits a person's detail identified by "
            + "the index number used in the last find/list call "
            + "and the name of the detail to be edited.\n"
            + "Parameters: INDEX DETAIL NEWDETAIL\n"
            + "Example: " + COMMAND_WORD + " 1 name john";

    private static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";

    private static String detail;

    private static String newDetail;

    public EditCommand(int targetVisibleIndex, String detail, String newDetail) {
        super(targetVisibleIndex);
        this.detail = detail;
        this.newDetail = newDetail;
    }

    @Override
    public CommandResult execute() {
        try {
            final Person target = (Person) getTargetPerson();
            addressBook.editPerson(target, detail, newDetail);
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, target));

        } catch (IndexOutOfBoundsException ie) {
            return new CommandResult(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        } catch (PersonNotFoundException pnfe) {
            return new CommandResult(Messages.MESSAGE_PERSON_NOT_IN_ADDRESSBOOK);
        } catch (IllegalValueException ive) {
            return new CommandResult(String.format(Messages.MESSAGE_INVALID_DETAIL_PROVIDED, detail));
        }
    }

}
