package me.appa.materialdesign.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.appa.materialdesign.R;
import me.appa.materialdesign.activity.Main2Activity;
import me.appa.materialdesign.widget.DividerItemDecoration;

/**
 * Created by niuxm on 2015/11/11.
 */
public class FirstFragment extends BaseFragment {
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview, container, false);
        ContentAdapter contentAdapter = new ContentAdapter();

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.list_refresh);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setAdapter(contentAdapter);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));
        return recyclerView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.first_fragment_item, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity(), Main2Activity.class));
                }
            });
        }
    }


    public class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 100;
        }


        @Override
        public int getItemViewType(int position) {

            return super.getItemViewType(position);
        }
    }

}
