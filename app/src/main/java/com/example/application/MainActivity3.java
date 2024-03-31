package com.example.application;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    private LinearLayout recyclerViewContainer; // Declared at class level

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

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter(getApplicationContext(), new ArrayList<>());
//        recyclerView.setAdapter(adapter);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechRecognition();
            }
        });


        recyclerViewContainer = findViewById(R.id.recyclerViewContainer);
        recyclerViewContainer.removeAllViews(); // Clear any existing RecyclerViews

        btnClear = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the text view
                tvText.setText("");

                // Clear the RecyclerView container
                recyclerViewContainer.removeAllViews();

                // Clear the RecyclerView adapter data
                for (int i = 0; i < recyclerViewContainer.getChildCount(); i++) {
                    View childView = recyclerViewContainer.getChildAt(i);
                    if (childView instanceof RecyclerView) {
                        RecyclerView recyclerView = (RecyclerView) childView;
                        recyclerView.setAdapter(null);
                    }
                }
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
                tvText.setText(getText);
                updateRecyclerView(getText);

            }
        }
    }private void updateRecyclerView(String text) {
        String[] words = text.split(" ");

       
        for (String word : words) {
            RecyclerView recyclerView = new RecyclerView(this);
            recyclerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            recyclerView.setPadding(0, 5, 0, 5);
            recyclerViewContainer.addView(recyclerView);

            List<item> items = getItemsForWord(word);
            MyAdapter adapter = new MyAdapter(getApplicationContext(), items);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        }
    }

    private List<item> getItemsForWord(String word) {
        word = word.toUpperCase();
        List<item> wordItems = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'A';
            if (index >= 0 && index < imgLetter.length) {
                wordItems.add(new item(String.valueOf(letter), imgLetter[index]));

            }
        }
        return wordItems;
    }







}
