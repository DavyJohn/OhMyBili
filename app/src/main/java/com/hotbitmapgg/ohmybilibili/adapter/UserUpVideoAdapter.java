package com.hotbitmapgg.ohmybilibili.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hotbitmapgg.ohmybilibili.R;
import com.hotbitmapgg.ohmybilibili.adapter.base.AbsRecyclerViewAdapter;
import com.hotbitmapgg.ohmybilibili.model.user.UserVideoItem;
import com.hotbitmapgg.ohmybilibili.network.UrlHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hcc on 16/8/4 14:12
 * 100332338@qq.com
 */
public class UserUpVideoAdapter extends AbsRecyclerViewAdapter
{

    private List<UserVideoItem> parts = new ArrayList<>();

    public UserUpVideoAdapter(RecyclerView recyclerView, List<UserVideoItem> parts)
    {

        super(recyclerView);
        this.parts = parts;
    }

    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.card_item_user_up_video, parent, false));
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position)
    {

        if (holder instanceof ItemViewHolder)
        {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            UserVideoItem item = parts.get(position);
            String pic = item.pic;
            String play = item.play;
            int video_review = item.video_review;
            String title = item.title;

            Picasso.with(getContext()).load(UrlHelper.getClearVideoPreviewUrl(pic)).placeholder(R.drawable.bili_default_image_tv).into(itemViewHolder.mVideoPic);
            itemViewHolder.mVideoTitle.setText(title);
            itemViewHolder.mVideoPlayNum.setText(play);
            itemViewHolder.mVideoReviewNum.setText(video_review + "");
        }

        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount()
    {

        return parts.size();
    }

    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder
    {

        ImageView mVideoPic;

        TextView mVideoTitle;

        TextView mVideoPlayNum;

        TextView mVideoReviewNum;

        public ItemViewHolder(View itemView)
        {

            super(itemView);

            mVideoPic = $(R.id.user_video_pic);
            mVideoTitle = $(R.id.user_video_title);
            mVideoPlayNum = $(R.id.user_play_num);
            mVideoReviewNum = $(R.id.user_review_count);
        }
    }
}
