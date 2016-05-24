package com.example.administrator.myclock;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/5/24.
 */
public class TimeView extends LinearLayout {
    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TimeView(Context context) {
        super(context);
    }

    private TextView tvTime;


    private Handler timerHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            refreshTime();

            if(getVisibility() == View.VISIBLE){
                timerHandler.sendEmptyMessageDelayed(0,1000);
            }

        }
    };

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);

        if(visibility == View.VISIBLE)
        {
            timerHandler.sendEmptyMessage(0);
        }
        else
        {
            timerHandler.removeMessages(0);
        }
    }

    private  void refreshTime(){
        //System.out.println(">>>>>>");
        Calendar c = Calendar.getInstance();

        tvTime.setText(String.format("%d:%d:%d", c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND)));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tvTime = (TextView)findViewById(R.id.tvTime);
        tvTime.setText("hello");

        timerHandler.sendEmptyMessage(0);
    }
}
