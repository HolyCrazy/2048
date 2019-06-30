package com.example.leeduo.a2048;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LeeDuo on 2018/10/17.
 */

public class Recorder {
    private Map<String,Integer> map;
    private String[] location;
    private String[][] locArrey;
    private int i,j;
    private int randomX,randomY;
    private String locString;
    private int realMoveCounter =1;
    private volatile int score = 0;
    public Recorder(){
        map = new HashMap<>();
        location =new String[2];
        locArrey = new String[4][4];
        for(i = 0;i<4;i++){
            for(j = 0;j<4;j++){
                locArrey[i][j]= i+","+j;
            }
        }
    }

    public String getLocArrey(int X,int Y) {
        return locArrey[X][Y];
    }

    //存数据
    public void put(String XandY,int number){
        map.put(XandY,number);
    }
    //取数据
    public int get(String XandY){
        return map.get(XandY);
    }
    //清空数据
    public void clear(){
        map.clear();
    }
    //判断该位置棋子是否存在
    public Boolean exist(String XandY){
        return map.containsKey(XandY);
    }
    //判断存入的数据数量
    public int getLength(){
        return map.size();
    }
    //解析字符串，返回X轴坐标
    public int getXLocation(String XandY){
        location = XandY.split(",");
        return Integer.parseInt(location[0]);
    }
    //解析字符串，返回Y轴坐标
    public int getYLocation(String XandY){
        location = XandY.split(",");
        return Integer.parseInt(location[1]);
    }
    //获取map
    public Map<String,Integer> getMap(){
        return map;
    }

    public int getScore() {
        return score;
    }

    public void clearScore() {
        score =0;
    }

    public void setRealMoveCounter(int realMoveCounter) {
        this.realMoveCounter = realMoveCounter;
    }

    public String randomLocation(){
        if(getLength()<16){
            while (true){
                 randomX = GameUtils.randomNumber(0,4);
                randomY = GameUtils.randomNumber(0,4);
                locString = randomX+","+randomY;
                if (!exist(locString)){
                    break;
                }
            }
            return locString;
        }
        return "";
    }

    public Boolean isrealMove(int realMoveCounter){
        if(realMoveCounter != 0){
            this.realMoveCounter = 0;
            return true;
        }else{
            return false;
        }

    }




    public int getRealMoveCounter() {
        return realMoveCounter;
    }

    public void parseTouch(int i){
        switch (i){
            case 1 :
                moveLeft();
                sumLeft();
                moveLeft();
                break;
            case 2:
                moveRight();
                sumRight();
                moveRight();
                break;
            case 3:
                moveTop();
                sumTop();
                moveTop();
                break;
            case 4:
                moveBottom();
                sumBottom();
                moveBottom();
                break;
        }
    }

