package com.tbvanderleystudios.tyfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Create a TAG for our log output
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";

    // Declare our View variables as fields (which are variables that are class level)
    private TextView mFunFactTextView;
    private Button mNewFactButton;
    private RelativeLayout mRelativeLayout;

    // Create a FactBook and ColorBook object as a field
    private FactBook mFactBook = new FactBook();
    private ColorBook mColorBook = new ColorBook();

    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorBook.mColors[8]);

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
                mFact = mFactBook.getFact();
                mColor = mColorBook.getColor();

                // Update the screen with our dynamic fact
                mFunFactTextView.setText(mFact);

                // Change the color of the RelativeLayout background and Button text
                mRelativeLayout.setBackgroundColor(mColor);
                mNewFactButton.setTextColor(mColor);
            }
        };
        mNewFactButton.setOnClickListener(listener);

        // Below demonstrates how to use Toasts and Logging
        Toast.makeText(this, "Woohoo! How about a toast", Toast.LENGTH_LONG).show();
        Log.d(TAG, "We're logging from the MainActivity");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Get the fact before activity is destroyed
        outState.putString(KEY_FACT, mFact);
        // Get the color before activity is destroyed
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Retrieve the saved fact from onSaveInstanceState and set mFact's text with it.
        mFact = savedInstanceState.getString(KEY_FACT);
        mFunFactTextView.setText(mFact);

        // Retrieve the saved color from onSaveInstanceState and set background color and
        // mNewFactButton's text color with it.
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mRelativeLayout.setBackgroundColor(mColor);
        mNewFactButton.setTextColor(mColor);
    }
}
