package com.xyz.stickyitemscrolling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PlayersItemAdapter adapter;
    private LeaderboardViewModel itemViewModel;

    private ArrayList<PlayersDataItem> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvPlayersList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayersItemAdapter(items);
        recyclerView.setAdapter(adapter);

        itemViewModel = new ViewModelProvider(this).get(LeaderboardViewModel.class);
        itemViewModel.getItemsLiveData().observe(this, items -> {

            this.items.clear();
            this.items.addAll(items);

            adapter.notifyDataSetChanged();
            // Create and attach the fake item decoration

//            View itemView = LayoutInflater.from(this).inflate(R.layout.players_sticky_item, recyclerView, false);
//            PlayersItemAdapter.GoldRankingItemViewHolder viewHolder = new PlayersItemAdapter.GoldRankingItemViewHolder(itemView);
////            PlayersItemAdapter.GoldRankingItemViewHolder positionOfWinner = (PlayersItemAdapter.GoldRankingItemViewHolder) recyclerView.findViewHolderForAdapterPosition(5);
//            View stickyView = viewHolder.itemView; // Get the sticky view from the view holder
//            StickyItemCustomDecor stickyItemDecoration = new StickyItemCustomDecor(stickyView, 5);
//            recyclerView.addItemDecoration(stickyItemDecoration);

        });

    }
}