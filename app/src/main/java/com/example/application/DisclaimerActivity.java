package com.example.application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DisclaimerActivity extends Activity {

    private TextView disclaimerTextView;
    private CheckBox acceptCheckBox;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        disclaimerTextView = findViewById(R.id.disclaimerTextView);
        acceptCheckBox = findViewById(R.id.acceptCheckBox);
        proceedButton = findViewById(R.id.proceedButton);
        disclaimerTextView.setText( "This two-way communication app is specifically designed for individuals who are mute but able to read in English language. Also for a normal person who want to communication with mute or deaf people. It is important to note that this application is intended to facilitate communication between users who are able and unable to speak verbally.\n" +
                "\n" +
                "Users of this app should be aware that while it provides a platform for written communication, it may not be suitable for all individuals with communication challenges. It is recommended that users exercise caution and discretion when sharing personal information or engaging in conversations through this app.\n" +
                "\n" +
                "Additionally, it is important to note that this app is not a replacement for professional medical advice or treatment. Users are strongly encouraged to seek guidance from healthcare professionals or speech therapists for personalized communication solutions and support.\n" +
                "\n" +
                "By using this two-way communication app, users acknowledge and accept the terms and conditions outlined in this disclaimer. The developers of this app are not liable for any misuse or misinterpretation of information exchanged through the platform.\n");
                proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acceptCheckBox.isChecked()) {
                    // User accepted disclaimer, proceed to MainActivity
                    Intent intent = new Intent(DisclaimerActivity.this, MainActivity.class);
                    startActivity(intent);
              //      finish(); // Finish disclaimer activity
                } else {
                    // Show a message that user needs to accept disclaimer
                    // You can display a Toast or a Snackbar here
                }
            }
        });
    }
}
