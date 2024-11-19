package com.example.bultacocatalogo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bultacocatalogo.model.Bultaco;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private ArrayList<Bultaco> mBultacos;
    private Context mContext; //Al tenir vistes li hem de afegir el context, per mostrar la fila al layout etc
    private List<Bultaco> fullList;


    public MyAdapter(ArrayList<Bultaco> mBultacos, Context mContext) {
        this.mBultacos = mBultacos;
        this.mContext = mContext;
        this.fullList = new ArrayList<>(mBultacos);
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext); //Inflate vol dir crear (crear un layout)
        View view = inflater.inflate(R.layout.my_row, parent, false); //true per si estes dins un altre view com un spinner.

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(mBultacos.get(position).getUrlImage()) //Aqui android ja sap quin has clicat, i amb mBultacos agafes de la classe main.
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

    public void filter (String searchText){
        int length = searchText.length();
        if (length == 0){
            mBultacos.clear();
            mBultacos.addAll(fullList);
        }else{
            //Filter
            List<Bultaco> collection = mBultacos
                    .stream()
                    .filter(
                            i -> i.getType().toLowerCase().contains(searchText.toLowerCase())
                            || i.getNickname().toLowerCase().contains(searchText.toLowerCase())
                    )
                    .collect(Collectors.toList());
            mBultacos.clear();
            mBultacos.addAll(collection);
        }
        notifyDataSetChanged();
    }


}
