/**
 * Storage deals with loading tasks from the file and saving tasks in the file
 */
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Storage {
    private static String filePath;

    public Storage (String filePath) {
        this.filePath = filePath;
    }

    /**
     * load the history data into the task list
     * @return tasks. Its type is ArrayList<Task> storing the history data.
     * @throws FileNotFoundException the file given the filepath does not exist.
     */
    public static ArrayList<Task> load() throws FileNotFoundException {
        ArrayList<Task> tasks = new ArrayList<>();
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] words = s.nextLine().split(" \\| ");
            switch (words[0]) {
                case " T":
                    Todo t = new Todo(words[2]);
                    if (words[1].equals("1")) {
                        t.markTheStatusAsDone();
                    }
                    tasks.add(tasks.size(), t);
                    break;
                case " D":
                    String[] deadline = words[2].split("by:");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
                    Deadline d = new Deadline(deadline[0].replace(" (", ""), LocalDate.parse(deadline[1].replace(")", ""), formatter));
                    if (words[1].equals("1")) {
                        d.markTheStatusAsDone();
                    }
                    tasks.add(tasks.size(), d);
                    break;
                case " E":
                    String[] event = words[2].split("at:");
                    Event e = new Event(event[0].replace(" (", ""),event[1].replace(")", ""));
                    if (words[1].equals("1")) {
                        e.markTheStatusAsDone();
                    }
                    tasks.add(tasks.size(), e);
                    break;
            }
        }
        return tasks;
    }

    /**
     * Write the task list to the file given the filepath.
     * @throws IOException error occurs when storing the data into the local file.
     */
    public static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < TaskList.size(); i++) {
            Task t = TaskList.get(i);
            fw.write(formatOutput(String.valueOf(t)) + System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Process the string to follow the format like T | 1 | get up.
     * T indicates it is a to do task. D indicates it is a deadline task. E indicates it is an event task.
     * 1 indicates done. 0 indicates undone.
     * get up in the example is the descripiton of the task.
     * @param str String to be formatted.
     * @return A string after being formatted.
     */
    public static String formatOutput(String str) {
        return str.replace("][", " | ").replace("]", " | ").replace("[", " ").replace("\u2713", "1").replace("\u2718","0");
    }
}
