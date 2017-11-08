package com.example.haneul.moilens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.haneul.moilens.CustomLensRcdPage.CustomLensRcdPageAct;

public class EyeAnalysisPageAct extends AppCompatActivity {

    Button analysisStartBtn;

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
    }
}
