package com.cwc.marqueeview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Cuiweicong 2017/9/13
 */

public class MarqueeView extends ViewFlipper {
    private List<View> views;
    private int position = 0;
    private Handler handler;
    private Timer timer;


    private static final int DELAY = 1000;
    private static final int PERIOD = 5000;
    private static final int FLIP_INTERVAL = 5000;
    private static final int CHANGE_VIEW_FLAG = 1;

    public MarqueeView(Context context) {
        this(context, null);
    }

    public MarqueeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == CHANGE_VIEW_FLAG) {
                    showNext();
                }
            }
        };
        setInAnimation(getContext(), R.anim.marquee_in);
        setOutAnimation(getContext(), R.anim.marquee_out);
    }

    public void setViews(List<View> views){
        if (views == null || views.size() == 0) {
            return;
        }
        this.views = views;
        removeAllViews();
        for (View view : this.views) {
            addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }
    }

    public void start(){
        if (views == null || views.size() < 0) {
            return;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                position ++;
                position = position % views.size();
                handler.sendEmptyMessage(CHANGE_VIEW_FLAG);
            }
        }, DELAY, PERIOD);
    }

    public void stop(){
        if (timer != null) {
            timer.cancel();
        }
    }
}
