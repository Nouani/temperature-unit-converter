package br.unicamp.temperatureconverter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText edtFahrenheit;
    EditText edtKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        this.edtFahrenheit = (EditText)findViewById(R.id.edtFahrenheit);
        this.edtKelvin = (EditText)findViewById(R.id.edtKelvin);

        Intent intent = getIntent();
        Bundle input = intent.getExtras();

        edtFahrenheit.setText("" + input.getDouble("fahrenheit"));
        edtKelvin.setText("" + input.getDouble("kelvin"));
    }
}