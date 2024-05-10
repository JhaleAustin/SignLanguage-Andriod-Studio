package com.example.application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class DisclaimerActivity2 extends Activity {

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
        disclaimerTextView.setText("This two-way communication app is designed for individuals who are mute and have the ability to input a maximum of five words either through text or voice. The app converts the input into readable output displayed within the available space of the device for optimal readability.\n" +
                "\n" +
                "Users should be aware that the limited input capacity of five words may impact the clarity and completeness of their messages. It is recommended that users be concise and precise in their communication to ensure effective understanding by the recipient.\n" +
                "\n" +
                "Please note that this app is intended for facilitating brief and essential communication exchanges. Users are advised to consider the limitations of the input capacity when using the app for more complex or detailed conversations.\n" +
                "\n" +
                "By using this two-way communication app, users acknowledge and accept the terms and conditions outlined in this disclaimer. The developers of this app are not responsible for any miscommunication or misunderstanding that may arise due to the limited input capacity.\n" +
                "\n" +
                "\n");
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acceptCheckBox.isChecked()) {
                    // User accepted disclaimer, proceed to MainActivity
                    Intent intent = new Intent(DisclaimerActivity2.this, MainActivity2.class);
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
