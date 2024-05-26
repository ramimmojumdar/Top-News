package com.example.topnews;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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

            TextView itemCat = myView.findViewById(R.id.itemCat);
            ImageView itemImage = myView.findViewById(R.id.itemImage);
            TextView itemTitle = myView.findViewById(R.id.itemTitle);
            TextView itemDesc = myView.findViewById(R.id.itemDesc);
            LinearLayout nextId = myView.findViewById(R.id.nextId);


            HashMap<String, String> hashMap = arrayList.get(i);
            String cat = hashMap.get("cat");
            String image_url = hashMap.get("image_url");
            String title = hashMap.get("title");
            String description = hashMap.get("description");

            itemCat.setText(cat);
            itemTitle.setText(title);
            itemDesc.setText(description);

            Picasso.get()
                    .load(image_url)
                    .placeholder(R.drawable.img)
                    .into(itemImage);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            itemCat.setBackgroundColor(color);

            nextId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NextActivity.TITLE = title;
                    NextActivity.DESCRIPTION = description;

                    Bitmap bitmap = ((BitmapDrawable) itemImage.getDrawable()).getBitmap();
                    NextActivity.MY_BITMAP = bitmap;

                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    startActivity(intent);
                }
            });

            return myView;
        }
    }


    private void myMap(){

        hashMap = new HashMap();
        hashMap.put("cat", "TEACH");
        hashMap.put("image_url", "https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2024/05/23/asus_rog.jpg");
        hashMap.put("title", "A stellar gaming experience: The ASUS ROG Zephyrus G14");
        hashMap.put("description", "As the gaming laptop market continues to evolve, ASUS has once again raised the bar with the release of the ROG Zephyrus G14 (2024). This latest iteration boasts impressive specifications and promises to deliver an outstanding gaming experience. After spending a week with the G14, testing it with various games and applications, here is our comprehensive review.");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("cat", "EXAM");
        hashMap.put("image_url", "https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2024/05/23/asus_rog.jpg");
        hashMap.put("title", "A stellar gaming experience: The ASUS ROG Zephyrus G14");
        hashMap.put("description", "As the gaming laptop market continues to evolve, ASUS has once again raised the bar with the release of the ROG Zephyrus G14 (2024). This latest iteration boasts impressive specifications and promises to deliver an outstanding gaming experience. After spending a week with the G14, testing it with various games and applications, here is our comprehensive review.");
        arrayList.add(hashMap);

        hashMap = new HashMap();
        hashMap.put("cat", "POLITIC");
        hashMap.put("image_url", "https://tds-images.thedailystar.net/sites/default/files/styles/big_202/public/images/2024/05/23/asus_rog.jpg");
        hashMap.put("title", "A stellar gaming experience: The ASUS ROG Zephyrus G14");
        hashMap.put("description", "As the gaming laptop market continues to evolve, ASUS has once again raised the bar with the release of the ROG Zephyrus G14 (2024). This latest iteration boasts impressive specifications and promises to deliver an outstanding gaming experience. After spending a week with the G14, testing it with various games and applications, here is our comprehensive review.");
        arrayList.add(hashMap);





    }


}