import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Storage {
    private static String filePath;

    public Storage (String filePath) {
        this.filePath = filePath;
    }

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
                    Deadline d = new Deadline(deadline[0].replace(" (", ""),deadline[1].replace(")", ""));
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

    public static void writeToFile() throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (int i = 0; i < TaskList.size(); i++) {
            Task t = TaskList.get(i);
            fw.write(formatOutput(String.valueOf(t)) + System.lineSeparator());
        }
        fw.close();
    }

    public static String formatOutput(String str) {
        return str.replace("][", " | ").replace("]", " | ").replace("[", " ").replace("\u2713", "1").replace("\u2718","0");
    }
}
