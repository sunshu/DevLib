package nus.com.devlibs;

import android.content.Context;
import android.content.res.Resources;

import nus.com.devlibs.base.BaseApplication;

/**
 * Created by sun on 2016/7/13.
 */
public class AppContext extends BaseApplication {
    static Context _context;
    static Resources _resource;

    @Override
    public void onCreate() {
        super.onCreate();
        _context = getApplicationContext();
        _resource=getResources();

    }


    public static  Context getContext(){
        return _context;
    }

}
