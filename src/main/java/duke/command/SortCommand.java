package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.util.AccessHardDisk;

import java.io.IOException;
import java.util.Comparator;

/** An addCommand, handle whenever the user wants to add a new Task.
 */
public class SortCommand extends Command {

    Comparator<Task> comparator;

    /** Constructor for an AddCommand.
     */
    public SortCommand(Comparator<Task> comparator) {
        this.comparator = comparator;
    }

    /** Override abstract method of Command Class.
     * execute an AddCommand.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public String execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        return tasks.sort(comparator, storage);
    }
}