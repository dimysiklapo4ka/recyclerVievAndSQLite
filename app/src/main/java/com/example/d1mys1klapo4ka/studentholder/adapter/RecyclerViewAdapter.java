package com.example.d1mys1klapo4ka.studentholder.adapter;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.d1mys1klapo4ka.studentholder.R;

import com.example.d1mys1klapo4ka.studentholder.model.Models;

import java.util.ArrayList;

/**
 * Created by d1mys1klapo4ka on 16.05.2017.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter <RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Models> studentsInit;
    private View.OnClickListener onClickListener;

    public RecyclerViewAdapter(Context context, ArrayList<Models> studentsInit ){

        this.context = context;
        this.studentsInit = studentsInit;
    }

    public RecyclerViewAdapter(Context context, ArrayList<Models> studentsInit, View.OnClickListener onClickListener) {
        this.context = context;
        this.studentsInit = studentsInit;
        this.onClickListener = onClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder_activity, parent , false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Models models = studentsInit.get(position);

        holder.tvName.setText(models.getName());
        holder.tvSecondName.setText(models.getSecondName());
        holder.tvBidhday.setText(models.getBirhday());
        holder.tvId.setText("" + models.getId());

        //*******************FIRST WAY*******************
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, SecondActivity.class);
//                intent.putExtra("student", studentsInit.get(position));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return studentsInit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvSecondName, tvBidhday, tvId;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
            tvSecondName = (TextView)itemView.findViewById(R.id.tv_second_name);
            tvBidhday = (TextView)itemView.findViewById(R.id.tv_birhday);
            tvId = (TextView)itemView.findViewById(R.id.tv_id);
            cardView = (CardView)itemView.findViewById(R.id.cv_item);

        }

    }
}
