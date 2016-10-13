package com.scofield.customview;

import java.io.Serializable;

/**
 * @author scofield@tronsis.com
 * @date 2016/10/13 16:07
 */

public class RadianBean implements Serializable {
    private String name;
    private int value;
    private float percent;

    private int color;
    private float angle;

    public RadianBean() {
    }

    public RadianBean(String name, int value, float percent, int color, float angle) {
        this.name = name;
        this.value = value;
        this.percent = percent;
        this.color = color;
        this.angle = angle;
    }
    public RadianBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
