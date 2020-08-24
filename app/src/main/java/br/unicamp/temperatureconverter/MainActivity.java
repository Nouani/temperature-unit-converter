package br.unicamp.temperatureconverter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtCelsius;
    TextView tvMessageError;
    Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        this.edtCelsius = (EditText) findViewById(R.id.edtCelsius);
        this.btnConvert = (Button) findViewById(R.id.btnConvert);
        this.tvMessageError = (TextView) findViewById(R.id.tvErrorMessage);

        this.btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMessageError.setText("");
                if (validateTemperature()) {
                    UnitTemperature degreesCelsius = new UnitTemperature(Double.parseDouble(edtCelsius.getText().toString().trim()));
                    double fahrenheit = degreesCelsius.toFahrenheit();
                    double kelvin = degreesCelsius.toKelvin();

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    Bundle params = new Bundle();

                    params.putDouble("fahrenheit", fahrenheit);
                    params.putDouble("kelvin", kelvin);

                    System.out.println(fahrenheit);
                    System.out.println(kelvin);

                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateTemperature() {
        String temperatureCelsius = edtCelsius.getText().toString().trim();

        if (temperatureCelsius.isEmpty()) {
            edtCelsius.setError("Empty field");
            tvMessageError.setText("Fill in the field");

            return false;
        } else {
            edtCelsius.setError(null);
            return true;
        }
    }
}