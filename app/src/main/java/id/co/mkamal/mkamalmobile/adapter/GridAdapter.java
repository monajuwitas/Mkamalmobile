package id.co.mkamal.mkamalmobile.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.mkamal.mkamalmobile.Model.ModelKasus;
import id.co.mkamal.mkamalmobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monajuwitas on 9/18/2018.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

     private  List<ModelKasus> mItems;

//==========================================1
    public  class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView idkasus, judulkasus, tanggalkasus, client;

        public ViewHolder(View itemView) {
            super(itemView);
            idkasus = (TextView)itemView.findViewById(R.id.judul);
            judulkasus = (TextView)itemView.findViewById(R.id.nama);
            tanggalkasus = (TextView)itemView.findViewById(R.id.tanggalpengajuan);
            client = (TextView)itemView.findViewById(R.id.status);

        }
    }


    public GridAdapter(List<ModelKasus> suratPerbaikanDataModelList) {
        this.mItems = suratPerbaikanDataModelList;
    }

//    =================================2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);

        return new ViewHolder(v);
    }
//======================================================3

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelKasus modelkasus = mItems.get(position);
        holder.idkasus.setText(modelkasus.getId_kasus());
        holder.judulkasus.setText(modelkasus.getJudul_kasus());
        holder.tanggalkasus.setText(modelkasus.getTgl_kasus());
        holder.client.setText(modelkasus.getId_client());
    }
//=================================== 4


    @Override
    public int getItemCount() {

        return mItems.size();
    }



}
