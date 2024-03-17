package com.example.application;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private TextToSpeech textToSpeech;
    private ImageButton a, b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,delete,space ;
    private String text,word="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton play = findViewById(R.id.speak);
        TextInputEditText textET = findViewById(R.id.textET);
        TextInputLayout textInputLayout = findViewById(R.id.textInputLayout);


        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textET.getText().toString().isEmpty()) {
                    textInputLayout.setError("Please enter a text");
                } else {
                    textToSpeech.speak(textET.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
                }
            }
        });




        a =  findViewById(R.id.a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "a";
                word= word+text;
                textET.setText(word);

            }
        });


        b = findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "b";
                word= word+text;
                textET.setText(word);

            }
        });


        c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "c";
                word= word+text;
                textET.setText(word);

            }
        });


        d = findViewById(R.id.d);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "b";
                word= word+text;
                textET.setText(word);

            }
        });


        c = findViewById(R.id.c);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "c";
                word= word+text;
                textET.setText(word);

            }
        });


        e = findViewById(R.id.e);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "e";
                word= word+text;
                textET.setText(word);

            }
        });

        f = findViewById(R.id.f);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "f";
                word= word+text;
                textET.setText(word);

            }
        });

        g = findViewById(R.id.g);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "g";
                word= word+text;
                textET.setText(word);

            }
        });


        h = findViewById(R.id.h);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "h";
                word= word+text;
                textET.setText(word);

            }
        });

        i = findViewById(R.id.i);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "i";
                word= word+text;
                textET.setText(word);

            }
        });

        j = findViewById(R.id.j);
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "j";
                word= word+text;
                textET.setText(word);

            }
        });

        k = findViewById(R.id.k);
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "k";
                word= word+text;
                textET.setText(word);

            }
        });

        l = findViewById(R.id.l);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "l";
                word= word+text;
                textET.setText(word);

            }
        });

        m = findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "m";
                word= word+text;
                textET.setText(word);

            }
        });

        n = findViewById(R.id.n);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "n";
                word= word+text;
                textET.setText(word);

            }
        });

        o = findViewById(R.id.o);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "o";
                word= word+text;
                textET.setText(word);

            }
        });

        p = findViewById(R.id.p);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "p";
                word= word+text;
                textET.setText(word);

            }
        });

        q = findViewById(R.id.q);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "v";
                word= word+text;
                textET.setText(word);

            }
        });

        r = findViewById(R.id.r);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "r";
                word= word+text;
                textET.setText(word);

            }
        });

        s = findViewById(R.id.s);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "s";
                word= word+text;
                textET.setText(word);

            }
        });

        t = findViewById(R.id.t);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "t";
                word= word+text;
                textET.setText(word);

            }
        });

        u = findViewById(R.id.u);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "u";
                word= word+text;
                textET.setText(word);

            }
        });

        v = findViewById(R.id.v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "v";
                word= word+text;
                textET.setText(word);

            }
        });

        w = findViewById(R.id.w);
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "w";
                word= word+text;
                textET.setText(word);

            }
        });

        x = findViewById(R.id.x);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "x";
                word= word+text;
                textET.setText(word);

            }
        });

        y = findViewById(R.id.y);
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "y";
                word= word+text;
                textET.setText(word);

            }
        });

        z = findViewById(R.id.z);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "z";
                word= word+text;
                textET.setText(word);

            }
        });


        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                 word = textET.getText().toString(); // Assuming textET is an EditText widget
//                if (!word.isEmpty()) {
//                    // Remove the last character (letter or space)
                    word = word.substring(0, word.length() - 1);
                    textET.setText(word);
               // }

            }
        });



        space = findViewById(R.id.space);
        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = " ";
                word= word+text;
                textET.setText(word);

            }
        });








    }

    @Override
    protected void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        super.onPause();
    }
}
