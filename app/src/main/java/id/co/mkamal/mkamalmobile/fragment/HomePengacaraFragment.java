package id.co.mkamal.mkamalmobile.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import id.co.mkamal.mkamalmobile.API.MobileAPI;
import id.co.mkamal.mkamalmobile.Base.BaseFragment;
import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.Response.ResponseProfil;
import id.co.mkamal.mkamalmobile.Utils.AppConstants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePengacaraFragment extends BaseFragment {


    TextView namastaff,isinamastaff,isialamatstaff, isiemailstaff, isinohpstaff ;
    ProgressDialog progress;



    public HomePengacaraFragment() {
        super();
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_pengacara, container, false);
        namastaff = (TextView)  view.findViewById(R.id.namastaff);
        isinamastaff= (TextView)  view.findViewById(R.id.isinamastaff);
        isialamatstaff = (TextView)  view.findViewById(R.id.isialamatstaff);
        isinohpstaff=(TextView)  view.findViewById(R.id.isinohpstaff);
        isiemailstaff=(TextView)  view.findViewById(R.id.isiemailstaff);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        dataprofilstaf();
    }

    public void dataprofilstaf(){
        //        coba retro
        String id = loginSession.getSessionId();

        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BaseUrl) //api
                .addConverterFactory(GsonConverterFactory.create()) //bawaan . untuk json
                .build();

        MobileAPI api = retrofit.create(MobileAPI.class); //menghubungkan ke mobileAPI
        Call<ResponseProfil> call = api.dataprofil(id);
        call.enqueue(new Callback<ResponseProfil>() {
            @Override
            public void onResponse(Call<ResponseProfil> call, Response<ResponseProfil> response) {
                progress.dismiss();
                namastaff.setText(response.body().getNama());
                isialamatstaff.setText(response.body().getAlamat());
                isinohpstaff.setText(response.body().getNohp());
                isiemailstaff.setText(response.body().getEmail());
                isinamastaff.setText(response.body().getNama());
            }

            @Override
            public void onFailure(Call<ResponseProfil> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(), "gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
