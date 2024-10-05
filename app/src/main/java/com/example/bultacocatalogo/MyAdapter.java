package com.example.bultacocatalogo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<Bultaco> mBultacos;
    private Context mContext;

    public MyAdapter(ArrayList<Bultaco> mBultacos, Context mContext) {
        this.mBultacos = mBultacos;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(mBultacos.get(position).getUrlImage())
                .fit()
                .centerCrop()
                .into(holder.imageView);
        holder.textType.setText(mBultacos.get(position).getType());
        holder.textNickName.setText(mBultacos.get(position).getNickname());
        holder.textAge.setText(String.valueOf(mBultacos.get(position).getAge()));
        holder.textBirthYear.setText(String.valueOf(mBultacos.get(position).getBithYear()));
        holder.textVersions.setText(mBultacos.get(position).getVersionsBultacos());


        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("type", mBultacos.get(position).getType());
                intent.putExtra("nickname", mBultacos.get(position).getNickname());
                intent.putExtra("age", mBultacos.get(position).getAge());
                intent.putExtra("birthyear", mBultacos.get(position).getBithYear());
                intent.putExtra("versions", mBultacos.get(position).getVerions());
                intent.putExtra("desc", mBultacos.get(position).getDesc());

                intent.putExtra("urlImage",mBultacos.get(position).getUrlImage());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mBultacos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textType;
        private TextView textNickName;
        private TextView textAge;
        private TextView textBirthYear;
        private TextView textVersions;


        ConstraintLayout rowLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //HOOKS a traves del itemView
            imageView = itemView.findViewById(R.id.imageView);
            textType = itemView.findViewById(R.id.textType);
            textNickName = itemView.findViewById(R.id.textNickName);
            textAge = itemView.findViewById(R.id.textAge);
            textBirthYear = itemView.findViewById(R.id.textBirthYear);
            textVersions = itemView.findViewById(R.id.textVersions);


            rowLayout = itemView.findViewById(R.id.rowLayout);

        }





    }


}
