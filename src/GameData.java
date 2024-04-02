import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * The `GameData` class in Java represents game data for a player including username, score, hints
 * used, level completed, and levels left.
 *
 * @version 1.0
 * @author Het Patel
 * @author Nikunj Patel
 */

public class GameData {
    String password;
    private String playerUsername;
    private int score;
    private int hintsUsed;
    private int levelCompleted;
    private ArrayList < Integer > levelsLeft;

    // These are the constructors for the `GameData` class in Java:

   // The `public GameData() { levelsLeft = new ArrayList<>(); }` is a constructor in the `GameData`
   // class in Java. This constructor initializes the `levelsLeft` instance variable with a new empty
   // `ArrayList`. This means that when an object of the `GameData` class is created using this
   // constructor, the `levelsLeft` list will be empty by default.
    public GameData() {
        levelsLeft = new ArrayList < > ();
    }

    // This is a constructor in the `GameData` class in Java that takes in parameters for
    // `playerUsername`, `score`, `hintsUsed`, `levelCompleted`, and `levelsLeft`. When an object of
    // the `GameData` class is created using this constructor, it initializes the instance variables
    // `playerUsername`, `score`, `hintsUsed`, `levelCompleted`, and `levelsLeft` with the values
    // passed as arguments to the constructor.
    public GameData(String playerUsername, int score, int hintsUsed, int levelCompleted,
                    ArrayList < Integer > levelsLeft) {
        this.playerUsername = playerUsername;
        this.score = score;
        this.hintsUsed = hintsUsed;
        this.levelCompleted = levelCompleted;
        this.levelsLeft = levelsLeft;
    }
    /**
     * The function `parseIntArrayList` takes a string input containing comma-separated integers,
     * parses them into an ArrayList of integers, and returns the ArrayList.
     * 
     * @param input The `parseIntArrayList` method takes a string `input` as a parameter. This string
     * is expected to contain a list of integers separated by commas. The method then parses this input
     * string and creates an `ArrayList` of integers from the parsed values. If the input string is
     * empty, the method returns
     * @return An ArrayList of Integers is being returned.
     */
    public static ArrayList < Integer > parseIntArrayList(String input) {
        if (input == "")
            return new ArrayList < > ();

        String[] parts = input.split(",");

        ArrayList < Integer > arrayList = new ArrayList < > ();

        for (String part: parts) {
            arrayList.add(Integer.parseInt(part.trim()));
        }

        return arrayList;
    }

