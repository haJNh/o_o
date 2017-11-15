package com.example.haneul.moilens;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

public class SearchLensPageAct extends AppCompatActivity {


    String strColor = "#feffff";

    Button[] lensColors;
    LinearLayout[] lensColorsLayout;

    ImageButton openSearch;
    LinearLayout searchLayout, resultLayout;
    Button search;
    SeekBar diameterSeekBar, periodSeekBar;
    CheckBox astigmatism,oxygen;

    // 2017-11-15 : 폰트 적용 메소드
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_lens_page);


        if(Build.VERSION.SDK_INT >= 21){
            getSupportActionBar().hide();
        }else if(Build.VERSION.SDK_INT <21){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
        resultLayout = (LinearLayout) findViewById(R.id.resultLayout);
        diameterSeekBar = (SeekBar) findViewById(R.id.DiameterSeekBar);
        periodSeekBar = (SeekBar) findViewById(R.id.periodSeekBar);
        search = (Button) findViewById(R.id.searchButton);
        openSearch = (ImageButton) findViewById(R.id.openSearch);
        astigmatism=(CheckBox)findViewById(R.id.astigmatism);
        oxygen=(CheckBox)findViewById(R.id.oxygen);


        initLensColors(6);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLayout.setVisibility(View.GONE);
                resultLayout.setVisibility(View.VISIBLE);

                String str = "색상 : ";


                for (int i = 0; i < lensColors.length; i++) {
                    if (lensColors[i].getCurrentTextColor() == Color.parseColor(strColor))
                        str += ", " + lensColors[i].getText();
                }
                str = str + "\n";

                str += "직경 : " + getDiameter(diameterSeekBar.getProgress()) + "\n";
                str += "주기 : " + getPeriod(periodSeekBar.getProgress()) + "\n";
                str += "옵션 : ";
                if(oxygen.isChecked())str+="산소투과";
                if(astigmatism.isChecked())str+=" 난시";
                str+="\n";
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

            }
        });
        openSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLayout.setVisibility(View.VISIBLE);
                resultLayout.setVisibility(View.GONE);
            }
        });
        diameterSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (73 < i && i <= 100) seekBar.setProgress(90);
                if (50 < i && i <= 73) seekBar.setProgress(65);
                if (22 < i && i <= 50) seekBar.setProgress(35);
                if (0 <= i && i <= 22) seekBar.setProgress(10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        periodSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (73 < i && i <= 100) seekBar.setProgress(90);
                if (50 < i && i <= 73) seekBar.setProgress(65);
                if (22 < i && i <= 50) seekBar.setProgress(35);
                if (0 <= i && i <= 22) seekBar.setProgress(10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    void chahgeButton(Button button, LinearLayout layout) {
        if (button.getCurrentTextColor() == Color.parseColor(strColor)) {
            button.setTextColor(Color.parseColor("#ffffff"));
            layout.setBackgroundResource(R.drawable.notpressed);
        } else {
            button.setTextColor(Color.parseColor("#feffff"));
            layout.setBackgroundResource(R.drawable.pressed);
        }
    }


    String getPeriod(int progress) {

        String str = "";
        if (progress == 90) str = "없음";
        else if (progress == 65) str = "1달";
        else if (progress == 35) str = "1주";
        else str = "1일";
        return str;
    }

    String getDiameter(int progress) {

        String str = "";
        if (progress == 90) str = "11mm";
        else if (progress == 65) str = "12mm";
        else if (progress == 35) str = "13mm";
        else str = "14mm";
        return str;
    }

    void initLensColors(int j) {

        lensColors = new Button[j];
        lensColorsLayout = new LinearLayout[j];

        // lensColorsString=new String[j];

        lensColors[0] = (Button) findViewById(R.id.red);
        lensColors[1] = (Button) findViewById(R.id.brown);
        lensColors[2] = (Button) findViewById(R.id.gray);
        lensColors[3] = (Button) findViewById(R.id.yellow);
        lensColors[4] = (Button) findViewById(R.id.blue);
        lensColors[5] = (Button) findViewById(R.id.green);


        lensColorsLayout[0] = (LinearLayout) findViewById(R.id.redL);
        lensColorsLayout[1] = (LinearLayout) findViewById(R.id.brownL);
        lensColorsLayout[2] = (LinearLayout) findViewById(R.id.grayL);
        lensColorsLayout[3] = (LinearLayout) findViewById(R.id.yellowL);
        lensColorsLayout[4] = (LinearLayout) findViewById(R.id.blueL);
        lensColorsLayout[5] = (LinearLayout) findViewById(R.id.greenL);

        lensColors[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[0], lensColorsLayout[0]);
            }
        });
        lensColors[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[1], lensColorsLayout[1]);
            }
        });
        lensColors[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[2], lensColorsLayout[2]);
            }
        });
        lensColors[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[3], lensColorsLayout[3]);
            }
        });
        lensColors[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[4], lensColorsLayout[4]);
            }
        });
        lensColors[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chahgeButton(lensColors[5], lensColorsLayout[5]);
            }
        });


    }
}
