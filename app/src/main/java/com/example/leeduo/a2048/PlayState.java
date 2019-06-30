package com.example.leeduo.a2048;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

/**
 * Created by LeeDuo on 2018/10/20.
 */

public class PlayState  extends State {

    private int fromX,fromY,lineWidth,lineNumber;
    private Game game;
    private int var;
    private Paint paint,textPaint;
    private int touchFirstX,touchFirstY,touchLastX,touchLastY;
    private Number number;
    private Recorder recorder;
    private Boolean isLose = false;
    private int score =0,exScore = 0,realScore = 0;
    private static Typeface typeface;

    public PlayState(Game game) {
        super(game);
        this.game = game;
        lineWidth = 200;
        lineNumber = 5;
        fromX = (GameUtils.getScreenWidth(game.getContext())-(lineNumber-1)*lineWidth)/2;
        fromY = (GameUtils.getScreenHeight(game.getContext())-(lineNumber-1)*lineWidth)/2+50;
        paint = new Paint();
        textPaint = new Paint();
        paint.setStrokeWidth(10);


        recorder = new Recorder();
        if(typeface == null){
            typeface = Typeface.createFromAsset(game.getContext().getAssets(),"myTypeface.ttf");
        }
        textPaint.setTypeface(typeface);
        number = new Number(lineWidth);
    }

    @Override
    public void init() {
        recorder.put(recorder.randomLocation(),number.randomNumber());
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Canvas canvas, Context context) {
             //drawBackground
             canvas.drawColor(Color.parseColor("#ffe7e1"));
             //drawBackground_deepColor
             paint.setColor(Color.parseColor("#ffd1d1"));
             canvas.drawRect(fromX,fromY,fromX+lineWidth*(lineNumber-1),fromY+lineWidth*(lineNumber-1),paint);
            //drawGird
            paint.setColor(Color.parseColor("#ffffff"));
            for (var = 0;var<lineNumber;var++){
                canvas.drawLine(fromX+var*lineWidth,fromY,fromX+var*lineWidth,fromY+(lineNumber-1)*lineWidth,paint);
                canvas.drawLine(fromX,fromY+var*lineWidth,fromX+(lineNumber-1)*lineWidth,fromY+var*lineWidth,paint);
            }
            for(String s:recorder.getMap().keySet()){
                if(recorder.exist(s)){
                    number.setLocation(fromX+recorder.getXLocation(s)*lineWidth,fromY+recorder.getYLocation(s)*lineWidth);
                    number.drawNumber(canvas,recorder.get(s));
                }
            }
            //drawScore
            textPaint.setTextSize(100);
            canvas.drawText("得分:",fromX+80,fromY-100,textPaint);
            canvas.drawText(""+realScore,fromX+320,fromY-100,textPaint);
            //drawGameTitle
            textPaint.setTextSize(200);
            canvas.drawText("2048",GameUtils.getScreenWidth(context)/2-195,fromY-300,textPaint);
            if(isLose){
                paint.setColor(Color.parseColor("#fff7fe"));
                canvas.drawRect(GameUtils.getScreenWidth(context)/2-450,GameUtils.getScreenHeight(context)/2-600,GameUtils.getScreenWidth(context)/2+450,GameUtils.getScreenHeight(context)/2+600,paint);
                textPaint.setTextSize(100);
                canvas.drawText("游戏结束",GameUtils.getScreenWidth(context)/2-195,fromY-100,textPaint);
                textPaint.setTextSize(100);
                canvas.drawText("得分",fromX+310,fromY+80,textPaint);
                canvas.drawText(""+realScore,fromX+320,fromY+280,textPaint);
                paint.setColor(Color.parseColor("#ffb7b1"));
                canvas.drawRect(GameUtils.getScreenWidth(context)/2-300,GameUtils.getScreenHeight(context)/2+400,GameUtils.getScreenWidth(context)/2+300,GameUtils.getScreenHeight(context)/2+550,paint);
                canvas.drawText("重新开始",GameUtils.getScreenWidth(context)/2-195,GameUtils.getScreenHeight(context)/2+510,textPaint);
            }

    }

    @Override
    public void gameEvent(MotionEvent event) {
        if(!isLose){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    touchFirstX = (int) event.getX();
                    touchFirstY = (int) event.getY();
                    if(isLose){
                        isLose = false;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    touchLastX = (int) event.getX();
                    touchLastY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    recorder.parseTouch(GameUtils.touchDirection(touchFirstX,touchFirstY,touchLastX,touchLastY));
                    if(GameUtils.touchDirection(touchFirstX,touchFirstY,touchLastX,touchLastY) != 0){
                        if(recorder.getLength()<16){
                            if(recorder.isrealMove(recorder.getRealMoveCounter())){
                                recorder.put(recorder.randomLocation(),number.randomNumber());
                                score =0;
                                for(String s:recorder.getMap().keySet()){
                                    score = score + recorder.get(s);
                                }
                                exScore = recorder.getScore();
                                realScore = score+exScore;
                            }
                        }
                    }
                    if(recorder.getLength() == 16){
                        if(recorder.isLose()){
                            isLose = true;
                        }
                    }

                    break;
            }
        }else{
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                if(event.getX() >GameUtils.getScreenWidth(game.getContext())/2-300  && event.getX()<GameUtils.getScreenWidth(game.getContext())/2+300){
                    if(event.getY()>GameUtils.getScreenHeight(game.getContext())/2+400 && event.getY()<GameUtils.getScreenHeight(game.getContext())/2+550){
                        recorder.clear();
                        recorder.clearScore();
                        score = 0;
                        exScore = 0;
                        realScore = 0;
                        isLose = false;
                        recorder.setRealMoveCounter(1);
                    }
                }
            }
        }

    }

    public static Typeface getTypeface() {
        return typeface;
    }
}
