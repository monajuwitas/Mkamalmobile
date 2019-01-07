package id.co.mkamal.mkamalmobile.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.co.mkamal.mkamalmobile.API.MobileAPI;
import id.co.mkamal.mkamalmobile.Model.ModelKasus;
import id.co.mkamal.mkamalmobile.Response.ResponseKasus;
import id.co.mkamal.mkamalmobile.Utils.AppConstants;
import id.co.mkamal.mkamalmobile.activity_client.DetailKasusActivity;
import id.co.mkamal.mkamalmobile.R;
import id.co.mkamal.mkamalmobile.Utils.RecyclerTouchListener;
import id.co.mkamal.mkamalmobile.adapter.GridAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class KasusFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    ProgressDialog progress;
    List<ModelKasus> listdata = new ArrayList<>();

    public KasusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kasus, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter(listdata);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(), DetailKasusActivity.class);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        datarecyclerkasus();
    }

    public void datarecyclerkasus(){
        progress = new ProgressDialog(getActivity());
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppConstants.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MobileAPI api = retrofit.create(MobileAPI.class);
        Call<ResponseKasus> call = api.list_kasus();

        call.enqueue(new Callback<ResponseKasus>() {
            @Override
            public void onResponse(Call<ResponseKasus> call, Response<ResponseKasus> response) {
                progress.dismiss();
                listdata.clear();
                listdata.addAll(response.body().getData());
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseKasus> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(getActivity(),"Request gagal", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
