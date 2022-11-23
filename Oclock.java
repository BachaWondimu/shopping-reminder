package OOP_Project;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Oclock {



    Oclock() {
    }

    public void setTime(JLabel dayLabel, JLabel dateLabel, JLabel timeLabel) {
        SimpleDateFormat  timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat  dayFormat = new SimpleDateFormat("EEEE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        while (true) {
            timeLabel.setText(timeFormat.format(Calendar.getInstance().getTime()));
            dayLabel.setText(dayFormat.format(Calendar.getInstance().getTime()));
            dateLabel.setText(dateFormat.format(Calendar.getInstance().getTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
