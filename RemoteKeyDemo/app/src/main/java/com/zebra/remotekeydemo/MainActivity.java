package com.zebra.remotekeydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        final IntentFilter requestFilter = new IntentFilter();
        //  todo this sample does not capture the scan buttons so is confusing that even the folder refers to the Scan keys
        requestFilter.addAction("com.symbol.button.L1");    //  Scan LHS
        requestFilter.addAction("com.symbol.button.L2");    //  PTT LHS
        requestFilter.addAction("com.symbol.button.R1");    //  Scan RHS
        requestFilter.addAction("com.symbol.button.R2");    //  PTT RHS
        registerReceiver(myBroadcastReceiver, requestFilter);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        unregisterReceiver(myBroadcastReceiver);
    }

    private void outputText(String message) {
        TextView output = findViewById(R.id.txtOutput);
        output.setText(message + "\n" + output.getText());
    }

    private BroadcastReceiver myBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public synchronized void onReceive(Context context, final Intent intent) {

            try {
                if (intent == null || intent.getAction() == null)
                    return;
                KeyEvent event = intent
                        .getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                if (event == null)
                    return;

                int keyAction = event.getAction();

                if (event.getRepeatCount() != 0)
                    return;

                String message = "Key Pressed: " + intent.getAction() + " : "
                        + (keyAction == KeyEvent.ACTION_DOWN ? "DOWN" : "UP");
                outputText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

}
