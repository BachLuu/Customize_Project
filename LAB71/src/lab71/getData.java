/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luu Bach
 */
class getData {

    String getRequirementName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Requirement Name: ");
        String Name = sc.nextLine().trim();
        //check if Requirement Name: is empty
        if (Name.isEmpty()) {
            System.out.println("Requirement Name can't be empty!!!");
            return getRequirementName();
        }
        //check if Name cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!Name.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Invalid Requirement Name type!!!");
            return getRequirementName();
        }
        return Name;
    }

    String getTaskType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Task Type: ");
        String TaskType = sc.nextLine().trim();
        //check if TaskType is empty
        if (TaskType.isEmpty()) {
            System.out.println("Task Type can't be empty!!!");
            return getTaskType();
        }
        //check if Name cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!TaskType.matches("^[1-4]$")) {
            System.out.println("Invalid Task Type, must in[1-4]!!!");
            return getTaskType();
        }
        //check if TaskType must match  "1" 
        if (TaskType.matches("^[1]$")) {
            TaskType = "Code";
            return TaskType;
        }
        //check if TaskType must match  "2" 
        if (TaskType.matches("^[2]$")) {
            TaskType = "Test";
            return TaskType;
        }
        //check if TaskType must match  "3" 
        if (TaskType.matches("^[3]$")) {
            TaskType = "Design";
            return TaskType;
        }
        //check if TaskType must match  "4" 
        if (TaskType.matches("^[4]$")) {
            TaskType = "Review";
            return TaskType;
        }
        return TaskType;
    }

    Date getDate() {
        Date currentDate = new Date();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date (dd-mm-yyyy): ");
        String Date = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(Date);
            if (date.equals(currentDate)) {
                return date;
            } else if (date.before(currentDate)) {
                System.out.println("Date can't be from the past!!!");
                return getDate();
            }
            return date;
        } catch (ParseException e) {
            System.out.println("Invalid date format or date does not exist.");
            return getDate();
        }
    }

    float getTimeFrom() {
        Scanner sc = new Scanner(System.in);
        float TimeFrom;
        try {
            //while loop with time smaller than 0
            do {
                System.out.print("From: ");
                TimeFrom = Float.parseFloat(sc.nextLine());
                if (TimeFrom < 8.0 || TimeFrom > 17.5) {
                    System.out.println("Time must be between [8.0,17.5] !!!");
                    return getTimeFrom();
                } else if (TimeFrom % 0.5 != 0) {
                    System.out.println("Invalid Time !!!");
                    return getTimeFrom();
                }
            } while (TimeFrom < 0);

        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Time!!!");
            return getTimeFrom();
        }
        return TimeFrom;
    }

    float getTimeTo() {
        Scanner sc = new Scanner(System.in);
        float TimeTo;
        try {
            //while loop with time smaller than 0
            do {
                System.out.print("To: ");
                TimeTo = Float.parseFloat(sc.nextLine());
                if (TimeTo < 8.0 || TimeTo > 17.5) {
                    System.out.println("Time must be between [8.0,17.5] !!!");
                    return getTimeTo();
                } else if (TimeTo % 0.5 != 0) {
                    System.out.println("Invalid Time !!!");
                    return getTimeTo();
                }
            } while (TimeTo < 0);

        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Time!!!");
            return getTimeTo();
        }
        return TimeTo;

    }

    String getAssignee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Assignee: ");
        String Name = sc.nextLine().trim();
        //check if Assingee is empty
        if (Name.isEmpty()) {
            System.out.println("Reviewer can't be empty!!!");
            return getAssignee();
        }
        //check if Assingee cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!Name.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Invalid Assingee type!!!");
            return getAssignee();
        }
        return Name;
    }

    String getReviewer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Reviewer: ");
        String Name = sc.nextLine().trim();
        //check if Reviewer is empty
        if (Name.isEmpty()) {
            System.out.println("Reviewer can't be empty!!!");
            return getReviewer();
        }
        //check if Reviewer cointains (one or many)character from a to z or A to Z or space frm the start to the end of the string
        if (!Name.matches("^[a-zA-Z\\s]+$")) {
            System.out.println("Invalid Reviewer type!!!");
            return getReviewer();
        }
        return Name;
    }

    int getID() {
        Scanner sc = new Scanner(System.in);
        int choice;
        try {
            //while loop with ID smaller than 0
            do {
                System.out.print("ID:");
                choice = Integer.parseInt(sc.nextLine());

            } while (choice < 0);
        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid ID!!!");
            return getID();
        }
        return choice;
    }

}
