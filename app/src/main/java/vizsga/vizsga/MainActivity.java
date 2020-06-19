package vizsga.vizsga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import static android.view.Gravity.CENTER_HORIZONTAL;

public class MainActivity extends AppCompatActivity {
    Button jo;
    Button semleges;
    Button rossz;
    TextView TW1;
    TextView TW2;
    TextView TW3;
    String msg;
    Thread timeThread;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jo = findViewById(R.id.Button1);
        semleges = findViewById(R.id.Button2);
        rossz = findViewById(R.id.Button3);
        TW1 = findViewById(R.id.TextView1);
        TW2 = findViewById(R.id.TextView2);
        TW3 = findViewById(R.id.TextView3);
        spinner = findViewById(R.id.spinner);

        timeThread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!timeThread.isInterrupted()) {
                        sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TW3.setText(DateFormat.getDateTimeInstance().format(new Date()));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Log.d("date", "nem tudom megjeleníteni" );
                }
            }
        };
        timeThread.start();

    }

    public void kiirJo(android.view.View v) {
        msg = "Kedv: jó, Dátum: " + (DateFormat.getDateTimeInstance().format(new Date()));
        Log.d("Kedv", msg);
        TW2.setText("Kedv: jó");
        Toast toast1 = Toast.makeText(this, "Kedv: jó", Toast.LENGTH_LONG);
        toast1.setGravity(CENTER_HORIZONTAL, 0, 0);
        toast1.show();
    }

    public void kiirSemleges(android.view.View v) {
        msg = "Kedv: semleges, Dátum: " + (DateFormat.getDateTimeInstance().format(new Date()));
        Log.d("Kedv", msg);
        TW2.setText("Kedv: semleges");
        Toast toast1 = Toast.makeText(this, "Kedv: semleges", Toast.LENGTH_LONG);
        toast1.setGravity(CENTER_HORIZONTAL, 0, 0);
        toast1.show();
    }

    public void kiirRossz(android.view.View v) {
        msg = "Kedv: rossz, Dátum: " + (DateFormat.getDateTimeInstance().format(new Date()));
        Log.d("Kedv", msg);
        TW2.setText("Kedv: rossz");
        Toast toast1 = Toast.makeText(this, "Kedv: rossz", Toast.LENGTH_LONG);
        toast1.setGravity(CENTER_HORIZONTAL, 0, 0);
        toast1.show();
    }


}