package ua.com.alevel.file.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import ua.com.alevel.serial.User;
import ua.com.alevel.type.FileType;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {

    public void saveUsersToJson() {
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

        Gson gson = new Gson();
        String usersOut = gson.toJson(users);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(usersOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            usersOut = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(usersOut, new TypeReference<>() { });
            System.out.println("users = " + users);

            JsonArray jsonElements = new Gson().fromJson(usersOut, JsonArray.class);
            for (JsonElement jsonElement : jsonElements) {
                if (jsonElement.isJsonObject()) {
                    System.out.println("jsonElement = " + jsonElement);
                    JsonObject jsonObject = new Gson().fromJson(jsonElement, JsonObject.class);
                    String firstName = jsonObject.get("firstName").getAsString();
                    if (firstName != null && !firstName.isEmpty()) {
                        System.out.println("firstName = " + firstName);
                    }
                    String lastName = jsonObject.get("lastName").getAsString();
                    System.out.println("lastName = " + lastName);
                }
                if (jsonElement.isJsonArray()) {
                    JsonArray jsonElements2 = new Gson().fromJson(jsonElement, JsonArray.class);
                    for (JsonElement element : jsonElements2) {

                    }
                }
            }

//            User user1 = objectMapper.readValue("", User.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
