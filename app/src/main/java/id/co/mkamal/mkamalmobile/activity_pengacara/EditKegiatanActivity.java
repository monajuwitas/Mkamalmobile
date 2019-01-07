package id.co.mkamal.mkamalmobile.activity_pengacara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.co.mkamal.mkamalmobile.R;

public class EditKegiatanActivity extends AppCompatActivity {
    Button selesaiEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kegiatan);

        selesaiEdit = (Button) findViewById(R.id.editkegiatanE);
        selesaiEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindaheditkegiatan = new Intent(EditKegiatanActivity.this, LihatKegiatanActivity.class);
                startActivity(pindaheditkegiatan);
            }
        });
    }
}
