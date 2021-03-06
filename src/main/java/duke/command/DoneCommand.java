package duke.command;

import duke.util.AccessHardDisk;
import duke.task.TaskList;
import java.io.IOException;

/** A Done Command, handle whenever the user wants to mark a done Task.
 */
public class DoneCommand extends Command {
    private int index;

    /** Constructor for a Done Command.
     * @param index the index of the task that the user wants to mark done.
     */
    public DoneCommand(int index) {
        this.index = index;
    }

    /** Override abstract method of Command Class.
     * execute a Done Command.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        return tasks.markDone(index, storage);
    }
}
