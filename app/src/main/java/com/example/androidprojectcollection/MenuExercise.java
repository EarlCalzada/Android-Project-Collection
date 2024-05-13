package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity{

    Button btnChanger;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
        random = new Random();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.choice_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mItemChange) {
            Toast.makeText(this,"Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.mItemReset) {
            resetButton();
        }
        else if(item.getItemId() == R.id.mItemExit) {
            finish();
        }
        else if(item.getItemId() == R.id.mItemChangeBg) {
            int buttonColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            GradientDrawable drawable = (GradientDrawable) btnChanger.getBackground();
            drawable.setColor(buttonColor);
            btnChanger.setBackground(drawable);
        }
        else if(item.getItemId() == R.id.mItemChangeTextSize) {
            int size = random.nextInt(70);
            btnChanger.setTextSize(size);
        }
        else if(item.getItemId() == R.id.mItemChangeTextColor) {
            int textColor = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
            btnChanger.setTextColor(textColor);
        }
        else if(item.getItemId() == R.id.mItemChangeShape) {
            int radius = random.nextInt(230);
            GradientDrawable drawable = (GradientDrawable) btnChanger.getBackground();
            drawable.setCornerRadius(radius);
            btnChanger.setBackground(drawable);
        }
        else if(item.getItemId() == R.id.mItemChangeShapeSize) {
            ViewGroup.LayoutParams params = btnChanger.getLayoutParams();
            params.width = random.nextInt(convertDpToPixels(280));
            params.height = random.nextInt(convertDpToPixels(180));
            btnChanger.setLayoutParams(params);
        }
        else if(item.getItemId() == R.id.mItemExit) {
            finish();
        }
        return true;
    }
    public void resetButton() {
        int radius = convertDpToPixels(100);
        GradientDrawable drawable = (GradientDrawable) btnChanger.getBackground();
        drawable.setCornerRadius(radius);

        int width = convertDpToPixels(204);
        int height = convertDpToPixels(188);
        ViewGroup.LayoutParams params = btnChanger.getLayoutParams();
        params.width = width;
        params.height = height;
        btnChanger.setLayoutParams(params);
        drawable.setColor(Color.parseColor("#0000FF"));
        btnChanger.setTextColor(Color.parseColor("#FEFEFE"));
        btnChanger.setTextSize(34);
        btnChanger.setBackground(drawable);
    }
    private int convertDpToPixels(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        return(int)(dp * scale + 0.5f);
    }
}