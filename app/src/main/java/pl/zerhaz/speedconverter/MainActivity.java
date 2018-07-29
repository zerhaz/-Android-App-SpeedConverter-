package pl.zerhaz.speedconverter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Spinner unitTypeSpinner;
    private EditText amountTextView;
    private short currentUnitInSpinner;

    TextView kphTextView, mphTextView, msTextView, knTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();

        addListenerToUnitTypesSpinner();

        amountTextView = (EditText) findViewById(R.id.amount_text_view);

        initializeTextViews();

        final Button button = findViewById(R.id.convert_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Hi, I am a button :) -> " + currentUnitInSpinner);
                convertSpeed(currentUnitInSpinner);
            }
        });
    }

    public void initializeTextViews() {
        kphTextView = (TextView) findViewById(R.id.KPH_ValueTextView);
        mphTextView = (TextView) findViewById(R.id.MPH_ValueTextView);
        msTextView = (TextView) findViewById(R.id.MS_ValueTextView);
        knTextView = (TextView) findViewById(R.id.KN_ValueTextView);
    }


    public void addItemsToUnitTypeSpinner() {
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.conversionTypes,
                        R.layout.spinner_item);

        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);


    }

    public void addListenerToUnitTypesSpinner() {
        unitTypeSpinner = (Spinner) findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                checkIfConvertingFromKph(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO add something later if needed
            }

        });
    }

    public void checkIfConvertingFromKph(String currentUnit) {
        if (currentUnit.equals("kph")) {
            currentUnitInSpinner = 1;
            System.out.println("kph -> " + currentUnitInSpinner);
        } else {
            if (currentUnit.equals("mph")) {
                currentUnitInSpinner = 2;
                System.out.println("mph -> " + currentUnitInSpinner);
            } else if (currentUnit.equals("m/s")) {
                currentUnitInSpinner = 3;
                System.out.println("m/s -> " + currentUnitInSpinner);
            } else {
                currentUnitInSpinner = 4;
                System.out.println("kn -> " + currentUnitInSpinner);
            }
        }
    }

    private void convertSpeed(short currentUnit){

        if(amountTextView.getText().length() == 0){
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast_text);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            return;
        }

        if (currentUnit == 1){

            double value = Double.parseDouble(amountTextView.getText().toString());

            TextView textKph = (TextView)findViewById(R.id.KPH_ValueTextView);
            textKph.setTextColor(Color.rgb(158, 247, 161));
            double newKph = value;
            String KphToString= String.format("%.2f", newKph);
            textKph.setText(KphToString);

            TextView textMph = (TextView)findViewById(R.id.MPH_ValueTextView);
            textMph.setTextColor(Color.rgb(221,221,221));
            double newMph = value * 0.621371;
            String MphToString= String.format("%.2f", newMph);
            textMph.setText(MphToString);

            TextView textMs = (TextView)findViewById(R.id.MS_ValueTextView);
            textMs.setTextColor(Color.rgb(221,221,221));
            double newMs = value * 0.277778;
            String MsToString= String.format("%.2f", newMs);
            textMs.setText(MsToString);

            TextView textKn = (TextView)findViewById(R.id.KN_ValueTextView);
            textKn.setTextColor(Color.rgb(221,221,221));
            double newKn = value * 0.539957;
            String KnToString= String.format("%.2f", newKn);
            textKn.setText(KnToString);

        } else {

            if (currentUnit == 2) {

                double value = Double.parseDouble(amountTextView.getText().toString());

                TextView textKph = (TextView)findViewById(R.id.KPH_ValueTextView);
                textKph.setTextColor(Color.rgb(221,221,221));
                double newKph = value * 1.609344;
                String KphToString= String.format("%.2f", newKph);
                textKph.setText(KphToString);

                TextView textMph = (TextView)findViewById(R.id.MPH_ValueTextView);
                textMph.setTextColor(Color.rgb(158, 247, 161));
                double newMph = value;
                String MphToString= String.format("%.2f", newMph);
                textMph.setText(MphToString);

                TextView textMs = (TextView)findViewById(R.id.MS_ValueTextView);
                textMs.setTextColor(Color.rgb(221,221,221));
                double newMs = value * 0.44704;
                String MsToString= String.format("%.2f", newMs);
                textMs.setText(MsToString);

                TextView textKn = (TextView)findViewById(R.id.KN_ValueTextView);
                textKn.setTextColor(Color.rgb(221,221,221));
                double newKn = value * 0.868976;
                String KnToString= String.format("%.2f", newKn);
                textKn.setText(KnToString);

            }

            if (currentUnit == 3) {

                double value = Double.parseDouble(amountTextView.getText().toString());

                TextView textKph = (TextView)findViewById(R.id.KPH_ValueTextView);
                textKph.setTextColor(Color.rgb(221,221,221));
                double newKph = value * 3.6;
                String KphToString= String.format("%.2f", newKph);
                textKph.setText(KphToString);

                TextView textMph = (TextView)findViewById(R.id.MPH_ValueTextView);
                textMph.setTextColor(Color.rgb(221,221,221));
                double newMph = value * 2.236936;
                String MphToString= String.format("%.2f", newMph);
                textMph.setText(MphToString);

                TextView textMs = (TextView)findViewById(R.id.MS_ValueTextView);
                textMs.setTextColor(Color.rgb(158, 247, 161));
                double newMs = value;
                String MsToString= String.format("%.2f", newMs);
                textMs.setText(MsToString);

                TextView textKn = (TextView)findViewById(R.id.KN_ValueTextView);
                textKn.setTextColor(Color.rgb(221,221,221));
                double newKn = value * 1.943844;
                String KnToString= String.format("%.2f", newKn);
                textKn.setText(KnToString);

            }

            if (currentUnit == 4) {

                double value = Double.parseDouble(amountTextView.getText().toString());

                TextView textKph = (TextView)findViewById(R.id.KPH_ValueTextView);
                textKph.setTextColor(Color.rgb(221,221,221));
                double newKph = value * 1.852;
                String KphToString= String.format("%.2f", newKph);
                textKph.setText(KphToString);

                TextView textMph = (TextView)findViewById(R.id.MPH_ValueTextView);
                textMph.setTextColor(Color.rgb(221,221,221));
                double newMph = value * 1.150779;
                String MphToString= String.format("%.2f", newMph);
                textMph.setText(MphToString);

                TextView textMs = (TextView)findViewById(R.id.MS_ValueTextView);
                textMs.setTextColor(Color.rgb(221,221,221));
                double newMs = value * 0.514444;
                String MsToString= String.format("%.2f", newMs);
                textMs.setText(MsToString);

                TextView textKn = (TextView)findViewById(R.id.KN_ValueTextView);
                textKn.setTextColor(Color.rgb(158, 247, 161));
                double newKn = value;
                String KnToString= String.format("%.2f", newKn);
                textKn.setText(KnToString);

            }


        }

    }


}