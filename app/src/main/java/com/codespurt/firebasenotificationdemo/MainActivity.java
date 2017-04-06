package com.codespurt.firebasenotificationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "FCMDeviceToken";
    private Button fcmToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fcmToken = (Button) findViewById(R.id.btn_getFirebaseToken);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fcmToken.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        fcmToken.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getFirebaseToken:
                String token = FirebaseInstanceId.getInstance().getToken();
                Log.d(TAG, "Device Token: " + token);
                break;
        }
    }
}
