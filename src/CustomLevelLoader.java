import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CustomLevelLoader {

    public static CustomLevelData loadCustomLevel(String username) {
        Gson gson = new Gson();
        String fileName = "customLevel_" + username + ".json";
        CustomLevelData customLevelData = null;

        try {
            FileReader reader = new FileReader(fileName);
            Type type = new TypeToken<CustomLevelData>(){}.getType();
            customLevelData = gson.fromJson(reader, type);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customLevelData;
    }
}
