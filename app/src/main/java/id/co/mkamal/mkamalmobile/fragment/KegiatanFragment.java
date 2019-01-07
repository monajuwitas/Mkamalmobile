package id.co.mkamal.mkamalmobile.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.mkamal.mkamalmobile.API.MobileAPI;
import id.co.mkamal.mkamalmobile.Model.ModelKegiatan;
import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.Response.ResponseKegiatan;
import id.co.mkamal.mkamalmobile.Utils.AppConstants;
import id.co.mkamal.mkamalmobile.Utils.RecyclerTouchListener;
import id.co.mkamal.mkamalmobile.activity_pengacara.LihatKegiatanActivity;
import id.co.mkamal.mkamalmobile.activity_pengacara.TambahKegiatanActivity;
import id.co.mkamal.mkamalmobile.adapter.GridAdapterKegiatan;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KegiatanFragment extends Fragment {

    Button tambahK;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    ProgressDialog progress;
    List<ModelKegiatan> listdata = new ArrayList<>();
    public KegiatanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kegiatan, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewkegiatan);
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);


        mAdapter = new GridAdapterKegiatan(listdata);
        mRecyclerView.setAdapter(mAdapter);

//        pindah halaman
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), LihatKegiatanActivity.class);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        tambahK = (Button)view.findViewById(R.id.tambahkasus);
        tambahK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getActivity(), TambahKegiatanActivity.class);
                startActivity(b);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        datarecyclerkegiatan();
    }

    public void datarecyclerkegiatan(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MobileAPI api = retrofit.create(MobileAPI.class);
        Call<ResponseKegiatan> call = api.list_kegiatan();

        call.enqueue(new Callback<ResponseKegiatan>() {
            @Override
            public void onResponse(Call<ResponseKegiatan> call, Response<ResponseKegiatan> response) {
                Toast.makeText(getActivity(),"ReqSukses", Toast.LENGTH_SHORT).show();
                progress.dismiss();
                listdata.clear();
                listdata.addAll(response.body().getData());
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseKegiatan> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(),"Request gagal", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