    private void moveRight(){
        for(i = 0 ;i<4;i++){
            if(exist(locArrey[2][i])){
                if(!exist(locArrey[3][i])){
                    put(locArrey[3][i],get(locArrey[2][i]));
                    getMap().remove(locArrey[2][i]);
                    realMoveCounter = realMoveCounter+1;
                }
            }
            if(exist(locArrey[1][i])){
                if(!exist(locArrey[3][i])){
                    put(locArrey[3][i],get(locArrey[1][i]));
                    getMap().remove(locArrey[1][i]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[2][i])){
                        put(locArrey[2][i],get(locArrey[1][i]));
                        getMap().remove(locArrey[1][i]);
                        realMoveCounter = realMoveCounter+1;
                    }
                }
            }
            if(exist(locArrey[0][i])){
                if(!exist(locArrey[3][i])){
                    put(locArrey[3][i],get(locArrey[0][i]));
                    getMap().remove(locArrey[0][i]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[2][i])){
                        put(locArrey[2][i],get(locArrey[0][i]));
                        getMap().remove(locArrey[0][i]);
                        realMoveCounter = realMoveCounter+1;
                    } else{
                        if(!exist(locArrey[1][i])){
                            put(locArrey[1][i],get(locArrey[0][i]));
                            getMap().remove(locArrey[0][i]);
                            realMoveCounter = realMoveCounter+1;
                        }
                    }
                }
            }
        }
    }
    private void sumRight(){
        for(j =3;j>0;j--){
            if(exist(locArrey[j][0])&&exist(locArrey[j-1][0])){
                if(get(locArrey[j][0]) == get(locArrey[j-1][0])){
                    put(locArrey[j][0],get(locArrey[j][0])*2);
                    getMap().remove(locArrey[j-1][0]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][0]);

                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[j][1])&&exist(locArrey[j-1][1])){
                if(get(locArrey[j][1]) == get(locArrey[j-1][1])){
                    put(locArrey[j][1],get(locArrey[j][1])*2);
                    getMap().remove(locArrey[j-1][1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][1]);
                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[j][2])&&exist(locArrey[j-1][2])){
                if(get(locArrey[j][2]) == get(locArrey[j-1][2])){
                    put(locArrey[j][2],get(locArrey[j][2])*2);
                    getMap().remove(locArrey[j-1][2]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][2]);
                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[j][3])&&exist(locArrey[j-1][3])){
                if(get(locArrey[j][3]) == get(locArrey[j-1][3])){
                    put(locArrey[j][3],get(locArrey[j][3])*2);
                    getMap().remove(locArrey[j-1][3]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][3]);
                    break;
                }
            }
        }

    }
    private void moveLeft(){
        for(i = 0 ;i<4;i++){
            if(exist(locArrey[1][i])){
                if(!exist(locArrey[0][i])){
                    put(locArrey[0][i],get(locArrey[1][i]));
                    getMap().remove(locArrey[1][i]);
                    realMoveCounter = realMoveCounter+1;
                }
            }
            if(exist(locArrey[2][i])){
                if(!exist(locArrey[0][i])){
                    put(locArrey[0][i],get(locArrey[2][i]));
                    getMap().remove(locArrey[2][i]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[1][i])){
                        put(locArrey[1][i],get(locArrey[2][i]));
                        getMap().remove(locArrey[2][i]);
                        realMoveCounter = realMoveCounter+1;
                    }
                }
            }
            if(exist(locArrey[3][i])){
                if(!exist(locArrey[0][i])){
                    put(locArrey[0][i],get(locArrey[3][i]));
                    getMap().remove(locArrey[3][i]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[1][i])){
                        put(locArrey[1][i],get(locArrey[3][i]));
                        getMap().remove(locArrey[3][i]);
                        realMoveCounter = realMoveCounter+1;
                    } else{
                        if(!exist(locArrey[2][i])){
                            put(locArrey[2][i],get(locArrey[3][i]));
                            getMap().remove(locArrey[3][i]);
                            realMoveCounter = realMoveCounter+1;
                        }
                    }
                }
            }
        }
    }
    private void sumLeft(){
        for(j =0;j<3;j++){
            if(exist(locArrey[j][0])&&exist(locArrey[j+1][0])){
                if(get(locArrey[j][0]) == get(locArrey[j+1][0])){
                    put(locArrey[j][0],get(locArrey[j][0])*2);
                    getMap().remove(locArrey[j+1][0]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][0]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[j][1])&&exist(locArrey[j+1][1])){
                if(get(locArrey[j][1]) == get(locArrey[j+1][1])){
                    put(locArrey[j][1],get(locArrey[j][1])*2);
                    getMap().remove(locArrey[j+1][1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][1]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[j][2])&&exist(locArrey[j+1][2])){
                if(get(locArrey[j][2]) == get(locArrey[j+1][2])){
                    put(locArrey[j][2],get(locArrey[j][2])*2);
                    getMap().remove(locArrey[j+1][2]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][2]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[j][3])&&exist(locArrey[j+1][3])){
                if(get(locArrey[j][3]) == get(locArrey[j+1][3])){
                    put(locArrey[j][3],get(locArrey[j][3])*2);
                    getMap().remove(locArrey[j+1][3]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[j][3]);
                    break;
                }
            }
        }
    }
    private void moveTop(){
        for(i = 0 ;i<4;i++){
            if(exist(locArrey[i][1])){
                if(!exist(locArrey[i][0])){
                    put(locArrey[i][0],get(locArrey[i][1]));
                    getMap().remove(locArrey[i][1]);
                    realMoveCounter = realMoveCounter+1;
                }
            }
            if(exist(locArrey[i][2])){
                if(!exist(locArrey[i][0])){
                    put(locArrey[i][0],get(locArrey[i][2]));
                    getMap().remove(locArrey[i][2]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[i][1])){
                        put(locArrey[i][1],get(locArrey[i][2]));
                        getMap().remove(locArrey[i][2]);
                        realMoveCounter = realMoveCounter+1;
                    }
                }
            }
            if(exist(locArrey[i][3])){
                if(!exist(locArrey[i][0])){
                    put(locArrey[i][0],get(locArrey[i][3]));
                    getMap().remove(locArrey[i][3]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[i][1])){
                        put(locArrey[i][1],get(locArrey[i][3]));
                        getMap().remove(locArrey[i][3]);
                        realMoveCounter = realMoveCounter+1;
                    } else{
                        if(!exist(locArrey[i][2])){
                            put(locArrey[i][2],get(locArrey[i][3]));
                            getMap().remove(locArrey[i][3]);
                            realMoveCounter = realMoveCounter+1;
                        }
                    }
                }
            }
        }
    }
    private void sumTop(){
        for(j =0;j<3;j++){
            if(exist(locArrey[0][j])&&exist(locArrey[0][j+1])){
                if(get(locArrey[0][j]) == get(locArrey[0][j+1])){
                    put(locArrey[0][j],get(locArrey[0][j])*2);
                    getMap().remove(locArrey[0][j+1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[0][j]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[1][j])&&exist(locArrey[1][j+1])){
                if(get(locArrey[1][j]) == get(locArrey[1][j+1])){
                    put(locArrey[1][j],get(locArrey[1][j])*2);
                    getMap().remove(locArrey[1][j+1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[1][j]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[2][j])&&exist(locArrey[2][j+1])){
                if(get(locArrey[2][j]) == get(locArrey[2][j+1])){
                    put(locArrey[2][j],get(locArrey[2][j])*2);
                    getMap().remove(locArrey[2][j+1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[2][j]);
                    break;
                }
            }
        }
        for(j =0;j<3;j++){
            if(exist(locArrey[3][j])&&exist(locArrey[3][j+1])){
                if(get(locArrey[3][j]) == get(locArrey[3][j+1])){
                    put(locArrey[3][j],get(locArrey[3][j])*2);
                    getMap().remove(locArrey[3][j+1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[3][j]);
                    break;
                }
            }
        }
    }
    private void moveBottom(){
        for(i = 0 ;i<4;i++){
            if(exist(locArrey[i][2])){
                if(!exist(locArrey[i][3])){
                    put(locArrey[i][3],get(locArrey[i][2]));
                    getMap().remove(locArrey[i][2]);
                    realMoveCounter = realMoveCounter+1;
                }
            }
            if(exist(locArrey[i][1])){
                if(!exist(locArrey[i][3])){
                    put(locArrey[i][3],get(locArrey[i][1]));
                    getMap().remove(locArrey[i][1]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[i][2])){
                        put(locArrey[i][2],get(locArrey[i][1]));
                        getMap().remove(locArrey[i][1]);
                        realMoveCounter = realMoveCounter+1;
                    }
                }
            }
            if(exist(locArrey[i][0])){
                if(!exist(locArrey[i][3])){
                    put(locArrey[i][3],get(locArrey[i][0]));
                    getMap().remove(locArrey[i][0]);
                    realMoveCounter = realMoveCounter+1;
                }else{
                    if(!exist(locArrey[i][2])){
                        put(locArrey[i][2],get(locArrey[i][0]));
                        getMap().remove(locArrey[i][0]);
                        realMoveCounter = realMoveCounter+1;
                    } else{
                        if(!exist(locArrey[i][1])){
                            put(locArrey[i][1],get(locArrey[i][0]));
                            getMap().remove(locArrey[i][0]);
                            realMoveCounter = realMoveCounter+1;
                        }
                    }
                }
            }
        }
    }
    private void sumBottom(){
        for(j =3;j>0;j--){
            if(exist(locArrey[0][j])&&exist(locArrey[0][j-1])){
                if(get(locArrey[0][j]) == get(locArrey[0][j-1])){
                    put(locArrey[0][j],get(locArrey[0][j])*2);
                    getMap().remove(locArrey[0][j-1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[0][j]);
                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[1][j])&&exist(locArrey[1][j-1])){
                if(get(locArrey[1][j]) == get(locArrey[1][j-1])){
                    put(locArrey[1][j],get(locArrey[1][j])*2);
                    getMap().remove(locArrey[1][j-1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[1][j]);
                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[2][j])&&exist(locArrey[2][j-1])){
                if(get(locArrey[2][j]) == get(locArrey[2][j-1])){
                    put(locArrey[2][j],get(locArrey[2][j])*2);
                    getMap().remove(locArrey[2][j-1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[2][j]);
                    break;
                }
            }
        }
        for(j =3;j>0;j--){
            if(exist(locArrey[3][j])&&exist(locArrey[3][j-1])){
                if(get(locArrey[3][j]) == get(locArrey[3][j-1])){
                    put(locArrey[3][j],get(locArrey[3][j])*2);
                    getMap().remove(locArrey[3][j-1]);
                    realMoveCounter = realMoveCounter+1;
                    score = score +get(locArrey[3][j]);
                    break;
                }
            }
        }

    }

    public Boolean isLose(){
        //纵向检查
        for(j =0;j<4;j++){
            for(i = 0; i<3;i++){
                if(exist(locArrey[j][i])&&exist(locArrey[j][i+1])){
                    if (get(locArrey[j][i]) == get(locArrey[j][i+1])){
                        return false;
                    }
                }
            }
        }
        //横向检查
        for(j=0;j<4;j++){
            for(i =0;i<3;i++){
                if(exist(locArrey[i][j])&&exist(locArrey[i+1][j])){
                    if (get(locArrey[i][j]) == get(locArrey[i+1][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
