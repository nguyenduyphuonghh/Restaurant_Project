package com.example.nguye.restaurant_project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nguye.restaurant_project.R;
import com.example.nguye.restaurant_project.adapter.ContentsAdapter;
import com.example.nguye.restaurant_project.model.Contents;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity{
    ListView lvIcon;
    ArrayList<Contents> dsContents;
    ContentsAdapter contentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        addControls();
        addEvents();
    }
    private void addEvents() {

    }

    private void addControls() {
        lvIcon = (ListView) findViewById(R.id.lv_about_us);
        dsContents = new ArrayList<>();

        dsContents.add(new Contents("Restaurant App for stuff","By 15A05 group",R.drawable.ic_menu_home));
        dsContents.add(new Contents("Build Version","Version 1.0",R.drawable.ic_menu_question));
        dsContents.add(new Contents("Email","developer.houdroid@gmail.com",R.drawable.ic_menu_email));
        dsContents.add(new Contents("Copyright","Copyright © 2017 Houdroid Developer. All rights reserved ",R.drawable.ic_menu_about));
        dsContents.add(new Contents("Share","Share to your friends",R.drawable.ic_menu_share));
        dsContents.add(new Contents("Rate","Give your rate and feedback",R.drawable.ic_menu_pencil));
        dsContents.add(new Contents("More","More apps from developer",R.drawable.ic_menu_more));

        contentsAdapter = new ContentsAdapter(AboutActivity.this,R.layout.items,dsContents);
        lvIcon.setAdapter(contentsAdapter);

        lvIcon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AboutActivity.this,"Bạn chọn "+i,Toast.LENGTH_SHORT).show();
            }
        });


    }

}
