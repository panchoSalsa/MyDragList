package com.example.franciscofranco.mydraglist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItem;
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
        mItemArray.add(new Pair<Long, String>((long) 1020230, "francisco"));
        mItemArray.add(new Pair<Long, String>((long) 1020231, "cindy"));
        mItemArray.add(new Pair<Long, String>((long) 1020232, "randy"));
        mItemArray.add(new Pair<Long, String>((long) 1020233, "francisco"));
        mItemArray.add(new Pair<Long, String>((long) 1020234, "cindy"));
        mItemArray.add(new Pair<Long, String>((long) 1020235, "randy"));
        mItemArray.add(new Pair<Long, String>((long) 1020236, "francisco"));
        mItemArray.add(new Pair<Long, String>((long) 1020237, "cindy"));
        mItemArray.add(new Pair<Long, String>((long) 1020238, "randy"));
        mDragListView.setLayoutManager(new LinearLayoutManager(this.getApplication()));
        ItemAdapter listAdapter = new ItemAdapter(mItemArray, R.layout.list_item, R.id.image, false);
        mDragListView.setAdapter(listAdapter, true);
        mDragListView.setCanDragHorizontally(true);


//        mDragListView.setCanNotDragAboveTopItem(true);
//        mDragListView.setCanNotDragBelowBottomItem(true);

        mDragListView.setCustomDragItem(new MyDragItem(this.getApplicationContext(), R.layout.list_item));

    }

    private static class MyDragItem extends DragItem {
        public MyDragItem(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public void onBindDragView(View clickedView, View dragView) {
            CharSequence text = ((TextView) clickedView.findViewById(R.id.text)).getText();
            ((TextView) dragView.findViewById(R.id.text)).setText(text);
            dragView.setBackgroundColor(dragView.getResources().getColor(R.color.colorPrimary));
        }
    }
}
