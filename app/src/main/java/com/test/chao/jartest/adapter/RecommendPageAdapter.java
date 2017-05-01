package com.test.chao.jartest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chao.base_adapter.AnimationEnum;
import com.chao.base_adapter.BaseAdapter;
import com.chao.base_adapter.RLItemViewType;
import com.chao.base_adapter.SimpleItemType;
import com.chao.base_adapter.holder.ViewHolder;
import com.chao.chao.Cpublic;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.test.chao.jartest.R;
import com.test.chao.jartest.bean.BuDeJieContentListModel;
import com.test.chao.jartest.ui.activity.CommentDetails;
import com.test.chao.jartest.utils.PopWindowUtil;
import com.test.chao.jartest.view.CImageView;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * 首页列表适配器
 * Created by Chao on 2017/4/1.
 */

public class RecommendPageAdapter extends BaseAdapter<BuDeJieContentListModel> {
    public static final String TAG = "RecommendPageAdapter";


    private boolean isFullVideo;

    public RecommendPageAdapter(Context context, List<BuDeJieContentListModel> mDatas, int layoutId) {
        super(context, mDatas, layoutId);
        enableLoadAnimation(600, AnimationEnum.ALPHA);
    }

    public RecommendPageAdapter(Context context, List<BuDeJieContentListModel> mDatas, RLItemViewType<BuDeJieContentListModel> viewType) {
        super(context, mDatas, viewType);
        enableLoadAnimation(600, AnimationEnum.ALPHA);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBind(final ViewHolder holder, int viewType, int position, final BuDeJieContentListModel item) {
        CImageView iv_user_icon = holder.findViewById(R.id.iv_user_icon);
        holder.view(R.id.tv_user_name).setText(item.getU().getName());
        holder.view(R.id.tv_user_time).setText(item.getPasstime());
        holder.view(R.id.tv_content).setText(item.getText());
        holder.view(R.id.tv_forward).setText("顶 " + item.getForward());
        holder.view(R.id.tv_down).setText("踩 " + item.getDown());
        holder.view(R.id.tv_bookmark).setText("转 " + item.getBookmark());
        holder.view(R.id.tv_comment).setText("评 " + item.getComment());
        Glide.with(mContext).load(item.getU().getHeader().get(0)).centerCrop().placeholder(R.mipmap.load_error).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv_user_icon);
        holder.view(R.id.ll_onclick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CommentDetails.class);
                intent.putExtra("id", item.getId());
                mContext.startActivity(intent);
            }
        });
        if (viewType == 0) {

        } else if (viewType == 1) {
            ImageView iv_gif = holder.findViewById(R.id.iv_gif);
            Glide.with(mContext).load(item.getGif().getImages().get(0)).asGif()/*.override(item.getGif().getWidth(), item.getGif().getHeight()).centerCrop()*/.placeholder(R.mipmap.load_error).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv_gif);
        } else if (viewType == 2) {
            final StandardGSYVideoPlayer video_item_player = holder.findViewById(R.id.video_item_player);
            ImageView loadImage = new ImageView(mContext);
            loadImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(mContext).load(item.getVideo().getThumbnail().get(0)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(loadImage);
            //增加封面
            video_item_player.setThumbImageView(loadImage);
            //默认缓存路径
            video_item_player.setUp(item.getVideo().getVideo().get(0), true, null, "");
            //增加title
            video_item_player.getTitleTextView().setVisibility(View.GONE);
            //设置返回键
            video_item_player.getBackButton().setVisibility(View.GONE);
            //设置全屏按键功能
            video_item_player.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resolveFullBtn(video_item_player);
                }
            });
            video_item_player.setRotateViewAuto(true);
            video_item_player.setLockLand(true);
            video_item_player.setPlayTag(TAG);
            video_item_player.setShowFullAnimation(true);
            //循环
            //video_item_player.setLooping(true);
            video_item_player.setNeedLockFull(true);
            //video_item_player.setSpeed(2);
            video_item_player.setPlayPosition(position);
//            video_item_player.setStandardVideoAllCallBack(new SampleListener(){
//                @Override
//                public void onPrepared(String url, Object... objects) {
//                    super.onPrepared(url, objects);
//                    Debuger.printfLog("onPrepared");
//                    if (!video_item_player.isIfCurrentIsFullscreen()) {
//                        GSYVideoManager.instance().setNeedMute(true);
//                    }
//
//                }
//
//                @Override
//                public void onQuitFullscreen(String url, Object... objects) {
//                    super.onQuitFullscreen(url, objects);
//                    GSYVideoManager.instance().setNeedMute(true);
//                }
//
//                @Override
//                public void onEnterFullscreen(String url, Object... objects) {
//                    super.onEnterFullscreen(url, objects);
//                    GSYVideoManager.instance().setNeedMute(false);
//                }
//            });
        } else if (viewType == 3) {
            final ImageView iv_image = holder.findViewById(R.id.iv_image);
            Glide.with(mContext).load(item.getImage().getThumbnail_small().get(0)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv_image);
            iv_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View view = LayoutInflater.from(mContext).inflate(R.layout.pop_layout_image, null);
                    PhotoView photo_image = (PhotoView) view.findViewById(R.id.photo_image);
                    Glide.with(mContext).load(item.getImage().getBig().get(0)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(photo_image);
                    //Popupwindow popupwindow = new Popupwindow(mContext, view);
                    //popupwindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                    PopWindowUtil popupWindow = new PopWindowUtil.PopupWindowBuilder(mContext).enableBackgroundDark(true)
                            .setBgDarkAlpha(0.5f).setOutsideTouchable(true)
                            .setView(view)
                            .size(Cpublic.getWidth(), Cpublic.getHeight())
                            .create();
                    popupWindow.showAsDropDown(view, 0, 0, Gravity.CENTER);
                }
            });
        }
    }


    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(mContext, false, true);
        isFullVideo = true;
    }

    @Override
    protected RLItemViewType<BuDeJieContentListModel> offerRLItemViewType() {
        return new SimpleItemType<BuDeJieContentListModel>() {
            @Override
            public int getItemViewType(int position, BuDeJieContentListModel jokeListBean) {
                if (jokeListBean.getType().equals("text")) {
                    return 0;
                } else if (jokeListBean.getType().equals("gif")) {
                    return 1;
                } else if (jokeListBean.getType().equals("video")) {
                    return 2;
                } else if (jokeListBean.getType().equals("image")) {
                    return 3;
                }
                return 0;
            }

            @Override
            public int getLayoutId(int viewType) {
                if (viewType == 0) {
                    return R.layout.item_budejie_type_text;
                } else if (viewType == 1) {
                    return R.layout.item_budejie_type_gif;
                } else if (viewType == 2) {
                    return R.layout.item_budejie_type_video;
                } else if (viewType == 3) {
                    return R.layout.item_budejie_type_image;
                }
                return R.layout.item_budejie_type_text;
            }
        };
    }
}
