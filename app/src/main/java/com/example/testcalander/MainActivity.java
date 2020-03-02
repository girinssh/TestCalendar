package com.example.testcalander;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Calendar;
import android.util.TimeUtils;

public class MainActivity extends AppCompatActivity {

    String[] day_of_the_week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    Calendar calendar;

   protected void createTabHost(){
        TabHost tabHost = (TabHost)findViewById(R.id.mainTabHost);
        tabHost.setup();

        TabHost.TabSpec[] tabSpecs = new TabHost.TabSpec[5];
        String[] nameOfTabs = getResources().getStringArray(R.array.namesOfTabs);

        for(int i = 0; i < 5; i++){
            tabSpecs[i] = tabHost.newTabSpec(String.format("Tab Spec%d", i));
            tabSpecs[i].setIndicator(nameOfTabs[i]);
        }

        tabSpecs[0].setContent(R.id.tab1);
        tabSpecs[1].setContent(R.id.tab2);
        tabSpecs[2].setContent(R.id.tab3);
        tabSpecs[3].setContent(R.id.tab4);
        tabSpecs[4].setContent(R.id.tab5);

        for(int i = 0; i < 5; i++)
            tabHost.addTab(tabSpecs[i]);
    }


    protected void createCalander(){
        calendar = Calendar.getInstance();

        TextView nameOfMonth = findViewById(R.id.NameOfMonth);

        TableLayout calendarTable;
        Button[][] days;
        TableRow[] rows;

        TableRow nameArea = new TableRow(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        TableRow.LayoutParams daysParams = new TableRow.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        int marginSize = 2;
        daysParams.setMargins(marginSize, marginSize, marginSize, marginSize);

        calendarTable = (TableLayout)findViewById(R.id.Calendar);

        calendarTable.setStretchAllColumns(true);
        calendarTable.setShrinkAllColumns(true);
        calendarTable.setBackgroundColor(Color.TRANSPARENT);

        String[] months= getResources().getStringArray(R.array.months);

        nameOfMonth.setText(new StringBuffer(months[calendar.get(Calendar.MONTH)]));
        Log.d("Day", "GetCalendar");

        days = new Button[5][7];
        Log.d("Day", "Set days");

        rows = new TableRow[5];
        Log.d("Day", "Set rows");

        nameArea.setLayoutParams(params);

        for(int i = 0; i < 7; i++){
            TextView name = new TextView(this);
            name.setText(new StringBuffer(day_of_the_week[i]));
            name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            name.setBackgroundColor(Color.WHITE);
            name.setLayoutParams(daysParams);
            nameArea.addView(name);
        }

        calendarTable.addView(nameArea, -1);

        for(int w = 0; w < 5; w++){
            Log.d("Day", String.format("W%d", w+1));
            rows[w] = new TableRow(this);

            rows[w].setLayoutParams(params);

            rows[w].setId(View.generateViewId());
            for(int d = 1; d <= 7; d++) {
                days[w][d-1] = new Button(this);

                days[w][d-1].setLayoutParams(daysParams);

                days[w][d-1].setId(View.generateViewId());

                days[w][d-1].setText(new StringBuffer(String.format("%d", w*7+d)));
                days[w][d-1].setTextAlignment(View.TEXT_ALIGNMENT_INHERIT);
                days[w][d-1].setBackgroundColor(Color.WHITE);

                rows[w].addView(days[w][d-1], -1);
            }
            calendarTable.addView(rows[w], -1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.createTabHost();

        this.createCalander();


    }

    @Override
    protected void onStart(){
        super.onStart();

        Log.d("Life Cycle", "onStart()");
    }
}
