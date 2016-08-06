package com.hotbitmapgg.ohmybilibili.adapter.liveholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LiveEntranceViewHolder extends RecyclerView.ViewHolder
{

    @Bind(R.id.live_entrance_title)
    public TextView title;

    @Bind(R.id.live_entrance_image)
    public ImageView image;

    public LiveEntranceViewHolder(View itemView)
    {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}