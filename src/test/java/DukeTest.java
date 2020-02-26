import duke.exception.DukeException;
import duke.util.Ui;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DukeTest {
    @Test
    public void dummyTest() {
        assertEquals(2, 2);
    }

    public void testUiWelcome() throws DukeException {
        Ui ui = new Ui();

        String expected =
                "    ____________________________________________________________\n" +
                "    Hello I'm Dat\n" +
                "    What can I do for you?\n" +
                "    ____________________________________________________________";
        assertEquals(expected, ui.showWelcome());
    }

    public void testUishowError() {
        Ui ui = new Ui();
        String errorMessage = "TEST_ERROR";
        String expected =
                ui.showLine() +
                ("☹ OOPS!!! I'm sorry, but there is an error :-(") +
                (errorMessage) +
                ui.showLine();
        assertEquals(expected, ui.showError(errorMessage));
    }
    public static void main(String[] args) throws DukeException {
        new DukeTest().testUiWelcome();
        new DukeTest().testUishowError();
    }
}
