package com.unsc.a117.broadcastlogin;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

/*自定义一个类管理活动*/
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity (Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishall(){
        //遍历一下活动
        for(Activity activity : activities){
            //如果活动发现没关闭的就给丫的关了
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
