package com.example.clickerstudents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView progressText;
    TextView showValue;
    ProgressBar pbHorizontal;
    int pears = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showValue = findViewById(R.id.countText);

        pbHorizontal = findViewById(R.id.progressBar);
        pbHorizontal.setProgress(pears);

        progressText = findViewById(R.id.textToProgress);

                Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pears++;
                showValue.setText(String.valueOf(pears));

                pbHorizontal.setProgress(pears);
                if(pears % 100 == 0){
                    pbHorizontal.setMax(pears + 100);
                    Toast.makeText(MainActivity.this, "Congratulations, you have clicked button " + pears + " times", Toast.LENGTH_LONG).show();
                }

                progressText.setText(getString(R.string.text_progress) + " " + String.valueOf(pbHorizontal.getMax() - pears));
            }

        });


    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pears", pears);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("pears")) {
            pears = savedInstanceState.getInt("pears");
            showValue.setText(String.valueOf(pears));
            progressText.setText(getString(R.string.text_progress) + " " + String.valueOf(pbHorizontal.getMax() - pears));
        }
    }
}
