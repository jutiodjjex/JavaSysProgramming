package com.example.footballmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    TextView leftTeamScore;
    TextView rightTeamScore;
    TextView timeCounter;
    TextView stopwatchCount;
    int leftTeamScoreInteger;
    int rightTeamScoreInteger;

    int interval;
    static Timer timer;

    static int timeCounterInt = 1;

    static boolean stopWatchIsRunning = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatchCount = findViewById(R.id.matchTime);

        timer = new Timer();

            timer.scheduleAtFixedRate(
                    new TimerTask() {
                        @Override
                        public void run() {
                            System.out.println(stopWatchIsRunning);
                            System.out.println(interval);

                            setText(stopwatchCount, changeTimeString() + interval);
                            --interval;


                            if (interval <= 1) {
                                setTime(timeCounter, timeCounterInt);
                                timeCounterInt++;
                                interval = 15;
                                if (timeCounterInt >= 4) {
                                    timeCounterInt = 1;
                                }
                            }

                        }
                    }
                    , 1000, 1000);


        leftTeamScore = findViewById(R.id.leftTimeScore);
        rightTeamScore = findViewById(R.id.rightTimeScore);

        timeCounter = findViewById(R.id.timeCounter);



        Button leftButton = findViewById(R.id.btnLeftTeam);
        leftButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                leftTeamScoreInteger++;
                leftTeamScore.setText(String.valueOf(leftTeamScoreInteger));
                Toast.makeText(MainActivity.this, "Score " + getString(R.string.leftTeamName) + "!", Toast.LENGTH_SHORT).show();
            }

        });

        Button rightButton = findViewById(R.id.btnRightTeam);
        rightButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                rightTeamScoreInteger++;
                rightTeamScore.setText(String.valueOf(rightTeamScoreInteger));
                Toast.makeText(MainActivity.this, "Score " + getString(R.string.rightTeamName) + "!", Toast.LENGTH_SHORT).show();
            }

        });



    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("leftTeamScoreInteger", leftTeamScoreInteger);
        outState.putInt("rightTeamScoreInteger", rightTeamScoreInteger);
        outState.putInt("interval", interval);
        outState.putInt("timeCounterInt", timeCounterInt);
        outState.putBoolean("stopWatchIsRunning", stopWatchIsRunning);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                (savedInstanceState.containsKey("leftTeamScoreInteger") || savedInstanceState.containsKey("rightTeamScoreInteger"))) {
            leftTeamScoreInteger = savedInstanceState.getInt("leftTeamScoreInteger");
            rightTeamScoreInteger = savedInstanceState.getInt("rightTeamScoreInteger");
            leftTeamScore.setText(String.valueOf(leftTeamScoreInteger));
            rightTeamScore.setText(String.valueOf(rightTeamScoreInteger));

            interval = savedInstanceState.getInt("interval");
            setText(stopwatchCount, changeTimeString() + interval);

            timeCounterInt = savedInstanceState.getInt("timeCounterInt");
            setTime(timeCounter, timeCounterInt);

            stopWatchIsRunning = savedInstanceState.getBoolean("stopWatchIsRunning");
        }
    }


    private void setText(final TextView text, final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    private void setTime(TextView timeCounter, int timeCounterInt){
        switch (timeCounterInt) {
            case 1:
                setText(timeCounter, "First time");
                break;

            case 2:
                setText(timeCounter, "Second time");
                break;

            case 3:
                setText(timeCounter, "Third time");
                break;

            case 4:
                setText(timeCounter, "Fourth time");
                break;
        }
    }

    private String changeTimeString(){
        String timeString;
        if (interval <= 9) {
            timeString = "00:0";
        } else {
            timeString = "00:";
        }
        return timeString;
    }
}
