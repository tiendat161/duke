package duke.command;

import duke.task.TaskList;
import duke.util.AccessHardDisk;

import java.io.IOException;

/** An addCommand, handle whenever the user wants to add a new Task.
 */
public class FindCommand extends Command {

    private String keyWord;

    /** Constructor for an AddCommand.
     */
    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    /** Override abstract method of Command Class.
     * execute an AddCommand.
     * @param tasks     the user's TaskList.
     * @param storage   the storage to save any changes.
     */
    @Override
    public void execute(TaskList tasks, AccessHardDisk storage) throws IOException {
        tasks.findTask(this.keyWord);
    }
}