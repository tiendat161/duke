package duke.util;

import duke.task.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class DateTimeComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        if (o1.getTime().equals("") && o2.getTime().equals("")) {
            return o1.getDescription().compareTo(o2.getDescription());
        } else if (o1.getTime().equals("")) {
            return -1;
        } else if (o2.getTime().equals("")) {
            return -1;
        }
        try {
            Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(o1.getTime());
            Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(o2.getTime());
            return date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
