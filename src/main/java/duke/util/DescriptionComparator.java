package duke.util;

import duke.task.Task;
import java.util.Comparator;

public class DescriptionComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }
}
