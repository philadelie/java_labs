package ntudp.psj.lab4;

import com.google.gson.Gson;
import ntudp.psj.lab4.model.University;

import java.io.*;
import java.nio.charset.StandardCharsets;

class JsonManager {
    private final Gson gson = new Gson();
    String filePath = System.getProperty("user.dir") + "/src/main/resources/uni.json";

    public void storeObjInJsonFile(Object obj) {
        String jsonFromObj = writeToJson(obj);
        writeToFile(jsonFromObj);
    }

    public University restoreObjFromJsonFile() {
        String json = readFromFile();
        return restoreFromJson(json);
    }

    public String writeToJson(Object obj) {
        return gson.toJson(obj);
    }

    public University restoreFromJson(String json) {
        return gson.fromJson(json, University.class);
    }

    public void writeToFile(String json) {
        try {
            PrintWriter writer = new PrintWriter(filePath, StandardCharsets.UTF_8);
            writer.printf(json);
            writer.close();
        } catch (IOException e) { System.out.println("ERROR: " + e.getMessage()); }
        System.out.println("\nJson was written to " + filePath);
    }

    public String readFromFile() {
        StringBuilder json = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            reader.close();
        } catch (IOException e) { System.out.println("ERROR: " + e.getMessage()); }
        return json.toString();
    }
}
