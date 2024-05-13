package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1; Button btn2; Button btn3; Button btn4;
    Button btn5; Button btn6; Button btn7; Button btn8;
    Button btn9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn2 = (Button) findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ButtonExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn3 = (Button) findViewById(R.id.btnCalculatorExercise);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, CalculatorExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn4 = (Button) findViewById(R.id.btnMatch3Exercise);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Match3Exercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn5 = (Button) findViewById(R.id.btnMidterm);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, CalculatorExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn6 = (Button) findViewById(R.id.btnPassingIntentsExercise);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, PassingIntentsExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn7 = (Button) findViewById(R.id.btnFragments);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, CalculatorExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn8 = (Button) findViewById(R.id.btnMenu);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MenuExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
        btn9 = (Button) findViewById(R.id.btnOpeningMaps);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MapsExercise.class);//this activity, destination class
                startActivity(intent1);
            }
        });
    }
}