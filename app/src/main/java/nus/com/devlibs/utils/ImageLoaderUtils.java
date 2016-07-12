package nus.com.devlibs.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import nus.com.devlibs.R;


public class ImageLoaderUtils {

    public static void display(Context context, ImageView imageView, String url, int placeholder, int error) {
        if(imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).placeholder(placeholder)
                .error(error).crossFade().into(imageView);
    }

    public static void display(Context context, ImageView imageView, String url) {
        if(imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(context).load(url).into(imageView);


//        Glide.with(context).load(url).placeholder(R.drawable.loading)
//                .error(R.drawable.loadfail).crossFade().into(imageView);
    }


}