package nus.com.devlibs.base;

import android.app.Activity;
import android.app.Application;

import java.util.Stack;

import nus.com.devlibs.utils.LogUtils;

/**
 * 基础Application
 * Created by sun on 2016/7/6.
 */
public abstract class BaseApplication extends Application {

    /**
     * 初始化TAG
     */
    private  static String TAG=BaseApplication.class.getName();

    /*Activity堆*/
    private Stack<Activity> activityStack = new Stack<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.isDebug = true;


    }




    public void addActivity(final Activity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(curAT);
    }

    public void removeActivity(final Activity curAT) {
        if (null == activityStack) {
            activityStack = new Stack<Activity>();
        }
        activityStack.remove(curAT);
    }

    //获取最后一个Activity
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    //返回寨内Activity的总数
    public int howManyActivities() {
        return activityStack.size();
    }

    //关闭所有Activity
    public void finishAllActivities() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }





}
