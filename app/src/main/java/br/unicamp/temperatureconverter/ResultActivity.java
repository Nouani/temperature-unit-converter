package br.unicamp.temperatureconverter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {
    EditText edtFahrenheit;
    EditText edtKelvin;
    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        this.edtFahrenheit = (EditText) findViewById(R.id.edtFahrenheit);
        this.edtKelvin = (EditText) findViewById(R.id.edtKelvin);
        this.btnReturn = (Button) findViewById(R.id.btnReturn);

        Intent intent = getIntent();
        Bundle input = intent.getExtras();

        edtFahrenheit.setText("" + input.getDouble("fahrenheit"));
        edtKelvin.setText("" + input.getDouble("kelvin"));

        this.btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}