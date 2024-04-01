import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomLevelLoader {
    public static List<CustomLevelData> loadCustomLevel(String username) {
        // Example path, adjust as necessary
        String path = username + "_customLevels.json";
        try (Reader reader = new FileReader(path)) {
            Type collectionType = new TypeToken<List<CustomLevelData>>(){}.getType();
            List<CustomLevelData> customLevels = new Gson().fromJson(reader, collectionType);
            return customLevels;
        } catch (IOException e) {
            e.printStackTrace();
            return null; // or Collections.emptyList() as appropriate
        }
    }
}
