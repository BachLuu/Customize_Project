/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luu Bach
 */
public class Task {

    int id;
    String taskTypeID;
    String name;
    Date date;
    float time;
    float from;
    float to;
    String assignee;
    String reviewer;

    public Task(int id, String taskTypeID, String name, Date date, float from, float to, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.name = name;
        this.date = date;
        this.from = from;
        this.to = to;
        this.time = to - from;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public String getTaskTypeID() {
        if (taskTypeID.equals("1")) {
            return "Code";
        } else if (taskTypeID.equals("2")) {
            return "Test";
        } else if (taskTypeID.equals("3")) {
            return "Design";
        } else if (taskTypeID.equals("4")) {
            return "Review";
        }
        return taskTypeID;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public float getTime() {
        return time;
    }

    public float getFrom() {
        return from;
    }

    public float getTo() {
        return to;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskTypeID(String taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void setFrom(float from) {
        this.from = from;
    }

    public void setTo(float to) {
        this.to = to;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void displayTask() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateFormatted = dateFormatter.format(getDate());
        System.out.printf("%-4d %-18s %-13s %-13s %-13s %-14s %s%n",
                getId(),
                getName(),
                getTaskTypeID(),
                dateFormatted,
                getTime(),
                getAssignee(),
                getReviewer());
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateFormatted = dateFormatter.format(getDate());
        return id + "," + taskTypeID + "," + name + "," + dateFormatted + "," + from + "," + to + "," + assignee + "," + reviewer;
    }

}
