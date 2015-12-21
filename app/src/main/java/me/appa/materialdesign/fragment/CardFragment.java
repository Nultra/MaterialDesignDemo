package me.appa.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.appa.materialdesign.R;

/**
 * Created by niuxm on 2015/11/12.
 */
public class CardFragment  extends BaseFragment{

    private RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recyclerview,container,false);
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler);


        ContentAdapter contentAdapter = new ContentAdapter();
        mRecycler.setAdapter(contentAdapter);
        mRecycler.setHasFixedSize(true);
//        recyclerView.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
//        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setLayoutManager(gridLayoutManager);


        return mRecycler;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }

    }


    public class ContentAdapter extends RecyclerView.Adapter{

        private List<String> data = new ArrayList<>();
        private List<String> dataList = new ArrayList<>();
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_cardview, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            //设置item中view的点击事件
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }



}
