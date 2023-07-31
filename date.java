package MasterData;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    private Date today;

    public date() {
        this.today = new Date();
    }

    public String getMySQLDateFormat() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(this.today);
    }
}


