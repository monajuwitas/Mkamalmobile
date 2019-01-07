package id.co.mkamal.mkamalmobile.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import id.co.mkamal.mkamalmobile.Utils.LoginSession;

/**
 * Created by monajuwitas on 10/6/2018.
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {

    public LoginSession loginSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginSession = LoginSession.getInstance(this);

    }
}
