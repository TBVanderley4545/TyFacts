package com.tbvanderleystudios.tyfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare our View variables as fields (which are variables that are class level)
    private TextView mFunFactTextView;
    private Button mNewFactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the View from the layout file to the corresponding variables
        mFunFactTextView = (TextView) findViewById(R.id.funFactTextView);
        mNewFactButton = (Button) findViewById(R.id.newFactButton);
    }
}
