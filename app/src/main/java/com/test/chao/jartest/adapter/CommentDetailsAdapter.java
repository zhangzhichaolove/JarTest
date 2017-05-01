package com.test.chao.jartest.adapter;

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chao.base_adapter.BaseAdapter;
import com.chao.base_adapter.holder.ViewHolder;
import com.test.chao.jartest.R;
import com.test.chao.jartest.bean.CommentDetailsDataModel;
import com.test.chao.jartest.view.CImageView;

import java.util.List;

/**
 * 创建日期：2017/5/1 on 17:47
 * 描述:
 * 作者:张智超 Chao
 */
public class CommentDetailsAdapter extends BaseAdapter<CommentDetailsDataModel> {


    public CommentDetailsAdapter(Context context, List<CommentDetailsDataModel> mDatas, int layoutId) {
        super(context, mDatas, layoutId);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBind(ViewHolder holder, int viewType, int position, CommentDetailsDataModel item) {
        CImageView iv_user_icon = holder.findViewById(R.id.iv_user_icon);
        holder.view(R.id.tv_user_name).setText(item.getUser().getUsername());
        holder.view(R.id.tv_content).setText(item.getContent());
        holder.view(R.id.tv_forward).setText("顶 " + item.getLike_count());
        holder.view(R.id.tv_down).setText("踩 " + "0");
        Glide.with(mContext).load(item.getUser().getProfile_image()).centerCrop().placeholder(R.mipmap.load_error).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv_user_icon);
    }
}
