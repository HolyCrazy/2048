package com.example.leeduo.a2048;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;

import java.util.Random;

/**
 * Created by LeeDuo on 2018/10/14.
 */

public  class GameUtils {

    private static WindowManager windowManager;
    private static Display display;
    private static Random random = new Random();
    private static Bitmap bitmap;
    private static int varX,varY;

    public static int getScreenWidth( Context context){
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        return display.getWidth();
    }
    public static int getScreenHeight( Context context){
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        return display.getHeight();
    }
    public static int randomNumber(int fromNumber,int toNumber){
        return random.nextInt(toNumber - fromNumber) + fromNumber;
    }
    public static int getBitmapWidth(int imageReDrawable,Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(),imageReDrawable);
        return  bitmap.getWidth();
    }
    public static int getBitmapHeight(int imageReDrawable,Context context){
        bitmap = BitmapFactory.decodeResource(context.getResources(),imageReDrawable);
        return  bitmap.getHeight();
    }
    public static Boolean isCollsion(float fromX1,float fromY1,float toX1,float toY1,float fromX2,float fromY2,float toX2,float toY2){
        if(fromX1>toX2){
            return false;
        }else if(toX1<fromX2){
            return false;
        }else if(fromY1 > toY2){
            return false;
        }else if(toY1 < fromY2){
            return false;
        }else{
            return true;
        }
    }

    public static int touchDirection(int touchFirstX,int touchFirstY,int touchLastX,int touchLastY){
        varX = touchFirstX - touchLastX;
        varY = touchFirstY - touchLastY;
        if(Math.abs(varX)<100&&Math.abs(varY)<100){
            return 0;
        }else{
            if(Math.abs(varX)>Math.abs(varY)){
                if(varX>=0){//left
                    return 1;
                }else if(varX<0){//right
                    return 2;
                }
            }else if(Math.abs(varX)<=Math.abs(varY)){
                if(varY>=0){//up
                    return 3;
                }else if(varY<0){//down
                    return 4;
                }
            }
        }
      return 0;
    }
}
