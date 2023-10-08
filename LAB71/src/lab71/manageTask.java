/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Luu Bach
 */
class manageTask {

    ManageFile file = new ManageFile();

    void addTask(ArrayList<Task> taskList, ArrayList<String> idList) throws FileNotFoundException, IOException {
        getData GetData = new getData();
        System.out.println("-------Add Task-------");
        int id;
        if (taskList.size() == 0) {
            id = 1;
        } else {
            id = Integer.parseInt(idList.get(idList.size() - 1)) + 1;
        }
        String Name = GetData.getRequirementName();
        String TaskTypeID = GetData.getTaskType();
        Date Date = GetData.getDate();
        float From = GetData.getTimeFrom();
        float To = GetData.getTimeTo();
        float Time = To - From;
        //compare time with 0
        if (Time <= 0) {
            System.out.println("Invalid Time!!! ");
            return;
        }
        String Assignee = GetData.getAssignee();
        String Reviewer = GetData.getReviewer();
        Task Newtask = new Task(id, TaskTypeID, Name, Date, From, To, Assignee, Reviewer);
        if (checkTaskDupicate(Newtask, taskList)) {
            taskList.add(Newtask);
            String finalID = Integer.toString(id);
            idList.add(finalID);
            file.saveIdToFile("id.txt", idList);
            file.saveDataToFile("data.txt", taskList);
        }
    }

    void deleteTask(ArrayList<Task> taskList, ArrayList<String> idList) throws IOException {
        getData GetData = new getData();
        if (taskList.isEmpty()) {
            System.out.println("There is currently none task!!!");
            return;
        }
        System.out.println("--------Del Task---------");
        int id = GetData.getID();
        int CheckIDExist = 0;
        for (int i = 0; i < taskList.size(); i++) {
            if (id == taskList.get(i).getId()) {
                taskList.remove(i);
                System.out.println("Task Deleted!!!");
                CheckIDExist++;
            }
        }
        //compare checkIDExist with 0
        if (CheckIDExist == 0) {
            System.out.println("That ID doesn't exist!!! ");
            return;
        }
        file.saveDataToFile("data.txt", taskList);
    }

    ArrayList<Task> showTask(ArrayList<Task> TaskList) {
        if (TaskList.isEmpty()) {
            System.out.println("There are currently no tasks!");
            return null;
        }
        System.out.println("------------------------------------- Task ---------------------------------------------");
        System.out.println("ID   Name              Task Type      Date         Time          Assignee     Reviewer");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < TaskList.size(); i++) {
            Task task = TaskList.get(i);
            String dateFormatted = dateFormatter.format(task.getDate());
            System.out.printf("%-4d %-18s %-13s %-13s %-13s %-14s %s%n",
                    task.getId(),
                    task.getName(),
                    task.getTaskTypeID(),
                    dateFormatted,
                    task.getTime(),
                    task.getAssignee(),
                    task.getReviewer());
        }
        return TaskList;
    }

    private boolean checkTaskDupicate(Task task, ArrayList<Task> TaskList) {
        for (Task i : TaskList) {
            if (i.getAssignee().equals(task.getAssignee()) && i.getDate().equals(task.getDate())) {
                if (i.from < task.to && i.from >= task.from) {
                    System.out.println("Invalid Time !!!");
                    return false;
                } else if (i.to <= task.to && i.to > task.from) {
                    System.out.println("Invalid Time !!!");
                    return false;
                } else if (i.to >= task.to && i.from <= task.from) {
                    System.out.println("Invalid Time!!!");
                    return false;
                }
            }
        }
        return true;
    }
}
