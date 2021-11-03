package edu.illinois.cs465.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button trueButton;
    private Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.true_button) {
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.false_button) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
        }
    }

}