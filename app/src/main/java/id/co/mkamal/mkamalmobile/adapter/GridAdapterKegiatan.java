package id.co.mkamal.mkamalmobile.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.mkamal.mkamalmobile.Model.ModelKegiatan;
import id.co.mkamal.mkamalmobile.R;

public class GridAdapterKegiatan extends RecyclerView.Adapter<GridAdapterKegiatan.ViewHolder> {


    private  List<ModelKegiatan> mItems;

    //==========================================1
    public  class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView idkasus, namakegiatan, jenisKegiatan,tanggalKegiatan, jammulaiKegiatan, jamselesaiKegiatan;

        public ViewHolder(View itemView) {
            super(itemView);
            idkasus = (TextView)itemView.findViewById(R.id.idKegiatan);
            namakegiatan = (TextView)itemView.findViewById(R.id.namaKegiatan);
            jenisKegiatan = (TextView)itemView.findViewById(R.id.jenisKegiatan);
            tanggalKegiatan = (TextView)itemView.findViewById(R.id.tanggalKegiatan);
            jammulaiKegiatan = (TextView)itemView.findViewById(R.id.jammulaiKegiatan);
            jamselesaiKegiatan = (TextView)itemView.findViewById(R.id.jamselesaiKegiatan);


        }
    }


    public GridAdapterKegiatan(List<ModelKegiatan> suratPerbaikanDataModelList) {
        this.mItems = suratPerbaikanDataModelList;
    }

    //    =================================2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view_kegiatan, viewGroup, false);

        return new ViewHolder(v);
    }
//======================================================3

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelKegiatan modelKegiatan= mItems.get(position);
        holder.idkasus.setText(modelKegiatan.getIdkegiatan());
        holder.namakegiatan.setText(modelKegiatan.getNama());
        holder.jenisKegiatan.setText(modelKegiatan.getJenis_kegiatan());
        holder.tanggalKegiatan.setText(modelKegiatan.getTanggal_kegiatan());
        holder.jammulaiKegiatan.setText(modelKegiatan.getJam_mulai());
        holder.jamselesaiKegiatan.setText(modelKegiatan.getJam_akhir());
    }
//=================================== 4


    @Override
    public int getItemCount() {

        return mItems.size();
    }



}
