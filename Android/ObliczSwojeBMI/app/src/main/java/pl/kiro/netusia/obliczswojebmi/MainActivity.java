package pl.kiro.netusia.obliczswojebmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    float cm;
    float kg;
    float bmi;
    float x;//do prawidłowej masy
    float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void przeliczaj (View view) {
        EditText wzrost = (EditText) findViewById(R.id.editText);
        cm = Float.parseFloat(wzrost.getText().toString());

        EditText kilogram = (EditText) findViewById(R.id.editText2);
        kg = Float.parseFloat((kilogram.getText().toString()));

        bmi = kg / ((cm / 100) * (cm / 100));

        Context kontekst = getApplicationContext();
        int duration = Toast.LENGTH_LONG;

        String wiadomosc;
        String wiadomosc2;
        wiadomosc = " ";
        wiadomosc2=" ";

        if (bmi < 16) {
            wiadomosc = "wygłodzenie";
        }
        if ((bmi >= 16) && (bmi <= 16.99)) {
            wiadomosc = "wychudzenie";
        }
        if ((bmi >= 17) && (bmi <= 18.49)) {
            wiadomosc = "niedowaga";
        }
        if ((bmi >= 18.5) && (bmi <= 24.99)) {
            wiadomosc = "waga prawidłowa";
        }
        if ((bmi >= 25) && (bmi <= 29.99)) {
            wiadomosc = "nadwaga";
        }
        if ((bmi >= 30) && (bmi <= 34.99)) {
            wiadomosc = "I stopień otyłości";
        }
        if ((bmi >= 35) && (bmi <= 39.99)) {
            wiadomosc = "II stopień otyłości (otyłość kliniczna)";
        }
        if ((bmi >= 40)) {
            wiadomosc = "III stopień otyłości (otyłość skrajna)";
        }

        if(bmi<18.5)
        {
            x=19*(cm/100)*(cm/100);
            y=kg-x;
            y=y*(-1);
            wiadomosc2=("Powinieneś przybrać na wadze o ok "+y+" kg.");
        }
        if(bmi>24.9)
        {
            x=24*(cm/100)*(cm/100);
            y=kg-x;
            wiadomosc2=("Powinieneś zgubić ok "+y+" kg.");
        }

        TextView textView = (TextView) findViewById(R.id.textView5);
        textView.setText("Twój wskaźnik masy BMI wynosi " + bmi + " jest to " + wiadomosc+". "+wiadomosc2);

    }
    }
