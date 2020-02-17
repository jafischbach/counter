package com.example.numbercount;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView countView;
    public Button button;
    public Handler handler;
    public int count;
    public UpdateCount update;
    public boolean on;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.countView);
        button = findViewById(R.id.button);
        handler = new Handler();
        count = 0;
        on = false;
        update = new UpdateCount();
    }

    public void buttonPressed(View v) {
        if (on) {
            on = false;
            handler.removeCallbacks(update);
        } else {
            on = true;
            handler.postDelayed(update, 1000);
        }
    }

    private class UpdateCount implements Runnable {

        public void run() {
            count++;
            countView.setText(count+"");
            handler.postDelayed(update, 1000);
        }

    }

}
