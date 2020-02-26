package duke.command;

import duke.task.*;
import duke.util.*;

/**
 * An Show Command, handle whenever the user wants to show the list of the task
 */
public class ShowCommand extends Command {

    /**
     * Override abstract method of Command Class
     * execute a Show Command
     * @param tasks     the user's TaskList
     * @param storage   the storage to save any changes
     */
    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) {
        tasks.showTaskList();
    }
}
