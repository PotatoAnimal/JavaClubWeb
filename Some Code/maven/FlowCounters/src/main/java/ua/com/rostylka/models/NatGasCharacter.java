package ua.com.rostylka.models;

import org.springframework.stereotype.Component;
@Component
public class NatGasCharacter {
    private double roStCondidion;
    private double xA;
    private double xY;

    public NatGasCharacter(){}

    public NatGasCharacter(double roSt, double xA, double xY) {
        setRoStCondidion(roSt);
        setxA(xA);
        setxY(xY);
    }

    public double getRoStCondidion() {

        return roStCondidion;
    }

    public void setRoStCondidion(double roStCondidion) {

        this.roStCondidion = roStCondidion;
    }

    public double getxA() {
        return xA;
    }

    public void setxA(double xA) {
        this.xA = xA;
    }

    public double getxY() {
        return xY;
    }

    public void setxY(double xY) {
        this.xY = xY;
    }

    @Override
    public String toString() {
        return "NatGasCharacter [roStCondidion=" + roStCondidion + ", xA=" + xA + ", xY=" + xY + "]";
    }

}
