package com.pradeep.contact;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;


public class MainActivity extends Activity {


    EditText nameTxt;
    EditText phoneTxt;
    EditText emailTxt;
    EditText addressTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTxt = (EditText) findViewById(R.id.prsnName);
        phoneTxt = (EditText) findViewById(R.id.prsnPhone);
        emailTxt = (EditText) findViewById(R.id.prsnEmail);
        addressTxt = (EditText) findViewById(R.id.prsnAddress);
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("creator");
        tabSpec.setContent(R.id.creatorTab);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(("list"));
        tabSpec.setContent(R.id.creatorTab);
        tabSpec.setIndicator("Store");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(("list"));
        tabSpec.setContent(R.id.contactListTab);
        tabSpec.setIndicator("Store");
        tabHost.addTab(tabSpec);

        final Button addBtn = (Button) findViewById(R.id.addContctBtn);

        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                addBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}