package com.example.d1mys1klapo4ka.studentholder.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.d1mys1klapo4ka.studentholder.R;
import com.example.d1mys1klapo4ka.studentholder.activity.ThirdActivity;
import com.example.d1mys1klapo4ka.studentholder.adapter.RecyclerViewAdapter;
import com.example.d1mys1klapo4ka.studentholder.model.Models;
import com.example.d1mys1klapo4ka.studentholder.sqLite.CreateSQLite;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by d1mys1klapo4ka on 16.05.2017.
 */

public class FragmentRecyclerView extends Fragment {
    private RecyclerView rvInitStudent;
    public FragmentRecyclerView(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_view_activity, container, false);

        onStart(view);

        return view;
    }

    public void onStart(View view) {
        super.onStart();
        rv(view);
    }

    private void rv(View v){
        rvInitStudent = (RecyclerView) v.findViewById(R.id.rv_init_student);
        //rvInitStudent.getChildItemId(v);
        rvInitStudent.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvInitStudent.setHasFixedSize(true);
        rvInitStudent.setAdapter(new RecyclerViewAdapter(getActivity(), (ArrayList<Models>) worker(getContext()),onClickListener));
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         int position = rvInitStudent.getChildAdapterPosition(v);
            Intent intent = new Intent(getActivity(), ThirdActivity.class);
            intent.putExtra("worker", worker(getContext()).get(position));
            intent.putExtra("name", worker(getContext()).get(position).getName().toString());
            intent.putExtra("secondName", worker(getContext()).get(position).getSecondName().toString());
            intent.putExtra("Birhday", worker(getContext()).get(position).getBirhday().toString());
            intent.putExtra("id", worker(getContext()).get(position).getId());
            startActivity(intent);
        }
    };

    private List<Models> worker(Context context) {

        CreateSQLite db = new CreateSQLite(context);
        List<Models> models = db.getAllModels();
        for (Models cn : models) {
            String log = "Id: "+cn.getId()+" ,Name: " + cn.getName() + " ,SecondName: "
                    + cn.getSecondName() + " ,B-DAY: " + cn.getBirhday();
            Log.e("@@@@@@@", log);
        }
        return models;
    }

}
