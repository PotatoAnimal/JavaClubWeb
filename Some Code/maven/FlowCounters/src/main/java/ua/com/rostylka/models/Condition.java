package ua.com.rostylka.models;

import org.springframework.stereotype.Component;

@Component
public class Condition {
    public double getqMinSt() {
        return qMinSt;
    }

    public void setqMinSt(double qMinSt) {
        this.qMinSt = qMinSt;
    }

    public double getqMaxSt() {
        return qMaxSt;
    }

    public void setqMaxSt(double qMaxSt) {
        this.qMaxSt = qMaxSt;
    }

    private double pMin;
    private double pMax;
    private double tMin;
    private double tMax;
    private double qMinSt;
    private double qMaxSt;

    public Condition() {}

    public Condition(double pMin, double pMax, double tMin, double tMax) {
        setpMin(pMin);
        setpMax(pMax);
        settMin(tMin);
        settMax(tMax);
    }

    public Condition(double qMinSt, double qMaxSt, double pMin, double pMax, double tMin, double tMax) {
        this.pMin = pMin;
        this.pMax = pMax;
        this.tMin = tMin;
        this.tMax = tMax;
        this.qMinSt = qMinSt;
        this.qMaxSt = qMaxSt;
    }

    public double getpMin() {
        return pMin;
    }

    public void setpMin(double pMin) {
        this.pMin = pMin;
    }

    public double getpMax() {
        return pMax;
    }

    public void setpMax(double pMax) {
        this.pMax = pMax;
    }

    public double gettMin() {
        return tMin;
    }

    public void settMin(double tMin) {
        this.tMin = tMin;
    }

    public double gettMax() {
        return tMax;
    }

    public void settMax(double tMax) {
        this.tMax = tMax;
    }

}
