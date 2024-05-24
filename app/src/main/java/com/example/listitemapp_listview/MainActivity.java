package com.example.listitemapp_listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        hashMap = new HashMap<>();
        hashMap.put("name", "Ramim Mojumdar");
        hashMap.put("number", "013000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Shmim Mojumdar");
        hashMap.put("number", "017000000000");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Naim Mojumdar");
        hashMap.put("number", "016000000000");
        arrayList.add(hashMap);


    }

    public class MyAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;
        LinearLayout itemId;
//        HashMap<String, String> hashMap;

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

        @SuppressLint("MissingInflatedId")
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View myView = layoutInflater.inflate(R.layout.list_item, listView, false);
            itemId = myView.findViewById(R.id.itemId);

            TextView nameId = myView.findViewById(R.id.nameId);
            TextView numberId = myView.findViewById(R.id.numberId);

            hashMap = arrayList.get(position);
            nameId.setText(hashMap.get("name"));
            numberId.setText(hashMap.get("number"));

            itemId.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast toast = Toast.makeText(MainActivity.this, "Item number is: "+position, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });


            return myView;
        }
    }

}