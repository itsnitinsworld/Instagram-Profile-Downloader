package com.storyPost.PhotoVideoDownloader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.storyPost.PhotoVideoDownloader.R;
import com.storyPost.PhotoVideoDownloader.data.localpojo.DrawerMenuPojo;

public class DownloadHistroyAdapter extends RecyclerView.Adapter<DownloadHistroyAdapter.ItemViewHolder> {

    private Context context;
    private List<DrawerMenuPojo> items;


    public DownloadHistroyAdapter(Context context) {

        this.context = context;
        this.items = new ArrayList<>();

    }

    public void setMenu(List<DrawerMenuPojo> itemsList) {
        items.clear();
        items.addAll(itemsList);
        notifyDataSetChanged();

    }

    public interface EventListener {
        void onItemClick(DrawerMenuPojo item);
    }

    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public DrawerMenuPojo getItemData(int position) {
        return items.get(position);
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_profile, parent, false);

        return new ItemViewHolder(itemLayoutView);
    }


    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {


    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;


        public ItemViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);


        }

    }


}




