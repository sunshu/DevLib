package nus.com.devlibs.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;
import nus.com.devlibs.AppContext;
import nus.com.devlibs.R;


public class FirstActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_start;
    private TextView tv_skip;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        context = AppContext.getContext();
        BGABanner banner = (BGABanner) findViewById(R.id.banner_guide_content);
        btn_start = (Button) findViewById(R.id.btn_start);
        tv_skip = (TextView) findViewById(R.id.tv_skip);
        btn_start.setOnClickListener(this);
        tv_skip.setOnClickListener(this);
        btn_start.setVisibility(View.GONE);
//        tv_skip.setVisibility(View.GONE);

        List<View> views = new ArrayList<View>();
        views.add(BGABannerUtil.getItemImageView(this,R.drawable.newer01));
        views.add(BGABannerUtil.getItemImageView(this,R.drawable.newer02));
        views.add(BGABannerUtil.getItemImageView(this,R.drawable.newer03));
        views.add(BGABannerUtil.getItemImageView(this,R.drawable.newer04));
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position != 3){
                    tv_skip.setVisibility(View.VISIBLE);
                    btn_start.setVisibility(View.GONE);
                }else {
                    tv_skip.setVisibility(View.GONE);
                    btn_start.setVisibility(View.VISIBLE);
                }
                }




            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        banner.setData(views);


//        BGABanner.Adapter adapter = new BGABanner.Adapter() {
//            @Override
//            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
//
//                ((ImageView) view).setImageResource((int) model);
//
//            }
//        };
//        banner.setData(Arrays.asList(R.drawable.newer01, R.drawable.newer02, R.drawable.newer03, R.drawable.newer04), null);
//        banner.setAdapter(adapter);








    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context,MainActivity.class);
        startActivity(intent);

    }
}
