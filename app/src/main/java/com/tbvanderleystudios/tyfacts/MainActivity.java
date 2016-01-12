package com.tbvanderleystudios.tyfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declare our View variables as fields (which are variables that are class level)
    private TextView mFunFactTextView;
    private Button mNewFactButton;
    private RelativeLayout mRelativeLayout;

    // Create a FactBook object as a field
    private FactBook mFactBook = new FactBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the View from the layout file to the corresponding variables
        mFunFactTextView = (TextView) findViewById(R.id.funFactTextView);
        mNewFactButton = (Button) findViewById(R.id.newFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.funFactRelativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The String fact gets a fact from the String[] in the FactBook class.
                String fact = mFactBook.getFact();

                // Update the screen with our dynamic fact
                mFunFactTextView.setText(fact);

                // Change the color of the RelativeLayout background and Button text
                mRelativeLayout.setBackgroundColor(Color.RED);
                mNewFactButton.setTextColor(Color.RED);
            }
        };
        mNewFactButton.setOnClickListener(listener);
    }
}
