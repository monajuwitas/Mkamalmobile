package id.co.mkamal.mkamalmobile.activity_pengacara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import id.co.mkamal.mkamalmobile.R;

public class DetailKasusPengacaraActivity extends AppCompatActivity {

    Button editkasus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kasus_pengacara);
//        back
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//edit
        editkasus = (Button)findViewById(R.id.editdetailkasus);
        editkasus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pindahEdit = new Intent(DetailKasusPengacaraActivity.this,EditKasusActivity.class);
                startActivity(pindahEdit);
            }
        });
    }
}
