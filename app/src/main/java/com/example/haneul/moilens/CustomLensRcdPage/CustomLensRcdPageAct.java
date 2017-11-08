package com.example.haneul.moilens.CustomLensRcdPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.haneul.moilens.R;

import java.util.ArrayList;

public class CustomLensRcdPageAct extends AppCompatActivity {


    ListView listView;
    LensItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lens_rcd_page);

        listView= (ListView)findViewById(R.id.rcdLenslistView);

        adapter=new LensItemAdapter();

        adapter.addItem(new LensItem("렌즈 이름1","90%", R.drawable.lemon));
        adapter.addItem(new LensItem("렌즈 이름2","90%", R.drawable.lemon));
        adapter.addItem(new LensItem("렌즈 이름3","90%", R.drawable.lemon));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LensItem item=(LensItem)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택:"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    public class LensItemAdapter extends BaseAdapter {
        ArrayList<LensItem> items=new ArrayList<LensItem>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(LensItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LensItemView view=new LensItemView(getApplicationContext());
            LensItem item=items.get(position);
            view.setLensImg(item.getResId());
            view.setLensName(item.getName());
            view.setLensPercent(item.getPercent());

            return view;
        }
    }


}


