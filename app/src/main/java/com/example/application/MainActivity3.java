package com.example.application;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private static final int RESULT_SPEECH = 1;

    private SpeechRecognizer speechRecognizer;
    private ImageButton btnSpeak;
    private TextView tvText;
    private  Button btnClear;

    private final int[] imgLetter = {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n, R.drawable.o,
            R.drawable.p, R.drawable.q, R.drawable.r, R.drawable.s,
            R.drawable.t, R.drawable.u, R.drawable.v,
            R.drawable.w, R.drawable.x, R.drawable.y,
            R.drawable.z,
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvText = findViewById(R.id.tvText);
        btnSpeak = findViewById(R.id.btnSpeak);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);


        MyAdapter adapter = new MyAdapter(getApplicationContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechRecognition();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the text view
                tvText.setText("");

                // Clear the recycler view
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                MyAdapter adapter = new MyAdapter(getApplicationContext(), new ArrayList<>());
                recyclerView.setAdapter(adapter);
            }
        });

    }

    private void startSpeechRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");

        try {
            startActivityForResult(intent, RESULT_SPEECH);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Your Device Doesn't Support", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_SPEECH && resultCode == RESULT_OK && data != null) {
            ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (text != null && !text.isEmpty()) {
                String getText = text.get(0);
                updateRecyclerView(getText);
            }
        }
    }

    private void updateRecyclerView(String text) {
        List<item> items = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toUpperCase(text.charAt(i));
            int index = letter - 'A';
            if (index >= 0 && index < imgLetter.length) {
                items.add(new item(String.valueOf(letter), imgLetter[index]));
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(adapter);
    }
}
