package seedu.addressbook.commands;

import seedu.addressbook.common.Messages;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.UniquePersonList.PersonNotFoundException;
import seedu.addressbook.ui.TextUi;


public class EditCommand extends Command{

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits a person's detail identified by "
            + "the index number used in the last find/list call "
            + "and the name of the detail to be edited.\n"
            + "Parameters: INDEX DETAIL\n"
            + "Example: " + COMMAND_WORD + " 1 name";

    private static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";

    private static String detail;

    public EditCommand(int targetVisibleIndex, String detail) {
        super(targetVisibleIndex);
        this.detail = detail;
    }

    @Override
    public CommandResult execute() {
        try {
            final Person target = (Person) getTargetPerson();
            TextUi ui = new TextUi();
            final String newDetail = ui.getNewDetail(detail);
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
