package duke.command;

import duke.task.*;
import duke.util.*;
/**
 * An Unknown Command, handle whenever the user enters a wrong format of a command
 */
public class UnknownCommand extends Command{

    /**
     * Override abstract method of Command Class
     * execute a Unknown Command, print an error message
     * @param tasks     the user's TaskList
     * @param storage   the storage to save any changes
     */
    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) {
        System.out.println("Unknown command, please try again");
    }
}
