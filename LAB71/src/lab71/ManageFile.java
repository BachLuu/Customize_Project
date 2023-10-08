/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab71;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luu Bach
 */
class ManageFile {

    ArrayList<Task> getDataFromFile(String datatxt, ArrayList<Task> taskList) throws ParseException {
        try {
            File myObj = new File(datatxt);
            Scanner myReader = new Scanner(myObj);
            String[] data;
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            //Loop still do if there is another line in the input of scanner
            while (myReader.hasNextLine()) {
                data = myReader.nextLine().trim().split(",");
                int id = Integer.parseInt(data[0].trim());
                String taskTypeID = data[1].trim();
                String requireName = data[2].trim();
                String date = data[3].trim();
                Date dateFinal = dateFormatter.parse(date);
                float planForm = Float.parseFloat(data[4].trim());
                float planTo = Float.parseFloat(data[5].trim());
                String assignee = data[6].trim();
                String reviewer = data[7].trim();
                taskList.add(new Task(id, taskTypeID, requireName, dateFinal, planForm, planTo, assignee, reviewer));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return taskList;
    }

    int getIdLastTask(String datatxt) throws FileNotFoundException {
        File myObj = new File(datatxt);
        Scanner myReader = new Scanner(myObj);
        String[] data = null;
        while (myReader.hasNextLine()) {
            data = myReader.nextLine().trim().split(",");
        }
        myReader.close();
        int id = Integer.parseInt(data[0].trim());
        return id;
    }

    void saveDataToFile(String datatxt, ArrayList<Task> taskList) throws IOException {
        FileWriter myWriter = new FileWriter(datatxt);
        for (int i = 0; i < taskList.size(); i++) {
            myWriter.write(taskList.get(i).toString());
            myWriter.write(System.lineSeparator());
        }
        myWriter.close();
    }

    ArrayList<String> getIdFromFile(String idtxt, ArrayList<String> idList) {
        try {
            File myObj = new File(idtxt);
            Scanner sc = new Scanner(myObj);
            String[] data;
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
            //Loop still do if there is another line in the input of scanner
            while (sc.hasNextLine()) {
                String id = sc.nextLine().trim();
                idList.add(id);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return idList;
    }

    void saveIdToFile(String idtxt, ArrayList<String> idList) throws IOException {
        FileWriter myWriter = new FileWriter(idtxt);
        for (int i = 0; i < idList.size(); i++) {
            myWriter.write(idList.get(i));
            myWriter.write(System.lineSeparator());
        }
        myWriter.close();
    }
}
