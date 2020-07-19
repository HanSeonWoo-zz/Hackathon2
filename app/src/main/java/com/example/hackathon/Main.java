package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main extends AppCompatActivity {

    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationInit();

    }



    private void BottomNavigationInit() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//       처음에 선택되는 Item 설정.
        bottomNavigationView.setSelectedItemId(R.id.bottomItemHome);
//      Item들을 누르면 다른 Activity로 넘어가도록 만들었다.
//      fragment 를 사용해서 넘어가는 것처럼 보이게하기위해서 overridePendingTransition 메소드를 사용했다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottomItemHome:
                        return true;
                    case R.id.bottomItemSearch:
                        Log.d(TAG, "bottomItemSearch");
                        Intent wordsIntent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(wordsIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemAdd:
                        Log.d(TAG, "bottomItemAdd");
//                        songsIntent = new Intent(getApplicationContext(), SongsActivity.class);
//                        startActivity(songsIntent);
//                        overridePendingTransition(0, 0);
//                        return true;
                    case R.id.bottomItemLike:
                        Log.d(TAG, "bottomItemLike");
//                        mapsIntent = new Intent(getApplicationContext(), MapsActivity.class);
//                        startActivity(mapsIntent);
//                        overridePendingTransition(0, 0);
//                        return true;
                    case R.id.bottomItemMyAccount:
                        Log.d(TAG, "bottomItemMyAccount");
//                        colorsIntent = new Intent(getApplicationContext(), ColorsActivity.class);
//                        startActivity(colorsIntent);
//                        overridePendingTransition(0, 0);
//                        return true;
                }
                return false;
            }
        });
    }
}
