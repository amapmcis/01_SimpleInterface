package com.example.f1.simpleinterface;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {

    private int numberOfCups = 0;
    private int numOfSugar = 0;

    private TextView numberTV;
    private Button buttonPlus;
    private Button buttonMinus;
    private TextView sumTV;
    private Button buttonOrder;
    private SeekBar seekBar;
    private TextView sugarTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout for this activity:
        setContentView(R.layout.activity_main);

        // Find all elements for interaction:
        numberTV = (TextView) findViewById(R.id.numberTV);      // number of coffee cups
        buttonPlus = (Button) findViewById(R.id.buttonPlus);    // plus button
        buttonMinus = (Button) findViewById(R.id.buttonMinus);  // minus button
        sumTV = (TextView) findViewById(R.id.sumTV);            // suma
        buttonOrder = (Button) findViewById(R.id.buttonOrder);
        seekBar = (SeekBar) findViewById(R.id.seekBar);         // seekbar
        sugarTV = (TextView) findViewById(R.id.sugarTV);        // sugar TextView


        // Set initial number of cups in the respective TextView to 0:
        numberTV.setText(String.valueOf(numberOfCups));

        // Set listeners on buttons (minus/plus):
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Increment the number of cups by 1:
                numberOfCups += 1;
                // Set new value to the TextView for number of cups:
                numberTV.setText(String.valueOf(numberOfCups));
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOfCups > 0) {
                    // Decriment the number of cups
                    numberOfCups -= 1;
                    // Set new value to the TextView for number of cups:
                    numberTV.setText(String.valueOf(numberOfCups));
                }
            }
        });

        // Set listeners on buttons order:
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sum = 2 * numberOfCups + numberOfCups*numOfSugar*0.2;
                // Set new value to the TextView for sum:
                sumTV.setText(String.valueOf(sum)+"$");
            }
        });

        // SeekBar listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                numOfSugar = i;
                sugarTV.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
