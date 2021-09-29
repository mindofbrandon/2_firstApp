package com.example.a2_firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View; // imports View class
import android.content.Intent; // imports Intent class
import android.widget.EditText; // imports EditText class

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button
    * Here's what's going on in sendMessage():

    * The Intent constructor takes two parameters, a Context and a Class.

    * The Context parameter is used first because the Activity class is a subclass of Context.

    * The Class parameter of the app component, to which the system delivers the Intent, is, in this case, the activity to start.

    * The putExtra() method adds the value of EditText to the intent. An Intent can carry data types as key-value pairs called extras.

    * Your key is a public constant EXTRA_MESSAGE because the next activity uses the key to retrieve the text value. It's a good practice to define keys for intent extras with your app's package name as a prefix. This ensures that the keys are unique, in case your app interacts with other apps.

    * The startActivity() method starts an instance of the DisplayMessageActivity that's specified by the Intent. Next, you need to create that class.
    */

    public void sendMessage(View view) {
        Intent displayIntent = new Intent(this, DisplayMessageActivity.class); // intent to jump to DisplayMessageActivity

        EditText firstText = (EditText) findViewById(R.id.editTextPersonFirstName); // data received from user
        EditText lastText = (EditText) findViewById(R.id.editTextPersonLastName); // data received from user

        String firstMessage = firstText.getText().toString(); // convert to string type
        String lastMessage = lastText.getText().toString();

        Bundle bridge = new Bundle();

        // bridge data from main activity to next activity
        bridge.putString("fName", firstMessage); // first parameter fName is used to pass the contents
        bridge.putString("lName", lastMessage); // to the next activity

        displayIntent.putExtras(bridge); // pass bundle as a param

        startActivity(displayIntent);

    }
}