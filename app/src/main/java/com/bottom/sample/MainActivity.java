package com.bottom.sample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import co.com.parsoniisolutions.custombottomsheetbehavior.R;
import com.bottom.lib.MyBehavior;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            strings.add(i + "");
        }

        RecyclerView rc_str = findViewById(R.id.rc_str);
        rc_str.setLayoutManager(new LinearLayoutManager(this));

        Adapter adapter = new Adapter();
        adapter.setNewData(strings);

        rc_str.setAdapter(adapter);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        final MyBehavior behavior = MyBehavior.from(bottomSheet);
        behavior.addBottomSheetCallback(new MyBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case MyBehavior.STATE_COLLAPSED:
                        Log.d("bottomsheet-5", "STATE_COLLAPSED");
                        break;
                    case MyBehavior.STATE_DRAGGING:
                        Log.d("bottomsheet-1", "STATE_DRAGGING");
                        break;
                    case MyBehavior.STATE_EXPANDED:
                        Log.d("bottomsheet-", "STATE_EXPANDED");
                        break;
                    case MyBehavior.STATE_ANCHOR_POINT:
                        Log.d("bottomsheet-", "STATE_ANCHOR_POINT");
                        break;
                    case MyBehavior.STATE_HIDDEN:
                        Log.d("bottomsheet-", "STATE_HIDDEN");
                        break;
                    default:
                        Log.d("bottomsheet-", "STATE_SETTLING");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        behavior.setState(MyBehavior.STATE_ANCHOR_POINT);
//        behavior.setState(MyBehavior.STATE_HIDDEN);
    }
}
