/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luu Bach
 */
public class LAB71 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
        ManageFile file = new ManageFile();
        ArrayList<Task> taskList = new ArrayList();
        taskList = file.getDataFromFile("data.txt", taskList);
        manageTask manage = new manageTask();
        ArrayList<String> idList = new ArrayList();
        idList = file.getIdFromFile("id.txt", idList);
        while (true) {
            //step 1:Display a menu and ask users to select an option.
            displayMenu();
            int choice = selectAnOption();
            //step 2: Perform function based on the selected option.
            switch (choice) {
                case 1:
                    manage.addTask(taskList, idList);
                    break;
                case 2:
                    manage.deleteTask(taskList, idList);
                    break;
                case 3:
                    manage.showTask(taskList);
                    break;
                case 4:
                    System.out.println("Exiting....!!!");
                    System.exit(0);

            }
        }
    }

    private static void displayMenu() {
        System.out.println("======== Task program =======");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display task");
        System.out.println("4. Exit");
    }

    private static int selectAnOption() {
        Scanner sc = new Scanner(System.in);
        int choice;
        try {
            //while loop with choice smaller than 0
            do {
                System.out.print("Enter your choice:");
                choice = Integer.parseInt(sc.nextLine());
                if (choice <= 0 || choice > 4) {
                    System.out.println("Must be between [1,4] !!!");
                    return selectAnOption();
                }

            } while (choice < 0);
        } catch (java.lang.NumberFormatException a) {
            System.out.println("Invalid Option!!!");
            return selectAnOption();
        }
        return choice;

    }
}