    /**
     * The function `loadDataFromString` parses a JSON-like string to extract and set player data such
     * as score, password, hints used, level completed, and levels left based on the provided username.
     * 
     * @param str The `loadDataFromString` method you provided seems to be parsing a JSON-like string
     * to extract and set various player data fields such as score, password, hints used, level
     * completed, and levels left. The method uses regular expressions to match specific patterns in
     * the input string.
     * @param username The `loadDataFromString` method is used to extract and load data from a given
     * string in JSON format for a specific username. The method parses the string using regular
     * expressions to find and extract relevant information such as score, password, hints used, level
     * completed, and levels left for the specified username.
     * @return The method `loadDataFromString` returns a boolean value - `true` if the data was
     * successfully loaded from the input string for the specified username, and `false` if the
     * username was not found in the input string.
     */
    public boolean loadDataFromString(String str, String username) {
        playerUsername = username;
        Pattern pattern = Pattern.compile("\"username\"\\s*:\\s*\"([^\"]+)\"", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        int matchIndex = 0;
        boolean matchFound = false;
        while (matcher.find()) {
            matchIndex += 1;
            if (matcher.group(1).equals(playerUsername)) {
                matchFound = true;
                break;
            }
        }
        if (!matchFound)
            return false;

        pattern = Pattern.compile("\"score\"\\s*:\\s*([^\"]+),", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);
        for (int i = 0; i < matchIndex; i++) {
            matchFound = matcher.find();
        }
        if (matchFound) {
            score = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("Score match not found");
        }
        // ------------------------
        pattern = Pattern.compile("\"password\"\\s*:\\s*\"([^\"]+)\"\\n", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);
        for (int i = 0; i < matchIndex; i++) {
            matchFound = matcher.find();
        }
        if (matchFound) {
            password = (matcher.group(1));
        } else {
            System.out.println("Password match not found");
        }

        pattern = Pattern.compile("\"hintsUsed\"\\s*:\\s*([^\"]+),", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);
        for (int i = 0; i < matchIndex; i++) {
            matchFound = matcher.find();
        }
        if (matchFound) {
            hintsUsed = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("Hints match not found");
        }

        pattern = Pattern.compile("\"levelCompleted\"\\s*:\\s*([^\"]+),", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);

        for (int i = 0; i < matchIndex; i++) {
            matchFound = matcher.find();
        }
        if (matchFound) {
            levelCompleted = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("Level completed match not found");
        }

        pattern = Pattern.compile("\"levelsLeft\": \\[(.*)\\],", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(str);
        for (int i = 0; i < matchIndex; i++) {
            matchFound = matcher.find();
        }
        if (matchFound) {
            levelsLeft = parseIntArrayList(matcher.group(1));
        } else {
            System.out.println("Levels left match not found");
        }
        return true;
    }

    public String getLevelsLeftString() {

        String result = "[";
        for (int i = 0; i < levelsLeft.size(); i++) {
            if (i != 0)
                result += ",";
            result += levelsLeft.get(i);
        }

        result += "]";
        return result;
    }

    /**
     * This Java function returns the player's username.
     * 
     * @return The method `getPlayerUsername()` is returning the value of the variable
     * `playerUsername`, which is likely a String representing the username of a player.
     */
    public String getPlayerUsername() {
        return playerUsername;
    }

    /**
     * The function `setPlayerUsername` sets the username of a player in a Java class.
     * 
     * @param playerUsername The `setPlayerUsername` method is used to set the username of a player in
     * a game. The `playerUsername` parameter is the username that will be assigned to the player.
     */
    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }

    /**
     * This Java function returns the value of the score.
     * 
     * @return The `score` variable is being returned.
     */
    public int getScore() {
        return score;
    }

   /**
    * This Java function sets the score value for an object.
    * 
    * @param score The `setScore` method is used to set the score of an object to the value passed as a
    * parameter. In this case, the parameter `score` is an integer value representing the score that
    * you want to set for the object.
    */
    public void setScore(int score) {
        this.score = score;
    }

   /**
    * This Java function returns the number of hints used.
    * 
    * @return The number of hints used.
    */
    public int getHintsUsed() {
        return hintsUsed;
    }

    /**
     * The function sets the number of hints used in a Java program.
     * 
     * @param hintsUsed The parameter `hintsUsed` represents the number of hints that have been used in
     * the program or game. This method `setHintsUsed` is used to set the value of hints used to the
     * provided value.
     */
    public void setHintsUsed(int hintsUsed) {
        this.hintsUsed = hintsUsed;
    }

    /**
     * The `getLevelCompleted` function in Java returns the level completed.
     * 
     * @return The method `getLevelCompleted` is returning the value of the variable `levelCompleted`.
     */
    public int getLevelCompleted() {
        return levelCompleted;
    }

    /**
     * The function setLevelCompleted in Java sets the level completed for a game.
     * 
     * @param levelCompleted The parameter `levelCompleted` is an integer representing the level that
     * has been completed in a game or any other context where levels are involved.
     */
    public void setLevelCompleted(int levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

    /**
     * The function "getLevelsLeft" returns an ArrayList of Integers representing the levels that are
     * left.
     * 
     * @return An ArrayList of Integers named levelsLeft is being returned.
     */
    public ArrayList < Integer > getLevelsLeft() {
        return levelsLeft;
    }

    /**
     * This function sets the levelsLeft ArrayList in the class to the provided ArrayList parameter.
     * 
     * @param levelsLeft The parameter `levelsLeft` is an ArrayList of Integers that contains the
     * levels that are left to be completed or processed.
     */
    public void setLevelsLeft(ArrayList < Integer > levelsLeft) {
        this.levelsLeft = levelsLeft;
    }

    /**
     * The getPassword function in Java returns the password value.
     * 
     * @return The getPassword() method is returning the password as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * The function `setPassword` sets the password for an object.
     * 
     * @param password The `setPassword` method is a setter method used to set the value of the
     * `password` attribute in a class. The method takes a `String` parameter named `password`, which
     * represents the new password value that will be assigned to the `password` attribute.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}