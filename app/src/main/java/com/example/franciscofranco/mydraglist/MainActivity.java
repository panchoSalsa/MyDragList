package com.example.franciscofranco.mydraglist;

import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DragListView mDragListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDragListView = (DragListView) findViewById(R.id.draglistview);
        mDragListView.setDragListListener(new DragListView.DragListListener() {
            @Override
            public void onItemDragStarted(int position) {
                Toast.makeText(MainActivity.this.getApplicationContext(), "Start - position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemDragging(int itemPosition, float x, float y) {

            }

            @Override
            public void onItemDragEnded(int fromPosition, int toPosition) {
                if (fromPosition != toPosition) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "End - position: " + toPosition, Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<Pair<Long, String>> mItemArray = new ArrayList<Pair<Long, String>>();
        mItemArray.add(new Pair<Long, String>((long) 10202, "francisco"));
        mItemArray.add(new Pair<Long, String>((long) 10203, "cindy"));
        mItemArray.add(new Pair<Long, String>((long) 10202, "randy"));
        mDragListView.setLayoutManager(new LinearLayoutManager(this.getApplication()));
        ItemAdapter listAdapter = new ItemAdapter(mItemArray, R.layout.list_item, R.id.image, false);
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(false);


    }
}
