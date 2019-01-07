package id.co.mkamal.mkamalmobile.activity_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.mkamal.mkamalmobile.R;

public class DetailKasusActivity extends AppCompatActivity {

//    @BindView(R.id.toolbar1)
//    Toolbar toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kasus);
//        ButterKnife.bind(this);
//        setToolbar(true);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    //    public void setToolbar(boolean enableButtonBack) {
//        setSupportActionBar(toolbar1);
//
//
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//    }
}
