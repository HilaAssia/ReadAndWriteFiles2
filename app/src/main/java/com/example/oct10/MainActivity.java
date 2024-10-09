package com.example.oct10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvSelected;
    RecyclerView recyclerView;
    MyViewAdapter adapter;
    ArrayList<Person> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        artists=new ArrayList<>();
        adapter=new MyViewAdapter(artists,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        tvSelected = findViewById(R.id.tvSelected);
        recyclerView = findViewById(R.id.list);

        findViewById(R.id.btnReadRsc).setOnClickListener(this::initialize);
        findViewById(R.id.btnWriteFile).setOnClickListener(this::writeFile);
        findViewById(R.id.btnReadFile).setOnClickListener(this::readFile);
        //findViewById(R.id.btnWriteJson).setOnClickListener(this::writeJson);
        //findViewById(R.id.btnReadJson).setOnClickListener(this::readJson);
    }
    public void initialize(View v) {
        FileReadWrite.readFileFromResources(artists, this);
        adapter.notifyDataSetChanged();
    }

    public void readFile(View v) {
        FileReadWrite.readFile(artists, this);
        adapter.notifyDataSetChanged();
    }

    public void writeFile(View v) {
        FileReadWrite.writeFile(artists, this);
    }

   /** public void writeJson(View v) {
        JsonReadWrite jsonReadWrite = new JsonReadWrite<Person>();
        if (!jsonReadWrite.writeJsonArrayList(artists, "artists.json", this))
            Toast.makeText(this, "Failed Writing JSON", Toast.LENGTH_LONG).show();
    }

    public void readJson(View v) {
        JsonReadWrite jsonReadWrite = new JsonReadWrite<Person>();
        ArrayList<Person> artists2 = jsonReadWrite.readJsonArrayList("artists.json", this, Person.class);
        if (artists2 != null) {
            artists.clear();
            artists.addAll(artists2);
            adapter.notifyDataSetChanged();
        } else
            Toast.makeText(this, "Failed reading JSON", Toast.LENGTH_LONG).show();
    }**/
}