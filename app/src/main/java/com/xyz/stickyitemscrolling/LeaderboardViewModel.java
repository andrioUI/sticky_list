package com.xyz.stickyitemscrolling;

import android.content.ClipData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardViewModel extends ViewModel {
    private MutableLiveData<List<PlayersDataItem>> itemsLiveData;

    public LiveData<List<PlayersDataItem>> getItemsLiveData() {
        if (itemsLiveData == null) {
            itemsLiveData = new MutableLiveData<>();
            loadItems(); // Load data from a data source (e.g., database, network)
        }
        return itemsLiveData;
    }

    private void loadItems() {
        // Simulated data loading
        List<PlayersDataItem> items = new ArrayList<>();
        items.add(new PlayersDataItem("1", "dsf", "34123pt", "0"));
        items.add(new PlayersDataItem("2", "drewt", "34123pt", "0"));
        items.add(new PlayersDataItem("3", "dsefwef", "34123pt", "0"));
        items.add(new PlayersDataItem("4", "dsdasfrgf", "34123pt", "0"));
        items.add(new PlayersDataItem("5", "erwrf", "34123pt", "0"));
        items.add(new PlayersDataItem("6", "wrgtrh", "34123pt", "0"));
        items.add(new PlayersDataItem("7", "qewr g", "34123pt", "0"));
        items.add(new PlayersDataItem("8", "dsawew wff", "34123pt", "0"));
        items.add(new PlayersDataItem("9", "ew grf", "34123pt", "0"));
        items.add(new PlayersDataItem("10", "dewrwe sf", "34123pt", "0"));
        items.add(new PlayersDataItem("11", "qwe qwd", "34123pt", "0"));
        items.add(new PlayersDataItem("12", "we wf", "34123pt", "0"));
        items.add(new PlayersDataItem("13", "d desf", "34123pt", "0"));
        items.add(new PlayersDataItem("14", "dwqer sf", "34123pt", "0"));
        items.add(new PlayersDataItem("15", "dewqe sf", "34123pt", "0"));
        items.add(new PlayersDataItem("16", "dw rsf", "34123pt", "0"));
        items.add(new PlayersDataItem("17", "fwef ev", "34123pt", "0"));
        items.add(new PlayersDataItem("18", "rtf rgre", "34123pt", "0"));
        items.add(new PlayersDataItem("19", "er efw", "34123pt", "0"));
        items.add(new PlayersDataItem("20", "wer efef", "34123pt", "0"));
        itemsLiveData.setValue(items);
    }
}
