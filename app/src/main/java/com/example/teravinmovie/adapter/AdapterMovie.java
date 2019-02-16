package com.example.teravinmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teravinmovie.MainActivity;
import com.example.teravinmovie.R;
import com.example.teravinmovie.model.DataItem;
import com.example.teravinmovie.model.ResultsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {

    Context ctx;

    List<DataItem> ListDataMovie;

    public AdapterMovie(Context ctx, List<DataItem> listDataMovie) {
        this.ctx = ctx;
        ListDataMovie = listDataMovie;
    }


    @NonNull
    @Override
    public AdapterMovie.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_movie, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovie.ViewHolder viewHolder, int i) {

        final String judul = ListDataMovie.get(i).getJudul();
        final String tanggal = ListDataMovie.get(i).getTanggal();
        final String image = ListDataMovie.get(i).getGambar();
        final String ratting = ListDataMovie.get(i).getRating();

        Picasso.get().load(image).into(viewHolder.imageView);
        viewHolder.tvjudul.setText(judul);
        viewHolder.tvtanggal.setText(tanggal);
        viewHolder.tvratting.setText(ratting);

    }

    @Override
    public int getItemCount() {
        if (ListDataMovie == null)
            return 0;
        return ListDataMovie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvjudul, tvtanggal,tvratting;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvjudul = itemView.findViewById(R.id.tv_judul_movie);
            tvtanggal = itemView.findViewById(R.id.tv_tgl_movie);
            imageView = itemView.findViewById(R.id.iv_movie);
            tvratting = itemView.findViewById(R.id.tv_ratting);
        }
    }
}
