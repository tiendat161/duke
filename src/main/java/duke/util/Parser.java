package duke.util;

import duke.command.*;
import duke.exception.DukeException;
import duke.task.*;


/**
 * A class to help handle all the logic of the programme.
 */
public class Parser {
    protected TaskList tasks;

    /**
     * Constructor of a Parser object.
     * @param tasks     the Task List of the user.
     */
    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Process command from user's CLI, recognize the type of command and its descriptions.
     * @param fullCommand   input from user's CLI.
     */
    public Command parse(String fullCommand) throws DukeException {

        String keyword = fullCommand.toLowerCase().trim();
        if (keyword.equals("bye")) {
            return new ExitCommand();
        } else if (fullCommand.toLowerCase().trim().equals("list")) {
            return new ShowCommand();
        }

        String[] action = fullCommand.split(" ");
        keyword = action[0].toLowerCase().trim();
        if (keyword.equals("done")) {
            if (action.length == 1) {
                throw  new DukeException("The 'done' command is missing a number argument.");
            }
            int index = 0;
            try {
                index = Integer.parseInt(action[1]);
            } catch (NumberFormatException e) {
                throw new DukeException("The argument of a 'done' command must be a number.");
            }
            if (index <= 0 || index > this.tasks.checkSize()) {
                throw new DukeException("The index of a 'done' command is out of bounce.");
            }
            assert index > this.tasks.checkSize() : "The 'done' command task index is out of bounce (high)";
            return new DoneCommand(index);
        }else if (keyword.equals("delete")) {
            int index = 0;
            try {
                index = Integer.parseInt(action[1]);
            } catch (NumberFormatException e) {
                throw new DukeException("The argument of a 'delete' command must be a number.");
            }
            if (index <= 0 || index > this.tasks.checkSize()) {
                throw new DukeException("The index of a 'delete' command is out of bounce.");
            }
            assert index > this.tasks.checkSize() : "The 'delete' command task index is out of bounce (high)";
            return new DeleteCommand(index);
        } else if (keyword.equals("todo")) {
            if (action.length == 1) {
                throw new DukeException("The description of a 'todo' command is missing.");
            }
            assert fullCommand.split(" ", 2)[1] != null : "The 'todo' command description is missing ";
            return new AddCommand(new Todo(fullCommand.split(" ", 2)[1]));
        } else if (keyword.equals("deadline")) {
            String time;
            String details;
            if (action.length == 1) {
                throw new DukeException("The description of a 'deadline' command is missing.");
            }
            String description = fullCommand.split(" ", 2)[1];
            String[] splitDescription = description.split(" /by ");
            try {
                details = splitDescription[0];
                time = splitDescription[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("The format for 'deadline' command requires a description "
                        + "following by </by> notation and a due date.");
            }
            assert time != null: "Timing is invalid to pass to AddCommand";
            return new AddCommand(new Deadline(details, time));
        } else if (keyword.equals("event")) {
            String time;
            String details;
            if (action.length == 1) {
                throw new DukeException("The description of a 'event' command is missing.");
            }
            String description = fullCommand.split(" ", 2)[1];
            String[] splitDescription = description.split(" /at ");
            try {
                details = splitDescription[0];
                time = splitDescription[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("The format for 'event' command requires a description "
                        + "following by </at> notation and a date time.");
            }
            assert time != null: "Timing is invalid to pass to AddCommand";
            return new AddCommand(new Event(details, time));
        } else if (keyword.equals("find")) {
            if (action.length == 1) {
                throw new DukeException("The description of a 'find' command is missing.");
            }
            String keyWord = fullCommand.split(" ", 2)[1];
            assert keyWord != null: "find command is missing a keyword";
            return new FindCommand(keyWord);
        } else {
            return new UnknownCommand();
        }
    }
}
