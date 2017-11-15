package com.example.haneul.moilens;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.haneul.moilens.CustomLensRcdPage.CustomLensRcdPageAct;
import com.tsengvn.typekit.TypekitContextWrapper;

public class EyeAnalysisPageAct extends AppCompatActivity {

    Button analysisStartBtn;


    // 2017-11-15 : 폰트 적용 메소드
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_analysis_page);

        analysisStartBtn=(Button) findViewById(R.id.analysisStartBtn);
        analysisStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), CustomLensRcdPageAct.class);
                startActivity(intent);
            }
        });

        if(Build.VERSION.SDK_INT >= 21){
            getSupportActionBar().hide();
        }else if(Build.VERSION.SDK_INT <21){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }
}
