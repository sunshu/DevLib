package nus.com.devlibs.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {
        public static void with(Context context, String imageUrl, ImageView imageView) {
        Picasso picasso = Picasso.with(context);
        picasso.load(imageUrl).into(imageView);
    }

    public static void withRes(Context context, int Res, ImageView imageView) {
        Picasso picasso = Picasso.with(context);
        Picasso.with(context).load(Res).into(imageView);

    }

    public static  void with(Context context, String imageUrl, ImageView imageView,int pResId,int errorResId) {
        Picasso picasso = Picasso.with(context);
        picasso.load(imageUrl).placeholder(pResId).error(errorResId).into(imageView);
    }






    }