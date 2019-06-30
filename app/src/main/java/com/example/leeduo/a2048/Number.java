package com.example.leeduo.a2048;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by LeeDuo on 2018/10/21.
 */

public class Number {
    private int X,Y,LineWidth,number;
    private Paint paint;
    public Number(int lineWidth){
        LineWidth = lineWidth;
        paint = new Paint();
        paint.setTextSize(80);
        paint.setTypeface(PlayState.getTypeface());
    }

    public void setLocation(int x,int y) {
        X = x;
        Y = y;
    }

    public int randomNumber(){
        number = GameUtils.randomNumber(-5,15);
        if(number>0){
            return 2;
        }else{
            return 4;
        }

    }

public void drawNumber(Canvas canvas,int number){
       switch (number){
           case 2:
               draw2(canvas);
               break;
           case 4:
               draw4(canvas);
               break;
           case 8:
               draw8(canvas);
               break;
           case 16:
               draw16(canvas);
               break;
           case 32:
               draw32(canvas);
               break;
           case 64:
               draw64(canvas);
               break;
           case 128:
               draw128(canvas);
               break;
           case 256:
               draw256(canvas);
               break;
           case 512:
               draw512(canvas);
               break;
           case 1024:
               draw1024(canvas);
               break;
           case 2048:
               draw2048(canvas);
               break;
           case 4096:
               draw4096(canvas);
               break;
           case 8192:
               draw8192(canvas);
               break;
           case 16384:
               draw16384(canvas);
               break;
           case 32768:
               draw32768(canvas);
               break;
       }
}




    public void draw2(Canvas canvas){
        paint.setColor(Color.parseColor("#ffc8e7"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("2",X-20+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw4(Canvas canvas){
        paint.setColor(Color.parseColor("#ffec8d"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("4",X-20+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw8(Canvas canvas){
        paint.setColor(Color.parseColor("#46ffdc"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("8",X-20+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw16(Canvas canvas){
        paint.setColor(Color.parseColor("#f150b8"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("16",X-45+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw32(Canvas canvas){
        paint.setColor(Color.parseColor("#ff2d7a"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("32",X-45+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw64(Canvas canvas){
        paint.setColor(Color.parseColor("#ff4542"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("64",X-45+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw128(Canvas canvas){
        paint.setColor(Color.parseColor("#46ffa0"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("128",X-65+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw256(Canvas canvas){
        paint.setColor(Color.parseColor("#ffbd44"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("256",X-65+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw512(Canvas canvas){
        paint.setColor(Color.parseColor("#ffdc27"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("512",X-65+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw1024(Canvas canvas){
        paint.setColor(Color.parseColor("#ffeb49"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("1024",X-85+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw2048(Canvas canvas){
        paint.setColor(Color.parseColor("#ffff50"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("2048",X-85+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw4096(Canvas canvas){
        paint.setColor(Color.parseColor("#d0ff91"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("4096",X-85+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw8192(Canvas canvas){
        paint.setColor(Color.parseColor("#4bffa5"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(80);
        canvas.drawText("8192",X-85+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw16384(Canvas canvas){
        paint.setColor(Color.parseColor("#36ffc6"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(70);
        canvas.drawText("16384",X-92+LineWidth/2,Y+25+LineWidth/2,paint);
    }
    public void draw32768(Canvas canvas){
        paint.setColor(Color.parseColor("#11ffec"));
        canvas.drawRect(X+5,Y+5,X+LineWidth-5,Y+LineWidth-5,paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(70);
        canvas.drawText("32768",X-92+LineWidth/2,Y+25+LineWidth/2,paint);
    }
}
