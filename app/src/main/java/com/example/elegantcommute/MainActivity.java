package com.example.elegantcommute;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView anotherTextMessage;
    private String s = "oya";

    Intent create_intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_join);
                    anotherTextMessage.setText(s);
                    return true;
                case R.id.navigation_dashboard:
                    //Start create ride activity
//                    EditText editText = (EditText) findViewById(R.id.editText);
//                    String message = editText.getText().toString();
//                    create_intent.putExtra(EXTRA_MESSAGE, message);
//                    startActivity(intent);
                    startActivity(create_intent);


                    mTextMessage.setText(R.string.title_create);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_carpool);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         create_intent = new Intent(this, CreateRide.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        anotherTextMessage = findViewById(R.id.wanMessage);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
