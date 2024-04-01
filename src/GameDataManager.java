//GameDataManager.java
import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GameDataManager {
    static final String FILE_PATH = "game_data.json";
    private static final String Q_FILE_PATH = "questionSets.json";

    public static void saveGameData(HashMap < String, GameData > gameDataMap, String filePath) {
        filePath = getCorrectJSONPath(filePath);
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write("[");
            boolean firstEntryAdded = false;
            for (var item: gameDataMap.entrySet()) {
                if (firstEntryAdded)
                    myWriter.write(",");
                GameData gameData = item.getValue();
                myWriter.write(
                        "{" +
                                "\"username\": \"" + gameData.getPlayerUsername() + "\",\n" +
                                "\"score\": " + gameData.getScore() + ",\n" +
                                "\"hintsUsed\": " + gameData.getHintsUsed() + ",\n" +
                                "\"levelCompleted\": " + gameData.getLevelCompleted() + ",\n" +
                                "\"levelsLeft\": " + gameData.getLevelsLeftString() + ",\n" +
                                "\"password\": \"" + gameData.getPassword() + "\"\n" +

                                "}");
                firstEntryAdded = true;

            }
            myWriter.write("]");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Username to Gamedata map
    public static HashMap < String, GameData > loadGameData(String filePath) {
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            String result = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result += data + "\n";
            }
            myReader.close();
            HashMap < String, GameData > map = new HashMap < > ();
            ArrayList < String > userNames = getUsernamesInFile(result);
            for (int i = 0; i < userNames.size(); i++) {
                GameData gameData = new GameData();
                if (!gameData.loadDataFromString(result, userNames.get(i))) {
                    System.out.println("Error");
                    return null;
                }
                map.put(userNames.get(i), gameData);
            }

            return map;
        } catch (FileNotFoundException e) {
            // System.out.println("An error occurred.");
            // e.printStackTrace();
        }
        return null;
    }
    public static void updatePlayerData(GameData updatedPlayerData) {
        // Load the current game data map from the JSON file
        HashMap<String, GameData> gameDataMap = loadGameData("game_data.json");
        
        // Update the player's data within the map
        gameDataMap.put(updatedPlayerData.getPlayerUsername(), updatedPlayerData);
        
        // Save the updated game data map back to the JSON file
        saveGameData(gameDataMap, "game_data.json");
    }
    public static ArrayList < String > getUsernamesInFile(String fileContents) {
        ArrayList < String > result = new ArrayList < > ();
        Pattern pattern = Pattern.compile("\"username\"\\s*:\\s*\"([^\"]+)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileContents);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }

    public static String getCorrectJSONPath(String filePath) {
        if (filePath.length() > 5 && filePath.substring(filePath.length() - 5, filePath.length()).equals(".json")) {} else
            filePath += ".json";
        return filePath;
    }

    public static String toSHA1(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(md.digest(str.getBytes()));
    }

    public static List<GameData> getTopScores(String filePath) {
        HashMap<String, GameData> gameDataMap = loadGameData(filePath); 
        
        if (gameDataMap == null) return new ArrayList<>();

       
        return gameDataMap.values().stream()
                .sorted((data1, data2) -> Integer.compare(data2.getScore(), data1.getScore()))
                .limit(5)
                .collect(Collectors.toList());
    }
    public static List<GameData> getInfo(String filePath) {
        HashMap<String, GameData> gameDataMap = loadGameData(filePath); 
        
        if (gameDataMap == null) return new ArrayList<>(); 

        return gameDataMap.values().stream()
                .sorted((data1, data2) -> Integer.compare(data2.getScore(), data1.getScore()))
                .collect(Collectors.toList());
    }

    
}
