package seedu.address.logic;

import java.nio.file.Path;

import javafx.beans.property.ReadOnlyProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.participant.Participant;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the AddressBook.
     *
     * @see seedu.address.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Participant> getFilteredPersonList();

    /** Returns an unmodifiable view of the list of undoable commands */
    ObservableList<String> getUndoList();

    /** Returns an unmodifiable view of the list of redoable commands */
    ObservableList<String> getRedoList();

    /**
     * Returns an unmodifiable view of the list of commands entered by the user.
     * The list is ordered from the least recent command to the most recent command.
     */
    ObservableList<String> getHistory();

    /**
     * Returns the user prefs' chart storage path.
     */
    Path getChartStoragePath();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Selected participant in the filtered participant list.
     * null if no participant is selected.
     *
     * @see seedu.address.model.Model#selectedParticipantProperty()
     */
    ReadOnlyProperty<Participant> selectedPersonProperty();

    /**
     * Sets the selected participant in the filtered participant list.
     *
     * @see seedu.address.model.Model#setSelectedParticipant(Participant)
     */
    void setSelectedPerson(Participant participant);

    /**
     * Returns the number of persons by age
     */
    ObservableMap<String, Integer> getAgeData();

    /**
     * Returns the number of persons by sex
     */
    ObservableMap<String, Integer> getSexData();

    /**
     * Returns the number of persons by major
     */
    ObservableMap<String, Integer> getMajorData();

    /**
     * Returns the image files name
     */
    String getFileName();
}
