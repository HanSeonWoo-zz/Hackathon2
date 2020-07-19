package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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
    LinearLayout linearLayoutHome, linearLayoutSearch, linearLayoutAdd, linearLayoutLike, linearLayoutProfile;

    EditText inputTubeUrl, inputText;
    String tubeUrl, text, name, email, userUid;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        linearLayoutHome = findViewById(R.id.linearLayoutHome);
        linearLayoutSearch = findViewById(R.id.linearLayoutSearch);
        linearLayoutAdd = findViewById(R.id.linearLayoutAdd);
        linearLayoutLike = findViewById(R.id.linearLayoutLike);
        linearLayoutProfile = findViewById(R.id.linearLayoutProfile);

        linearLayoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddActivity.this, Main.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
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










    

        linearLayoutSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddActivity.this, SearchActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

        linearLayoutAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddActivity.this, AddActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
        linearLayoutLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddActivity.this, LikeActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
        linearLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddActivity.this, ProfileActivity.class);
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
    }
}
