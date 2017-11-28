package com.cwc.marqueeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MarqueeView marqueeView;
    private String[] texts = new String[]{"啊", "阿斯利康地方就", "附加按双方大家快来撒付了款", "噼噼啪啪铺铺铺铺铺铺铺铺铺铺铺铺铺铺"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<View> list = new ArrayList<>();
        for (int i = 0;i < 4;i ++) {
            TextView textView = new TextView(this);
            textView.setTextColor(0xff000000);
            textView.setBackgroundColor(0xffffffff);
            textView.setText(texts[i]);
            list.add(textView);
        }
        marqueeView = (MarqueeView) findViewById(R.id.marquee_view);
        marqueeView.setViews(list);
        marqueeView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        marqueeView.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        marqueeView.start();
    }
}
