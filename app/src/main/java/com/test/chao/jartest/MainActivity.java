package com.test.chao.jartest;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.base.utils.KeyDownUtils;
import com.chao.anim.ILayoutAnimationController;
import com.chao.base.BaseActivity;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.test.chao.jartest.ui.fragment.TabFragment_Home;
import com.test.chao.jartest.ui.fragment.TabFragment_Recommend;

import org.xutils.view.annotation.ViewInject;

public class MainActivity extends BaseActivity {
    @ViewInject(R.id.tabs)
    TabLayout tabs;
    @ViewInject(R.id.viewpager)
    ViewPager viewpager;
    private String[] mTitles = new String[]{"推荐", "文字", "图文", "动图", "视频", "其他"};

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initTopBar(View layout, TextView finish, TextView title, View... other) {
        layout.setVisibility(View.GONE);
    }


    @Override
    public void initView() {
        mConfig.setSlidable(false);
    }

    @Override
    public void initData() {
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(adapter);

        tabs.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(0);
        viewpager.setOffscreenPageLimit(1);
        TabLayout.TabLayoutOnPageChangeListener listener =
                new TabLayout.TabLayoutOnPageChangeListener(tabs);
        viewpager.addOnPageChangeListener(listener);

        ILayoutAnimationController.setLayoutAnimation(
                (ViewGroup) findViewById(R.id.tabs),
                R.anim.slide_left_in,
                0.8f,
                ILayoutAnimationController.IndexAlgorithm.INDEXSIMPLEPENDULUM);
    }


    @Override
    public void initListener() {
//        startIntent(TestActivity.class);
//        startService(new Intent(this, MessageService.class));
//        startService(new Intent(this, GuardService.class));
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            startService(new Intent(this, JobAwakenService.class));
//        }
    }

    class MyAdapter extends FragmentPagerAdapter {
        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return position == 0 ? TabFragment_Recommend.newInstance() : TabFragment_Home.newInstance();
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    /**
     * 返回键退出监听
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return KeyDownUtils.BlackExit(this, keyCode, "再按一次退出程序!", 1500);
    }


    @Override
    public void onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }


}
