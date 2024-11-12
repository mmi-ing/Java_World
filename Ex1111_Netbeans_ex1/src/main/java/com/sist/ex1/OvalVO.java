
package com.sist.ex1;

import java.awt.Color;
import java.io.Serializable;

public class OvalVO implements Serializable{
    int x, y, wh;
    Color c;
    
    public OvalVO(int x, int y) {
        this.x = x;
        this.y = y;
        wh = (int)(Math.random()*180+20);
        
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        c = new Color(r, g, b);
    } 
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getWH() {
        return wh;
    }

    public void setWH(int wh) {
        this.wh = wh;
    }

}
