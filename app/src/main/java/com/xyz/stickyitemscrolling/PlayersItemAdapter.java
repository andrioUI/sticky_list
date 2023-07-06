package com.xyz.stickyitemscrolling;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlayersItemAdapter
        extends RecyclerView.Adapter<PlayersItemAdapter.GoldRankingItemViewHolder> {
    private List<PlayersDataItem> items;

    public PlayersItemAdapter(List<PlayersDataItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public GoldRankingItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.players_point_item, parent, false);
        return new GoldRankingItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GoldRankingItemViewHolder holder, int position) {
        PlayersDataItem item = items.get(position);
        holder.tvPoints.setText(item.getPoints());
        holder.tvName.setText(item.getName());
        holder.tvRank.setText(item.getRank());
        holder.tvPriceMoney.setText(item.getPriceMoney());

    }


    @Override
    public int getItemCount() {
        return items.size();
    }


//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView tvRank;
//        public TextView tvName;
//        public TextView tvPoints;
//        public TextView tvPriceMoney;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvRank = itemView.findViewById(R.id.tvRank);
//            tvName = itemView.findViewById(R.id.tvName);
//            tvPoints = itemView.findViewById(R.id.tvPoints);
//            tvPriceMoney = itemView.findViewById(R.id.tvPriceMoney);
//        }
//    }

    public static class GoldRankingItemViewHolder extends RecyclerView.ViewHolder {

        public TextView tvRank;
        public TextView tvName;
        public TextView tvPoints;
        public TextView tvPriceMoney;
        public GoldRankingItemViewHolder(@NonNull View itemView){
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvName = itemView.findViewById(R.id.tvName);
            tvPoints = itemView.findViewById(R.id.tvPoints);
            tvPriceMoney = itemView.findViewById(R.id.tvPriceMoney);
        }

    }

}
