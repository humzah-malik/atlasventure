import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomLevelSaver {

    public static void saveCustomLevels(String username, ArrayList<CustomLevelData> customLevels) {
        Gson gson = new Gson();
        String fileName = "customLevels_" + username + ".json"; // Customize the file name as needed

        try {
            // Serialize custom levels to JSON and save to a file
            FileWriter writer = new FileWriter(fileName);
            gson.toJson(customLevels, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<CustomLevelData> loadCustomLevels(String username) {
        Gson gson = new Gson();
        String fileName = "customLevels_" + username + ".json"; // Customize the file name as needed
        ArrayList<CustomLevelData> customLevels = new ArrayList<>();

        try {
            // Deserialize JSON from the file back into ArrayList<CustomLevelData>
            FileReader reader = new FileReader(fileName);
            Type customLevelListType = new TypeToken<ArrayList<CustomLevelData>>(){}.getType();
            customLevels = gson.fromJson(reader, customLevelListType);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customLevels != null ? customLevels : new ArrayList<>();
    }
}
