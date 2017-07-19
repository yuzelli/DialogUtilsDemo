package com.example.yuzelli.dialogutilsdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);context = this;
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMyDiaLog();
            }
        });
    }

    private void showMyDiaLog() {
        new DialogUtils(MainActivity.this, R.layout.dialog_view) {
            @Override
            public void initLayout(ViewHepler hepler, final Dialog dialog) {
                //加载文字
                hepler.setText(R.id.tv_close, "提示：");
                hepler.setText(R.id.tv_hint, "内容test内容test内容test内容test内容test");

                // 加载Resource图片
                hepler.setImageResource(R.id.img_cancel,R.drawable.ic_cancel);
                //加载网络图片
                hepler.setImageByUrl(R.id.img_content,"http://img3.imgtn.bdimg.com/it/u=2730707097,3811913056&fm=26&gp=0.jpg");

                //加载点击事件
                hepler.setViewClick(R.id.img_cancel, new ViewHepler.ViewClickCallBack() {
                    @Override
                    public void doClickAction(View v) {
                        dialog.dismiss();
                    }
                });
                hepler.setViewClick(R.id.tv_cancel, new ViewHepler.ViewClickCallBack() {
                    @Override
                    public void doClickAction(View v) {
                        dialog.dismiss();
                    }
                });
                hepler.setViewClick(R.id.tv_ok, new ViewHepler.ViewClickCallBack() {
                    @Override
                    public void doClickAction(View v) {
                        Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
    }
}
