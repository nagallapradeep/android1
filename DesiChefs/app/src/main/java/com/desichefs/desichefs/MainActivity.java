package com.desichefs.desichefs;

import android.app.Activity;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    EditText firstName, lastName, email, password;
    Button createButton;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.email);

        createButton = (Button) findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName = ""+firstName.getText().toString();
                String lName = ""+lastName.getText().toString();
                String eml = ""+email.getText().toString();
                String pwd = ""+password.getText().toString();

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                nameValuePairs.add(new BasicNameValuePair("fName", fName));
                nameValuePairs.add(new BasicNameValuePair ("lName", lName));
                nameValuePairs.add(new BasicNameValuePair ("eml", eml));
                nameValuePairs.add(new BasicNameValuePair ("pwd", pwd));

                try{

                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost("http://54.69.2.199/dc/dcConnection.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                }
            }
        });
    }

}
