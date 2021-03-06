package duke.command;

import duke.task.TaskList;
import duke.util.AccessHardDisk;
import java.io.IOException;

/** An Exit Command, handle whenever the user wants to exit the programme.
 */
public class ExitCommand extends Command {

    /** Check if the user wants to exit the programme.
     * @return true.
     */
    @Override
    public boolean isExit() {
        return true;
    }

    /** Override abstract method of Command Class.
     * execute an Exit Command.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        return "Goodbye!";
    }
}
