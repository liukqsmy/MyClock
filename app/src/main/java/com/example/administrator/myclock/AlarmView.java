package com.example.administrator.myclock;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/24.
 */
public class AlarmView extends LinearLayout {
    public AlarmView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AlarmView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlarmView(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        btnAddAlarm = (Button)findViewById(R.id.btnAddAlarm);
        lvAlarmList = (ListView)findViewById(R.id.lvAlarmList);

        adapter = new ArrayAdapter<AlarmData>(getContext(),android.R.layout.simple_list_item_1);
        lvAlarmList.setAdapter(adapter);

        adapter.add(new AlarmData(System.currentTimeMillis()));

        btnAddAlarm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addAlarm();
            }
        });
    }

    private void addAlarm() {
        //TODO
    }

    private Button btnAddAlarm;
    private ListView lvAlarmList;
    private ArrayAdapter<AlarmData> adapter;

    private static class AlarmData{
        public  AlarmData(long time){
            this.time = time;

            date = new Date(time);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            timeLabel = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE);
        }

        public long getTime(){
            return time;
        }

        public String getTimeLabel(){
            return timeLabel;
        }

        @Override
        public String toString() {
            return getTimeLabel();
        }

        private String timeLabel ="";
        private long time = 0;
        private Date date;
    }
}
