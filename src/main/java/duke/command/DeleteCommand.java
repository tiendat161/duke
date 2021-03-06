package duke.command;

import duke.task.TaskList;
import duke.util.AccessHardDisk;
import java.io.IOException;

/**
 * A Delete Command, handle whenever the user wants to delete a Task.
 */
public class DeleteCommand extends Command {

    private int index;

    /** Constructor for a Delete Command.
     * @param index the index of the task that the user wants to delete.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /** Override abstract method of Command Class.
     * execute a DeleteCommand.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        return tasks.delete(index, storage);
    }
}
