package duke.command;

import duke.task.TaskList;
import duke.util.AccessHardDisk;

/**
 * An Unknown Command, handle whenever the user enters a wrong format of a command.
 */
public class UnknownCommand extends Command {

    /**
     * Override abstract method of Command Class.
     * execute a Unknown Command, print an error message.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) {
        return ("Unknown command, please try again");
    }
}
