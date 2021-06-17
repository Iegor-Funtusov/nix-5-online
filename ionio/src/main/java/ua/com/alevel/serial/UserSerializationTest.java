package ua.com.alevel.serial;

import ua.com.alevel.type.FileType;

import java.io.*;

public class UserSerializationTest {

    public void saveUserState() {
        User user = new User();
        user.setFirstName("qq");
        user.setLastName("ww");
        user.setFullName("qq ww");

        try(
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FileType.OUT_TYPE.getPath()));
                ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FileType.OUT_TYPE.getPath()))
        ) {
            outputStream.writeObject(user);
            user = (User) inputStream.readObject();
            System.out.println("user = " + user);
            System.out.println("user = " + user.getFullName());
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
