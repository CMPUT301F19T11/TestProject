package com.example.swipedelete;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private long click;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);

        list = new ArrayList<>();
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");
        list.add("apple");


        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0x00, 0x66,
                        0xff)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setTitle("DELETE");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_phone);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        // set creator
        listView.setMenuCreator(creator);



        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                //click = adapter.getItemId(position);
                switch (index) {
                    case 0:
                        Log.d(TAG,"onMenuClick: clicked item "+ index);
                        //int c = (int) click;
                        //list.remove(c);
                        //adapter.notifyDataSetChanged();

                        break;
                    case 1:
                        Log.d(TAG,"onMenuClick: clicked item "+ index);
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });


    }
}
