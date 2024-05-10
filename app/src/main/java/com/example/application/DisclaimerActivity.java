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
        disclaimerTextView.setText( "Disclaimer\n" +
                "* *Use at your own risk:*  This application (Two Way Communication for Mute People) is provided \"as is\" and without any warranty, express or implied. The developers disclaim all warranties, including but not limited to, warranties of merchantability, fitness for a particular purpose, and non-infringement. The developers assume no liability for any damages arising out of the use of this application.\n" +
                "* *Limitation of Liability:*  The developers of this application shall not be liable for any direct, indirect, incidental, consequential, or punitive damages arising out of or in connection with the use of this application, including, but not limited to, damages for loss of profits, data, or business interruption.\n" +
                "\n" +
                "* *Third-Party Content:* This application may contain links to third-party websites or services that are not owned or controlled by the developers. The developers are not responsible for the content or accuracy of any third-party websites or services. \n" +
                "\n" +
                "* *Data Usage:* This application may collect and use certain user data. Please refer to our Privacy Policy for more information on how we collect and use your data. \n" +
                " ([Link to your Privacy Policy here])\n" +
                "* *Changes to this Disclaimer:* The developers reserve the right to update this disclaimer at any time. You are advised to periodically revie this disclaimer for any changes.");
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
