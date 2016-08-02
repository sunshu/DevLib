package nus.com.devlibs.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nus.com.devlibs.R;

public class ToolsActivity extends AppCompatActivity {

    @BindView(R.id.ll_dialog1)
    LinearLayout ll_dialog1;
    @BindView(R.id.ll_dialog2)
    LinearLayout ll_dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        getSupportActionBar().setTitle("我的工具 ");
        ButterKnife.bind(this);



    }

    @OnClick(R.id.ll_dialog1)
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ll_dialog1:{
                break;
            }
        }
    }


}
