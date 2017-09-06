package com.example.hqwang.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListView;
    List<HashMap<String, String>> myList;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();

    }

    private void initDate(){
        mToolbar = findViewById(R.id.toolbar);
        mListView = (ListView) findViewById(R.id.listView);
        myList = new ArrayList<HashMap<String, String>>();
        for (int i=0; i<20; i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("itemTitle", "this is title");
            map.put("itemText", "this is text");
            myList.add(map);
        }

        Log.e("2222",mListView +"");
        MyAdapter myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);

        mToolbar.setTitle("首页");
        mToolbar.setSubtitle("subtitle");
        mToolbar.setLogo(R.drawable.ic_launcher_background);
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int i) {
            return myList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = null;
            if(null == viewHolder){
                viewHolder = new ViewHolder();
//            LayoutInflater inflater=LayoutInflater.from(this);
//            LayoutInflater inflater=getLayoutInflater();
//            LayoutInflater inflater=(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
                inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.item_layout,null);
                viewHolder.title = view.findViewById(R.id.itemTitle);
                viewHolder.text = view.findViewById(R.id.itemText);
                view.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) view.getTag(i);
            }

            viewHolder.title.setText(myList.get(i).get("itemTitle"));
            viewHolder.text.setText(myList.get(i).get("itemText"));

            return view;
        }
    }
    class ViewHolder {

        private TextView title, text;

    }
}
