package com.example.farisauzan.curiculumvitae;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TautanActivity extends AppCompatActivity {
    private ListView lvItem;
    private String[] bahasapemrograman = new String[]{
            "STMIK AKAKOM JANTI","SIAKAD AKAKOM","LABORATORIUM AKAKOM" , "PENDAFTARAN MAHASISWA",
          "PERPUSTAKAAN AKAKOM", "HMJTI","HMJSI","HMJTK","UKMIK"};
    private ArrayList<String> url = new ArrayList<>();
    private String[] bahasapemrogaman =new String[]{
            "www.akakom.ac.id","siakad.akakom.ac.id","lab.akakom.ac.id","pmb.akakom.ac.id","perpus.akakom.ac.id",
            "hmjti.akakom.ac.id","hmjsi.akakom.ac.id","hmjtk.akakom.ac.id","ukm-ik.akakom.ac.id"};
    //mendeklarasikan listview var dan menginisialasi array tipe data string
    //Step 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tautan);

        getSupportActionBar().setTitle("Tautan Resmi"); //tampil title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        url.add("https://www.akakom.ac.id");
        url.add("https://siakad.akakom.ac.id");
        url.add("https://lab.akakom.ac.id");
        url.add("https://pmb.akakom.ac.id");
        url.add("https://perpus.akakom.ac.id");
        url.add("https://hmjti.akakom.ac.id");
        url.add("https://hmjsi.akakom.ac.id");
        url.add("https://hmjtk.akakom.ac.id");
        url.add("https://ukm-ik.akakom.ac.id");


        lvItem = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TautanActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, bahasapemrograman);
    /*
    Step 2
    Membinding atau memformat data
     */

        lvItem.setAdapter(adapter);
        //menset data di dalam listview

        //Step 3
        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TautanActivity.this, WebviewActivity.class);
                intent.putExtra("tautan",url.get(position));
                startActivity(intent);
                Toast.makeText(TautanActivity.this, "Memilih : "+bahasapemrograman[position], Toast.LENGTH_LONG).show();

                //memanggil set on Item ClickListener untuk Listview, jadi jika salah satu item list view diklik akan
                //akan bereaksi menampilkan toast atau aksi lainya.
                //Step 4
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){super.onBackPressed();}
}
