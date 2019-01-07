package id.co.mkamal.mkamalmobile.activity_client;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.fragment.HomeFragment;
import id.co.mkamal.mkamalmobile.fragment.KasusFragment;

public class HomeClientActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,
                            new HomeFragment()).commit();
                    return true;

                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,
                            new KasusFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_client);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).commit();
    }

}
