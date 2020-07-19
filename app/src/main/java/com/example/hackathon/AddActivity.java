package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class AddActivity extends AppCompatActivity {

    final String TAG = "AddActivity";
    EditText inputTubeUrl, inputText;
    String tubeUrl, text, name, email, userUid;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mAuth = FirebaseAuth.getInstance();







          user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            name = user.getDisplayName();
            email = user.getEmail();
            userUid=user.getUid();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }

        //글쓰기버튼
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //에딧텍스트 xml연결하고 스트링으로 변환
                inputTubeUrl=findViewById(R.id.editTextId);
                inputText = findViewById(R.id.editTextPassword);
                tubeUrl = inputTubeUrl.getText().toString();
                text = inputText.getText().toString();
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd/HH:mm");
                String currentDateandTime = sdf.format(new Date());




                //글쓰기버튼 눌럿을때 로직
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("write").push();


                Hashtable<String, String> profiles
                        = new Hashtable<String, String>();



                profiles.put("email", email);
                profiles.put("nicname", name);
                profiles.put("contents", text);
                profiles.put("youtubeUrl", tubeUrl);
                profiles.put("goodCount", "0");
                profiles.put("visitCount", "0");
                profiles.put("nowTime", currentDateandTime);




                myRef.setValue(profiles);
                inputText.setText("");
                inputTubeUrl.setText("");





            }
        });









        BottomNavigationInit();
    }

    private void BottomNavigationInit() {

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
//       처음에 선택되는 Item 설정.
        bottomNavigationView.setSelectedItemId(R.id.bottomItemAdd);
//      Item들을 누르면 다른 Activity로 넘어가도록 만들었다.
//      fragment 를 사용해서 넘어가는 것처럼 보이게하기위해서 overridePendingTransition 메소드를 사용했다.
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottomItemHome:
                        Intent homeIntent  = new Intent(getApplicationContext(), Main.class);
                        startActivity(homeIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemSearch:
                        Log.d(TAG, "bottomItemSearch");
                        Intent searchIntent = new Intent(getApplicationContext(), SearchActivity.class);
                        startActivity(searchIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemAdd:
                        Log.d(TAG, "bottomItemAdd");
                        return true;
                    case R.id.bottomItemLike:
                        Log.d(TAG, "bottomItemLike");
                        Intent likeIntent  = new Intent(getApplicationContext(), LikeActivity.class);
                        startActivity(likeIntent);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.bottomItemMyAccount:
                        Log.d(TAG, "bottomItemMyAccount");
                        Intent accountIntent  = new Intent(getApplicationContext(), AccountActivity.class);
                        startActivity(accountIntent);
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}
