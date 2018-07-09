package com.androidtutoriels.jeuxadeux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int ScoreJ1;
    int ScoreJ2;

    Button buttonJoueur1;
    Button buttonJoueur2;
    Button buttonReset;
    TextView textViewScore1;
    TextView textViewScore2;

    boolean inGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Button Players
         buttonJoueur1  = (Button)findViewById(R.id.buttonJoueur1);
         buttonJoueur2  = (Button)findViewById(R.id.buttonJoueur2);

         //Button reset
        buttonReset = (Button)findViewById(R.id.buttonReset);

        //Game infos
        textViewScore1 = (TextView)findViewById(R.id.textViewScore1);
        textViewScore2 = (TextView)findViewById(R.id.textViewScore2);

        //Event on click button player 1
        buttonJoueur1.setOnClickListener(this);
        //Event on click button player 2
        buttonJoueur2.setOnClickListener(this);
        //Event On click reset
        buttonReset.setOnClickListener(this);


        //Reset of the game
        reset();

    }


    public void reset(){
        inGame = true;
        ScoreJ1 = 0;
        ScoreJ2 = 0;
        textViewScore1.setText("Score: " + ScoreJ1);
        textViewScore2.setText("Score: " + ScoreJ2);
        Toast.makeText(this, "Commencez la partie !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
       int id = view.getId();

       switch(id){
           case R.id.buttonReset :
                reset();
               break;

           case R.id.buttonJoueur2 :
               if(inGame) {
                   ScoreJ2++;
                   textViewScore2.setText("Score: " + ScoreJ2);

                   if(ScoreJ2 == 10){
                       Toast.makeText(MainActivity.this,"Le joueur 2 gagne la partie", Toast.LENGTH_SHORT).show();
                       inGame = false;
                   }
               }
               break;
           case R.id.buttonJoueur1 :
               if(inGame) {
                   ScoreJ1++;
                   textViewScore1.setText("Score: " + ScoreJ1);

                   if(ScoreJ1 == 10){
                       Toast.makeText(MainActivity.this,"Le joueur 1 gagne la partie", Toast.LENGTH_SHORT).show();
                       inGame = false;
                   }
               }
               break;

       }

    }
}
