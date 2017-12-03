package com.example.uytai.sqlite_image;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnAddDoVat;
    ListView lvDoDat;
    ArrayList<DoVat> arrayDoVat;
    DoVatAdapter adapter;
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvDoDat = findViewById(R.id.listDoVat);
        Create();
        AddDoVat();

       GetDaTaDoVat();

    }

    private void GetDaTaDoVat() {
        arrayDoVat = new ArrayList<>();
        adapter = new DoVatAdapter(this, R.layout.item_dovat, arrayDoVat);
        lvDoDat.setAdapter(adapter);
        //getdata
        Cursor cursor = database.GetData("SELECT * FROM DoVat");
        while (cursor.moveToNext()){
            arrayDoVat.add(new DoVat(cursor.getInt(0), cursor.getBlob(1)));
        }
        adapter.notifyDataSetChanged();
    }

    private void AddDoVat() {
        btnAddDoVat = findViewById(R.id.btnAddDoVat);
        btnAddDoVat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Add_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void Create() {
        database = new Database(this, "QuanLy.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS DoVat(Id INTEGER PRIMARY KEY AUTOINCREMENT, HinhAnh BLOB)");
    }
}
