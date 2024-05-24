package com.example.topnews;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);

        myMap();


    }

    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item, viewGroup, false);
            TextView title = myView.findViewById(R.id.title);
            TextView description = myView.findViewById(R.id.description);
            HashMap<String, String> hashMap = arrayList.get(i);
            title.setText(hashMap.get("title"));
            description.setText(hashMap.get("description"));

            return myView;
        }
    }


    private void myMap(){

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("title", "hello Bangladesh. I am a Student. I love Programming");
        hashMap.put("description", "Description here");
        arrayList.add(hashMap);

    }


}