package com.fedming.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 一个基于Glide的图片加载Demo，可以加载圆形、圆角矩形、反转、虚化的简单实例
 * 更多 Transformations 效果参考：https://github.com/wasabeef/glide-transformations
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Button circleButton;
    private Button roundButton;
    private Button blurButton;
    private Button rotateButton;

    private final String imgUrl = "http://img4.3lian.com/img2005/07/14/148.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        circleButton = (Button) findViewById(R.id.circle_button);
        roundButton = (Button) findViewById(R.id.round_button);
        blurButton = (Button) findViewById(R.id.blur_button);
        rotateButton = (Button) findViewById(R.id.rotate_button);

        rotateButton.setOnClickListener(this);
        blurButton.setOnClickListener(this);
        circleButton.setOnClickListener(this);
        roundButton.setOnClickListener(this);

        // Glide基本功能
        Glide.with(this)                //RequestManager对象
                .load(imgUrl)           //需要加载的图片资源
                .thumbnail(0.1f)        //缩略图显示原始图像的10%的大小
                .placeholder(R.mipmap.loading) //占位图
                .crossFade()            //淡入淡出动画
//                .error()              //设置错误时加载图片
//                .dontAnimate()        //取消动画
//                .override(600, 200)   //重新改变图片大小
//                .centerCrop()         //（fitCenter）图片缩放选项
//                .transform( new BlurTransformation( this ) ) //图形转换
                .into(imageView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.circle_button:
                Glide.with(this)
                        .load(imgUrl)
                        .placeholder(R.mipmap.loading)
                        .transform(new CircleTransform(this))
                        .crossFade()
                        .into(imageView);
                break;

            case R.id.round_button:
                Glide.with(this)
                        .load(imgUrl)
                        .placeholder(R.mipmap.loading)
                        .transform(new RoundTransform(this))
                        .crossFade()
                        .into(imageView);
                break;

            case R.id.blur_button:
                Glide.with(this)
                        .load(imgUrl)
                        .placeholder(R.mipmap.loading)
                        .transform(new BlurTransformation(this))
                        .crossFade()
                        .into(imageView);
                break;

            case R.id.rotate_button:
                Glide.with(this)
                        .load(imgUrl)
                        .placeholder(R.mipmap.loading)
                        .transform(new RotateTransformation(this))
                        .crossFade()
                        .into(imageView);
                break;
            default:
                break;
        }
    }
}
