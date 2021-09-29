package com.example.a2_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; // import Intent class
import android.os.Bundle;
import android.widget.TextView; // import TextView class

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Bundle nameBundle = getIntent().getExtras(); // receives data from main activity

        // now we need to extract the data from the bundle
        // convert bundle data to string
        String data1 = nameBundle.getString("fName");
        String data2 = nameBundle.getString("lName");

        // assign xml objects for Textviews into variables
        TextView displayFirstName = (TextView) findViewById(R.id.displayFirstName);
        TextView displayLastName = (TextView) findViewById(R.id.displayLastName);

        displayFirstName.setText(data1);
        displayLastName.setText(data2);

    }
}