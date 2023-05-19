package screen;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Score implements Serializable {
    private String date;
    private int score;
    private int character;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final long serialVersionUID = 6529685098267757690L;

    public Score(int score, int character) {
        this(dtf.format(LocalDateTime.now()), score, character);

    }

    public Score(String date, int score, int character) {
        this.date = date;
        this.score = score;
        this.character = character;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }

    public static DateTimeFormatter getDtf() {
        return dtf;
    }

    public static void setDtf(DateTimeFormatter dtf) {
        Score.dtf = dtf;
    }
}
