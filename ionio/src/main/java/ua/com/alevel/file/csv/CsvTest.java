package ua.com.alevel.file.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import ua.com.alevel.serial.User;
import ua.com.alevel.type.FileType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvTest {

    public void test() {
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setFirstName("qq");
        user.setLastName("ww");
        user.setFullName("qq ww");
        users.add(user);

        user = new User();
        user.setFirstName("qq1");
        user.setLastName("ww1");
        users.add(user);

        List<String[]> csvData = new ArrayList<>();
        String[] header = { "firstName", "lastName", "fullName" };
        csvData.add(header);

        for (User u : users) {
            String[] currentUser = new String[3];
            currentUser[0] = u.getFirstName();
            currentUser[1] = u.getLastName();
            currentUser[2] = u.getFullName();
            csvData.add(currentUser);
        }

        try(CSVWriter writer = new CSVWriter(new FileWriter(FileType.CSV_TYPE.getPath()))) {
            writer.writeAll(csvData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(CSVReader reader = new CSVReader(new FileReader(FileType.CSV_TYPE.getPath()))) {
            List<String[]> res = reader.readAll();
            for (String[] re : res) {
                System.out.println("re = " + re[0]);
                System.out.println("re = " + re[1]);
                System.out.println("re = " + re[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
