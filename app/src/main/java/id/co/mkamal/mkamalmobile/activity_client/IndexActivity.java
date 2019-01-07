package id.co.mkamal.mkamalmobile.activity_client;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.mkamal.mkamalmobile.R;

public class IndexActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tv1;
    private TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        iv = (ImageView) findViewById(R.id.logomkamal);
        tv1 = (TextView) findViewById(R.id.judul);
        tv2 =(TextView) findViewById(R.id.welcome);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        tv1.startAnimation(myanim);
        tv2.startAnimation(myanim);
        iv.startAnimation(myanim);

        final Intent i =new Intent(this, LoginActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
