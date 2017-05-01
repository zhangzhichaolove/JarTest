package com.test.chao.jartest.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.chao.base.LoadImage;
import com.chao.base_adapter.AnimationEnum;
import com.chao.base_adapter.BaseAdapter;
import com.chao.base_adapter.RLItemViewType;
import com.chao.base_adapter.holder.ViewHolder;
import com.test.chao.jartest.R;
import com.test.chao.jartest.bean.JokeListBean;
import com.test.chao.jartest.data.UserInfo;

import org.xutils.x;

import java.util.List;

/**
 * 首页列表适配器
 * Created by Chao on 2017/4/1.
 */

public class HomePageAdapter extends BaseAdapter<JokeListBean> {


    public HomePageAdapter(Context context, List<JokeListBean> mDatas, int layoutId) {
        super(context, mDatas, layoutId);
        enableLoadAnimation(600, AnimationEnum.RIGHT);
    }

    public HomePageAdapter(Context context, List<JokeListBean> mDatas, RLItemViewType<JokeListBean> viewType) {
        super(context, mDatas, viewType);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBind(ViewHolder holder, int viewType, int position, JokeListBean item) {
        holder.view(R.id.tv_home_page).setText(item.getContent()).setTextColor(ContextCompat.getColor(mContext, R.color.DeepPink)).setTextSize(16);
        holder.view(R.id.tv_send_time).setText(item.getUpdatetime());
        x.image().bind((ImageView) holder.findViewById(R.id.iv_user_icon), UserInfo.userIcon[position % UserInfo.userIcon.length], LoadImage.LoadCircularImage());
    }
}
