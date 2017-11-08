package com.example.haneul.moilens.CustomLensRcdPage;

/**
 * Created by MSI PC on 2017-11-09.
 */

public class LensItem {

    String name;
    String percent;
    int imageNum; // 나중에 수정 : 리소스를 참고하기 위한 것.

    public LensItem(String name, String percent, int imageNum) {
        this.name = name;
        this.percent = percent;
        this.imageNum = imageNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public int getResId() {
        return imageNum;
    }

    public void setResId(int imageNum) {
        this.imageNum = imageNum;
    }
}
