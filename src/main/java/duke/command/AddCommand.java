package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.util.AccessHardDisk;

import java.io.IOException;

/** An addCommand, handle whenever the user wants to add a new Task.
 */
public class AddCommand extends Command {

    private Task task;

    /** Constructor for an AddCommand.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /** Override abstract method of Command Class.
     * execute an AddCommand.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        return tasks.addTask(task, storage);
    }
}
