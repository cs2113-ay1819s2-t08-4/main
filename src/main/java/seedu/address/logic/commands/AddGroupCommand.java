package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.grouping.Group;
import seedu.address.model.grouping.House;

public class AddGroupCommand extends Command {

    public static final String COMMAND_WORD = "add_g";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a group into a house. Parameters: " +
            "groupName + houseName";

    public static final String MESSAGE_SUCCESS = "New group added: %1$s";
    public static final String MESSAGE_NONEXISTENT_HOUSE = "This house does not exist. Create house first!";
    public static final String MESSAGE_DUPLICATE_GROUP = "This group already exists";

    public static String groupName;
    public static String houseName;

    public AddGroupCommand(String groupName, String houseName) {
        requireNonNull(groupName);
        this.groupName = groupName;
        this.houseName = houseName;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        requireNonNull(model);

        Group toAddGroup = new Group(groupName, houseName);

        if (!model.hasHouse(houseName)) {
            throw new CommandException(MESSAGE_NONEXISTENT_HOUSE);
        }

        House baseHouse = model.getHouse(houseName);

        if (!baseHouse.hasGroup(groupName)) {
            throw new CommandException(MESSAGE_DUPLICATE_GROUP);
        }

        model.addGroup(groupName, houseName);
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, groupName));
    }
}
