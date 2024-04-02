/**
 * The `GameDataManager` class in Java manages game data by saving and loading player information,
 * updating player data, retrieving usernames, ensuring correct JSON file path, converting strings to
 * SHA1, and getting top scores and game information.
 * 
 * @author Het Patel
 */

//import com.google.gson.Gson;
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

/**
 * This class is responsible for managing the game data, including saving and loading player game data,
 * updating player data, retrieving usernames from file contents, ensuring correct JSON file path,
 * converting a string to SHA1, and getting top scores and information from the game data.
 * @author Het Patel
 */
public class GameDataManager {
    static final String FILE_PATH = "game_data.json";
    private static final String Q_FILE_PATH = "questionSets.json";

    
    
    /**
     * The `saveGameData` function writes game data from a HashMap to a JSON file in a specific format.
     * 
     * @param gameDataMap A HashMap containing String keys and GameData values. The String key
     * represents the username of the player, and the GameData value represents the game data
     * associated with that player.
     * @param filePath The `filePath` parameter in the `saveGameData` method is the path where the game
     * data will be saved as a JSON file. It should be a valid file path on the system where the game
     * data will be written to.
     */
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

    
    
    /**
     * The function `loadGameData` reads game data from a file, processes it, and returns a HashMap
     * containing the data.
     * 
     * @param filePath The `filePath` parameter in the `loadGameData` method is a string that
     * represents the path to the file from which you want to load game data. This method reads the
     * contents of the file specified by the `filePath` and processes the data to create a HashMap
     * containing game data associated with different usernames
     * @return A HashMap<String, GameData> is being returned from the loadGameData method.
     */
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


    /**
     * The function `updatePlayerData` updates a player's data within a game data map loaded from a
     * JSON file and saves the updated map back to the file.
     * 
     * @param updatedPlayerData The `updatedPlayerData` parameter is an object of type `GameData` that
     * contains the updated information for a player in the game. This object likely includes details
     * such as the player's username, score, level, items, or any other relevant data that needs to be
     * updated in the game data map
     */
    public static void updatePlayerData(GameData updatedPlayerData) {
        // Load the current game data map from the JSON file
        HashMap<String, GameData> gameDataMap = loadGameData("game_data.json");
        
        // Update the player's data within the map
        gameDataMap.put(updatedPlayerData.getPlayerUsername(), updatedPlayerData);
        
        // Save the updated game data map back to the JSON file
        saveGameData(gameDataMap, "game_data.json");
    }


    /**
     * The function `getUsernamesInFile` extracts usernames from a given file contents using a regular
     * expression pattern.
     * 
     * @param fileContents The `getUsernamesInFile` method you provided is designed to extract
     * usernames from a given file contents string. The method uses a regular expression pattern to
     * find and extract usernames that are formatted as `"username": "value"` in the file contents.
     * @return This method returns an ArrayList of Strings containing usernames extracted from the
     * provided file contents.
     */
    public static ArrayList < String > getUsernamesInFile(String fileContents) {
        ArrayList < String > result = new ArrayList < > ();
        Pattern pattern = Pattern.compile("\"username\"\\s*:\\s*\"([^\"]+)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fileContents);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
    }


    /**
     * The function `getCorrectJSONPath` ensures that the given file path ends with ".json".
     * 
     * @param filePath The `getCorrectJSONPath` method takes a `filePath` as input and checks if the
     * file path ends with ".json". If it doesn't, it appends ".json" to the file path before returning
     * it.
     * @return The method `getCorrectJSONPath` returns the `filePath` with ".json" appended to it if it
     * does not already end with ".json".
     */
    public static String getCorrectJSONPath(String filePath) {
        if (filePath.length() > 5 && filePath.substring(filePath.length() - 5, filePath.length()).equals(".json")) {} else
            filePath += ".json";
        return filePath;
    }

    /**
     * The function `toSHA1` takes a string input and returns its SHA-1 hash as a string.
     * 
     * @param str The `str` parameter in the `toSHA1` method is the input string that you want to
     * convert to its SHA-1 hash representation.
     * @return The method is returning a new String object created from the byte array generated by the
     * SHA-1 hash function applied to the input string.
     */
    public static String toSHA1(String str) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(md.digest(str.getBytes()));
    }

    /**
     * The function `getTopScores` reads game data from a file, sorts it by score in descending order,
     * and returns the top 5 scores as a list.
     * 
     * @param filePath The `filePath` parameter in the `getTopScores` method is a string that
     * represents the file path to the file containing the game data. This method reads the game data
     * from the specified file and returns a list of the top 5 scores in descending order.
     * @return The method `getTopScores` returns a list of `GameData` objects representing the top 5
     * scores loaded from the file specified by the `filePath`. If the `gameDataMap` is null, it
     * returns an empty list.
     */
    public static List<GameData> getTopScores(String filePath) {
        HashMap<String, GameData> gameDataMap = loadGameData(filePath); 
        
        if (gameDataMap == null) return new ArrayList<>();

       
        return gameDataMap.values().stream()
                .sorted((data1, data2) -> Integer.compare(data2.getScore(), data1.getScore()))
                .limit(5)
                .collect(Collectors.toList());
    }

    
    /**
     * The function `getInfo` loads game data from a file, sorts it by score in descending order, and
     * returns a list of `GameData` objects.
     * 
     * @param filePath The `filePath` parameter in the `getInfo` method is a string that represents the
     * path to a file containing game data. This method reads the game data from the specified file,
     * loads it into a `HashMap` where the key is a string and the value is a `GameData` object.
     * @return The method `getInfo` returns a list of `GameData` objects sorted by their score in
     * descending order. If the `gameDataMap` is null, it returns an empty list.
     */
    public static List<GameData> getInfo(String filePath) {
        HashMap<String, GameData> gameDataMap = loadGameData(filePath); 
        
        if (gameDataMap == null) return new ArrayList<>(); 

        return gameDataMap.values().stream()
                .sorted((data1, data2) -> Integer.compare(data2.getScore(), data1.getScore()))
                .collect(Collectors.toList());
    }

    
}
