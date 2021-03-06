package com.example.vhiphop.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.vhiphop.R;

/*
 *作者：created by 影子 on 2020/5/2 19:30
 *邮箱：1723928492@qq.com
 */
public class ImageUtils {

    private static final float VER_POSTER_RATIO = 0.73f;
    private static final float HOR_POSTER_RATIO = 1.5f;
    public static void disPlayImage(ImageView view,String url,int width,int height){
        if(view != null && url != null && width > 0 && height >0){

            if(width > height){
                Glide.with(view.getContext())
                        .load(url)//图片加载url
                        .error(R.drawable.ic_loading_hor)//出错时使用默认图
                        .fitCenter()//横图不会截图 centCrop会截大图 不会自适应
                        .override(height,width)//重写宽高
                        .into(view);//加载imageview上
            }else{
                Glide.with(view.getContext())
                        .load(url)//图片加载url
                        .error(R.drawable.ic_loading_hor)//出错时使用默认图
                        .centerCrop()//设置图片居中
                        .override(width,height)//重写宽高
                        .into(view);//加载imageview上
            }
        }
    }

    /**
     * 让图片获得最佳比例
     * @param context
     * @param columns
     * @return
     */
    public static Point getVerPostSize(Context context,int columns){
        int width = getScreenWidthPixel(context)/columns;
        width = width - (int) context.getResources().getDimension(R.dimen.dimen_8dp);
        int height = Math.round((float)width/VER_POSTER_RATIO);
        Point point = new Point();
        point.x = width;
        point.y = height;
        return point;
    }

    public static Point getHorPostSize(Context context,int columns){
        int width = getScreenWidthPixel(context)/columns;
        width = width - (int) context.getResources().getDimension(R.dimen.dimen_8dp);
        int height = Math.round((float)width/HOR_POSTER_RATIO);
        Point point = new Point();
        point.x = width;
        point.y = height;
        return point;
    }
    public static int getScreenWidthPixel(Context context){//获取屏幕宽度
        WindowManager wm = (WindowManager)context.getSystemService(context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        return width;
    }
}
