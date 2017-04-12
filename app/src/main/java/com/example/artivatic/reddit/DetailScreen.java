package com.example.artivatic.reddit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by artivatic on 9/4/17.
 */

public class DetailScreen extends Activity {
    TextView tv_detail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        tv_detail=(TextView)findViewById(R.id.detail);
        Bundle bundle = getIntent().getExtras();
        String describe =bundle.getString("describe");
        Log.e("describeee",""+describe);
        tv_detail.setText(describe);
    }
}
