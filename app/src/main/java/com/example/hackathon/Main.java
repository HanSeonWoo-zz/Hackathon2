package com.example.hackathon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    final String TAG = "MainActivity";


    RecyclerViewAdapter mAdapter = null ;
    ArrayList<RecyclerViewData> mList = new ArrayList<RecyclerViewData>();
    RecyclerView mRecyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recyclerView) ;
        mAdapter = new RecyclerViewAdapter(mList) ;
        mRecyclerView.setAdapter(mAdapter) ;

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)) ;


        addItem(null,"닉넴",null,"라이크","뷰뷰","내요옹");
        mAdapter.notifyDataSetChanged();



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
                        Intent searchIntent = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(searchIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemAdd:
                        Log.d(TAG, "bottomItemAdd");
                        Intent addIntent = new Intent(getApplicationContext(), AddActivity.class);
                        startActivity(addIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemLike:
                        Log.d(TAG, "bottomItemLike");
                        Intent likeIntent = new Intent(getApplicationContext(), LikeActivity.class);
                        startActivity(likeIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemMyAccount:
                        Log.d(TAG, "bottomItemMyAccount");
                        Intent accountIntent = new Intent(getApplicationContext(), AccountActivity.class);
                        startActivity(accountIntent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }


    public void addItem(Bitmap userProfileImage, String userProfileNickName , Bitmap userThumbnail , String countLike , String countView, String contents) {

        //리절트로 가져온 값 여기에다가 넣어서 표시해주면된다. 이 메소드도 리절트 메소드에다가 넣어야함

        RecyclerViewData item = new RecyclerViewData();
//        item.setUserImage(userProfileImage);
        item.setUserNickName(userProfileNickName);
//        item.setYouTubeThumbnail(userThumbnail);
        item.setCountLike(countLike);
        item.setCountView(countView);
        item.setContents(contents);
        mList.add(item);
    }



}
