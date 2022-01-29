package ua.com.rostylka.models;

import javax.persistence.*;

@Entity
@Table (name = "flowcounters")
public class FlowCounter {
    @Column (name = "qmin")
    private double qMin;
    @Column (name = "qmax")
    private double qMax;
    @Column
    private String type;
    @Column
    private String mode;
    @Id
    @Column
    private int id;

    public FlowCounter() {
    }

    public FlowCounter(double qMin, double qMax) {
        this.qMin = qMin;
        this.qMax = qMax;
    }

    public FlowCounter(String type, String mode) {
        this.type = type;
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getqMin() {
        return qMin;
    }

    public void setqMin(double qMin) {
        this.qMin = qMin;
    }

    public double getqMax() {
        return qMax;
    }

    public void setqMax(double qMax) {
        this.qMax = qMax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FlowCounter [qMin=" + qMin + ", qMax=" + qMax + ", type=" + type + ", mode=" + mode + "]";
    }

}
