package duke.util;

import duke.exception.DukeException;
import duke.task.*;
import duke.command.*;

import java.util.ArrayList;

public class Parser {
    protected TaskList tasks;

    public Parser(TaskList tasks) {
        this.tasks = tasks;
    }

    public Parser(ArrayList<Task> tasks) {
        this.tasks = new TaskList(tasks);
    }

    public Command parse(String fullCommand) throws DukeException {

        if (fullCommand.toLowerCase().trim().equals("bye")) {
            System.out.println("Goodbye! See you soon!");
            return new ExitCommand();
        }

        if (fullCommand.toLowerCase().trim().equals("list")) {
            return new ShowCommand();
        }
        String[] action = fullCommand.split(" ");

        if (action[0].toLowerCase().trim().equals("done")) {
            int index = 0;
            try {
                index = Integer.parseInt(action[1]);
            } catch (NumberFormatException e) {
                throw new DukeException("☹ OOPS! The argument of a 'done' command must be a number.");
            }
            if (index <= 0 || index >= this.tasks.checkSize()) {
                throw new DukeException("☹ OOPS! The index of a 'done' command is out of bounce.");
            }
            return new DoneCommand(index);
        }

        if (action[0].toLowerCase().trim().equals("delete")) {
            int index = 0;
            try {
                index = Integer.parseInt(action[1]);
            } catch (NumberFormatException e) {
                throw new DukeException("☹ OOPS! The argument of a 'delete' command must be a number.");
            }
            if (index <= 0 || index > this.tasks.checkSize()) {
                throw new DukeException("☹ OOPS! The index of a 'delete' command is out of bounce.");
            }
            return new DeleteCommand(index);
        }

        if (action[0].toLowerCase().trim().equals("todo")) {
            if (action.length == 1) {
                throw new DukeException("☹ OOPS! The description of a 'todo' command is missing.");
            }
            return new AddCommand(new Todo(fullCommand.split(" ", 2)[1]));
        }

        if (action[0].toLowerCase().trim().equals("deadline")) {
            String time;
            String details;
            if (action.length == 1) {
                throw new DukeException("☹ OOPS! The description of a 'deadline' command is missing.");
            }
            String description = fullCommand.split(" ", 2)[1];
            String[] splitDescription = description.split(" /by ");
            try {
                details = splitDescription[0];
                time = splitDescription[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The format for 'deadline' command requires a description " +
                        "following by </by> notation and a due date.");
            }
            return new AddCommand(new Deadline(details, time));
        }

        if (action[0].toLowerCase().trim().equals("event")) {
            String time;
            String details;
            if (action.length == 1) {
                throw new DukeException("☹ OOPS! The description of a 'event' command is missing.");
            }
            String description = fullCommand.split(" ", 2)[1];
            String[] splitDescription = description.split(" /at ");
            try {
                details = splitDescription[0];
                time = splitDescription[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException("☹ OOPS!!! The format for 'event' command requires a description " +
                        "following by </at> notation and a date time.");
            }
            return new AddCommand(new Event(details, time));
        }

        return new UnknownCommand();
    }
}
