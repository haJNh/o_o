package com.example.haneul.moilens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 슬라이딩 메뉴 객체
    private boolean isPageOpen = false; // 슬라이딩 페이지 표시 여부
    private Animation translateLeftAnim; // 왼쪽으로 이동 애니메이션 객체
    private Animation translateRightAnim; // 오른쪽으로 이동 애니메이션 객체
    private Animation fadeInAnim; // 점점 선명하게 보여주는 애니메이션 객체
    private Animation fadeOutAnim; // 점점 사라지도록 하는 애니메이션 객체
   // private LinearLayout page; // 슬라이딩으로 보여줄 페이지
    private LinearLayout page2; // 슬라이딩으로 보여줄 페이지

    // 슬라이딩 페이지 안의 객체들
    private Button logoutBtn;
    private TextView userNameText;
    private TextView myPageText;
    private TextView myLensText;
    private TextView myAlbumText;
    private TextView mySteamedUpListText;


    // 기본 메인 화면 안의 객체들
    private ImageButton eyeAnalysisBtn;
    private ImageButton searchLensBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 커스텀 액션바 사용
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);

        // 슬라이딩 페이지
        //page = (LinearLayout) findViewById(R.id.page);
        page2 = (LinearLayout) findViewById(R.id.page2);
        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOutAnim = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener(); // 슬라이딩 애니메이션을 감시할 리스너
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);
        fadeInAnim.setAnimationListener(animListener);
        fadeOutAnim.setAnimationListener(animListener);

        // 슬라이딩 페이지 이미지, 텍스트, 버튼
        logoutBtn=(Button)findViewById(R.id.logoutBtn);
        userNameText=(TextView)findViewById(R.id.userNameText);
        myLensText=(TextView)findViewById(R.id.myLensText);
        myPageText=(TextView)findViewById(R.id.myPageText);
        myAlbumText=(TextView)findViewById(R.id.myAlbumText);
        mySteamedUpListText=(TextView)findViewById(R.id.mySteamedUpListText);

        // 로그아웃 버튼 이벤트
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","logout");
            }
        });

        userNameText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","userNameText");
            }
        });

        myPageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","myPageText");
            }
        });

        myLensText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","myLensText");
            }
        });

        myAlbumText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","myAlbumText");
            }
        });

        mySteamedUpListText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("menu:","mySteamedUpListText");
            }
        });

        // 기본 메인 화면 객체들 선언
        eyeAnalysisBtn=(ImageButton) findViewById(R.id.eyeAnalysisBtn);
        eyeAnalysisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getApplicationContext(), EyeAnalysisPageAct.class);
                startActivity(intent);
            }
        });

        searchLensBtn=(ImageButton) findViewById(R.id.searchLensBtn);
        searchLensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( getApplicationContext(), SearchLensPageAct.class);
                startActivity(intent);
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
        // 현재 선택된 메뉴
        int curId = item.getItemId();
        // 메뉴에 따른 처리
        switch (curId) {
            case R.id.slidingMenu:
                // 슬라이딩 메뉴 보이기
                if(isPageOpen){
                   // page.startAnimation(translateRightAnim); // 페이지가 열려있으면 오른쪽으로 애니메이션
                   // page2.startAnimation(fadeOutAnim);
                    page2.startAnimation(fadeOutAnim);
                } else {
                   // page.setVisibility(View.VISIBLE); // 페이지가 닫혀 있으면 보이도록 한 후

                    //page.startAnimation(translateLeftAnim);  // 왼쪽으로 애니메이션
                    page2.startAnimation(fadeInAnim);
                    page2.setVisibility(View.VISIBLE);
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
               // page.setVisibility(View.INVISIBLE);
                page2.setVisibility(View.INVISIBLE);
                isPageOpen = false;
            } else {
                isPageOpen = true;
            }
        }

        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationStart(Animation animation) {

        }

    }
}
