package com.example.androidprojectcollection;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class GameAdapter extends BaseAdapter {

    private Context context;
    private Match3Exercise match3Exercise;
    private int numTiles = 25;
    private Tile[] tiles;
    private int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
    private int score = 0;
    private int wins = 0;
    private int selectedPosition = -1;
    private boolean gameStopped = false;

    public GameAdapter(Context context, Match3Exercise match3Exercise) {
        this.context = context;
        this.match3Exercise = match3Exercise;
        tiles = new Tile[numTiles];
        Random random = new Random();
        for (int i = 0; i < numTiles; i++) {
            tiles[i] = new Tile(colors[random.nextInt(colors.length)]);
        }
    }

    @Override
    public int getCount() {
        return numTiles;
    }

    @Override
    public Object getItem(int position) {
        return tiles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setBackgroundColor(tiles[position].getColor());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!gameStopped) {
                    if (selectedPosition == -1) {
                        selectedPosition = position;
                    } else {
                        swapTiles(selectedPosition, position);
                        selectedPosition = -1;
                        notifyDataSetChanged();
                        checkForMatches(position);
                    }
                }
            }
        });
        return imageView;
    }

    private void checkForMatches(int position) {
        int row = position / 5;
        int col = position % 5;
        int color = tiles[position].getColor();

        int count = 1;
        for (int i = col + 1; i < 5; i++) {
            if (tiles[row * 5 + i].getColor() == color) {
                count++;
            } else {
                break;
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (tiles[row * 5 + i].getColor() == color) {
                count++;
            } else {
                break;
            }
        }

        if (count < 3) {
            count = 1;
            for (int i = row + 1; i < 5; i++) {
                if (tiles[i * 5 + col].getColor() == color) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = row - 1; i >= 0; i--) {
                if (tiles[i * 5 + col].getColor() == color) {
                    count++;
                } else {
                    break;
                }
            }
        }

        if (count >= 3) {
            score++;
            match3Exercise.updateScore(score);
            replaceMatchedTiles(row, col, color);

            if (score == wins) {
                // Display "You Win" toast message
                Toast.makeText(context, "You Win!", Toast.LENGTH_LONG).show();
                // Stop the game by disabling further clicks
                gameStopped = true;
            }
        }
    }

    private void replaceMatchedTiles(int row, int col, int color) {
        Random random = new Random();
        tiles[row * 5 + col].setColor(colors[random.nextInt(colors.length)]);

        for (int i = col + 1; i < 5; i++) {
            if (tiles[row * 5 + i].getColor() == color) {
                tiles[row * 5 + i].setColor(colors[random.nextInt(colors.length)]);
            } else {
                break;
            }
        }

        for (int i = col - 1; i >= 0; i--) {
            if (tiles[row * 5 + i].getColor() == color) {
                tiles[row * 5 + i].setColor(colors[random.nextInt(colors.length)]);
            } else {
                break;
            }
        }

        for (int i = row + 1; i < 5; i++) {
            if (tiles[i * 5 + col].getColor() == color) {
                tiles[i * 5 + col].setColor(colors[random.nextInt(colors.length)]);
            } else {
                break;
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            if (tiles[i * 5 + col].getColor() == color) {
                tiles[i * 5 + col].setColor(colors[random.nextInt(colors.length)]);
            } else {
                break;
            }
        }
    }

    private void swapTiles(int position1, int position2) {
        Tile temp = tiles[position1];
        tiles[position1] = tiles[position2];
        tiles[position2] = temp;
    }

    public void restartGame() {
        Random random = new Random();
        for (int i = 0; i < numTiles; i++) {
            tiles[i].setColor(colors[random.nextInt(colors.length)]);
        }
        score = 0;
        wins = 0;
        gameStopped = false;
        match3Exercise.updateScore(0);
        notifyDataSetChanged();
    }

    private class Tile {
        private int color;

        Tile(int color) {
            this.color = color;
        }

        int getColor() {
            return color;
        }

        void setColor(int color) {
            this.color = color;
        }
    }
}
