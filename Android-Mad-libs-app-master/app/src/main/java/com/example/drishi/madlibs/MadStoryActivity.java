package com.example.drishi.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import stanford.androidlib.SimpleActivity;

public class MadStoryActivity extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_story);
        Intent intent =getIntent();
        String res= intent.getStringExtra("res");
        Log.d("last","res is "+res);
        TextView tv=find(R.id.result);
        tv.setText(res);

    }

    public void newStory(View view) {
        Intent intent=new Intent(this,FillBlanks.class);
        startActivity(intent);
    }
}
