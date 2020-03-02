package duke.command;

import duke.task.TaskList;
import duke.util.AccessHardDisk;
import java.io.IOException;

/** Abstract class of for other types of command (e.g AddCommand, DeleteCommand, DoneCommand, etc).
 */
public abstract class Command {

    /** A method to check if the user wants to exit or continue with the programme.
     * @return a boolean.
     */
    public boolean isExit() {
        return false;
    }

    /** An abstract method to execute a command, given a task and a storage to save any changes.
     * @param storage    the storage to save any changes.
     * @param tasks      the user's TaskList.
     */
    public abstract String execute(TaskList tasks, AccessHardDisk storage) throws IOException;
}
