package id.co.mkamal.mkamalmobile.activity_pengacara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import id.co.mkamal.mkamalmobile.R;

public class LihatKegiatanActivity extends AppCompatActivity {

    Button editKegiatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kegiatan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        editKegiatan = (Button) findViewById(R.id.editkegiatan);
        editKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindahedit = new Intent(LihatKegiatanActivity.this, EditKegiatanActivity.class);
                startActivity(pindahedit);
            }
        });

    }
}
