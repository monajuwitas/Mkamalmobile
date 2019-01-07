package id.co.mkamal.mkamalmobile.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.co.mkamal.mkamalmobile.Utils.LoginSession;

/**
 * Created by monajuwitas on 10/6/2018.
 */

public class BaseFragment extends Fragment implements IBaseView{

    public LoginSession loginSession;

    public  BaseFragment(){
        loginSession = LoginSession.getInstance(getContext());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
