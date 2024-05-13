package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MapsExercise extends AppCompatActivity {
    ImageButton ib1, ib2, ib3, ib4, ib5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        String[] coords = {
                "geo:10.281420367131922, 123.87867515281074", // Aglipay Cave
                "geo:16.479093041876805, 121.61758110991704", // Kagayan Lake Coron
                "geo:13.25545759138514, 123.68615494090729", // Mayon Volcano
                "geo:10.202254577711814, 118.98600815653114", // Puerto Princesa Underground River
                "geo:11.994964012893881, 121.91216258485503", // Puka Beach
        };

        ib1 = findViewById(R.id.imageButton1);
        ib2 = findViewById(R.id.imageButton2);
        ib3 = findViewById(R.id.imageButton3);
        ib4 = findViewById(R.id.imageButton4);
        ib5 = findViewById(R.id.imageButton5);

        mapOnlickListener(ib1, coords[0]);
        mapOnlickListener(ib2, coords[1]);
        mapOnlickListener(ib3, coords[2]);
        mapOnlickListener(ib4, coords[3]);
        mapOnlickListener(ib5, coords[4]);

    }

    private void mapOnlickListener(ImageButton button, final String coord) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(coord));
                startActivity(intent);
            }
        });
    }

}