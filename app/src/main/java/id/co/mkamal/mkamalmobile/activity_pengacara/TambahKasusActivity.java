package id.co.mkamal.mkamalmobile.activity_pengacara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.fragment.KasusFragmentPengacara;

public class TambahKasusActivity extends AppCompatActivity {

    Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kasus);

        tambah = (Button) findViewById(R.id.editdetailkasusE);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,
                        new KasusFragmentPengacara()).commit();
            }
        });
    }
}
