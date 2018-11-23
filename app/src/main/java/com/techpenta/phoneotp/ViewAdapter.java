package com.techpenta.phoneotp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {


    Context context;
    User[] data;
    public ViewAdapter(Context context,User[] data) {

        this.context=context;
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.itemlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user=data[position];
        holder.txtview.setText(user.getLogin());
//Loading image from url into imageView
        Glide.with(holder.imgview.getContext())
                .load(user.getAvatarUrl())
                .into(holder.imgview);

        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin()+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, user.getLogin()+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtview;
        ImageView imgview;
    public ViewHolder(View itemView) {
        super(itemView);

        txtview=(TextView)itemView.findViewById(R.id.title);
        imgview=(ImageView)itemView.findViewById(R.id.thumbnail);
    }
}

}
