package DBManager;

import model.Tasks;
import servlet.UpdateServlet;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Tasks> tasksArrayList = new ArrayList<>();

    public static Long id = 2L;

    static {
        tasksArrayList.add(new Tasks(1L, "Создать веб приложение на Java EE", "Создать веб приложение на Java EE для себя", "2023-10-23", true));
    }

    public static ArrayList<Tasks> getAllTasks() {
        return tasksArrayList;
    }

    public static void addTask(Tasks task) {
        task.setId(id);
        task.setStatus(false);
        tasksArrayList.add(task);
        id++;
    }

    public static Tasks getTask(Long id) {
        for (Tasks task : tasksArrayList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static void deleteTask(Long id) {
        for (Tasks task : tasksArrayList) {
            if (task.getId() == id) {
                tasksArrayList.remove(task);
                break;
            }
        }
    }

    public static Tasks updateTask(Tasks tasks) {
        for (int i = 0; i < tasksArrayList.size(); i++) {
            if (tasksArrayList.get(i).getId() == tasks.getId()) {
                tasksArrayList.set(i, tasks);
                return tasks;
            }
        }
        return null;
    }
}
