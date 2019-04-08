package seedu.address.logic.commands;

import org.junit.Test;
import seedu.address.commons.core.Messages;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.FindingOglPredicate;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.*;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

public class ListOglCommandTest {
    private Model model = new ModelManager(getAddressBookWithOneFreshmanOrOgl(), new UserPrefs()); //no Freshman
    private Model expectedModel = new ModelManager(getAddressBookWithOneFreshmanOrOgl(), new UserPrefs()); //no Freshman

    private CommandHistory commandHistory = new CommandHistory();

    private FindingOglPredicate preparePredicate() {

        return new FindingOglPredicate(Arrays.asList("OGL".split("\\s+")));
    }

    @Test
    public void execute_listHasOneOgl() {
        model = new ModelManager(getAddressBookWithOneFreshmanOrOgl(), new UserPrefs()); //no Freshman
        expectedModel = new ModelManager(getAddressBookWithOneFreshmanOrOgl(), new UserPrefs()); //no Freshman
        FindingOglPredicate predicate = preparePredicate();
        ListOglCommand command = new ListOglCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        String expectedMessage = String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, 1);
        assertCommandSuccess(command, model, commandHistory,
                expectedMessage, expectedModel);
        assertEquals(Arrays.asList(SONIA), model.getFilteredPersonList());
    }


    @Test
    public void execute_listHasNoOgl() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs()); //no Freshman
        FindingOglPredicate predicate = preparePredicate();
        ListOglCommand command = new ListOglCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        String expectedMessage = String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, 0);
        assertCommandSuccess(command, model, commandHistory,
                expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }
}