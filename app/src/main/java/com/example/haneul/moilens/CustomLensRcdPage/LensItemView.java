package com.example.haneul.moilens.CustomLensRcdPage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.haneul.moilens.R;

/**
 * Created by MSI PC on 2017-11-09.
 */

public class LensItemView extends LinearLayout {

    ImageView lensImg;
    TextView lensName;
    TextView lensPercent;


    public LensItemView(Context context) {
        super(context);
    }

    public LensItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lens_item, this, true);

        lensImg=(ImageView) findViewById(R.id.rcdLensImg);
        lensName=(TextView) findViewById(R.id.rcdLensName);
        lensPercent=(TextView)findViewById(R.id.rcdLensPercent);
    }

    public void setLensImg(int resId) {
        //lensImg.setImageResource(R.drawable.image2);
        //lensImg.setImageResource(resId);
    }

    public void setLensName(String lensName) {
        this.lensName.setText(lensName);
    }

    public void setLensPercent(String lensPercent) {
        this.lensPercent.setText(lensPercent);
    }
}
