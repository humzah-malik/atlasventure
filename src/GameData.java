// GameData.java

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GameData {
    String password;
    private String playerUsername;
    private int score;
    private int hintsUsed;
    private int levelCompleted;
    private ArrayList < Integer > levelsLeft;

    public GameData() {
        levelsLeft = new ArrayList < > ();
    }

    public GameData(String playerUsername, int score, int hintsUsed, int levelCompleted,
                    ArrayList < Integer > levelsLeft) {
        this.playerUsername = playerUsername;
        this.score = score;
        this.hintsUsed = hintsUsed;
        this.levelCompleted = levelCompleted;
        this.levelsLeft = levelsLeft;
    }

    
    /** 
     * @param input
     * @return ArrayList<Integer>
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

    public String getPlayerUsername() {
        return playerUsername;
    }

    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHintsUsed() {
        return hintsUsed;
    }

    public void setHintsUsed(int hintsUsed) {
        this.hintsUsed = hintsUsed;
    }

    public int getLevelCompleted() {
        return levelCompleted;
    }

    public void setLevelCompleted(int levelCompleted) {
        this.levelCompleted = levelCompleted;
    }

    public ArrayList < Integer > getLevelsLeft() {
        return levelsLeft;
    }

    public void setLevelsLeft(ArrayList < Integer > levelsLeft) {
        this.levelsLeft = levelsLeft;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}