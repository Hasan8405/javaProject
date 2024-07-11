import java.time.LocalDateTime;
import java.util.Date;

public class HistoryGame {

private String NameHarif;
private String awards;
private String LoseWin;
private LocalDateTime time;
private String levelHarif;

    public String getLevelHarif() {
        return levelHarif;
    }


    public String getLoseWin() {
        return LoseWin;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public String getAwards() {
        return awards;
    }


    public String getNameHarif() {
        return NameHarif;
    }

    public HistoryGame(String nameHarif, LocalDateTime time, String award, String LoseWin, String levelHarif) {
        this.NameHarif = nameHarif;
        this.time = time;
        this.awards=award;
        this.LoseWin=LoseWin;
        this.levelHarif=levelHarif;
    }
}
