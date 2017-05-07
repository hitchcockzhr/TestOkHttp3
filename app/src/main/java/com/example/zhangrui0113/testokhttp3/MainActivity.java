package com.example.zhangrui0113.testokhttp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {
    Button login_btn, post_btn, get_btn, image_btn;
    ImageView imageView;
    String http = "http://123.56.155.17:8080/";
    String loginUrl = "xys/healthButler/login";
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_btn = (Button)findViewById(R.id.login_btn);
        post_btn = (Button)findViewById(R.id.post_btn);
        get_btn = (Button)findViewById(R.id.get_btn);
        image_btn = (Button)findViewById(R.id.image_btn);
        imageView = (ImageView)findViewById(R.id.imageView);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new GsonBuilder().create();
                User user = new User("pb","123456");
                String jsonStr = gson.toJson(user);
                String result = HttpUtils.getResultFromHttpPost(jsonStr, http+loginUrl);
                Log.i(TAG, result);
            }
        });


    }

}
class User{
    String userId;
    String password;
    User(String userId, String password){
        this.userId = userId;
        this.password = password;
    }
}
