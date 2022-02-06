package ua.com.rostylka.utilities;

import ua.com.rostylka.models.Condition;
import ua.com.rostylka.models.FlowCounter;
import ua.com.rostylka.models.NatGasCharacter;

public abstract class ConditionCalculator {
    private static final double T_STANDART_CONDITION = 293.15;
    private static final double P_STANDART_CONDITION = 0.101325;
    private static double z = 0.999;

    //Метод перетворення витрати до робочих умов, без визначення коеф. стисливості природного газу
    public static double fromStandartCount(double qFlow, double p, double t) {
        return (qFlow * P_STANDART_CONDITION * (273.15 + t) * z) / (p * T_STANDART_CONDITION);
    }

    //Метод перетворення витрати до робочих умов, з вказанням коеф. стисливості природного газу
    public static double fromStandartCount(double qFlow, double p, double t, double z) {
        return (qFlow * P_STANDART_CONDITION * (273.15 + t) * z) / (p * T_STANDART_CONDITION);
    }

    //Метод перетворення витрати до робочих умов, з з визначенням коеф. стисливості природного газу
    public static double fromStandartCount(double qFlow, double p, double t, NatGasCharacter nGasChar) {
        double z = gerg91Mod(p, t, nGasChar);
        return (qFlow * P_STANDART_CONDITION * (273.15 + t) * z) / (p * T_STANDART_CONDITION);
    }

    //Метод Gerg-91 мод.
    public static double gerg91Mod(double p, double t, NatGasCharacter character) {
        return gerg(p, t + 273.15, character.getRoStCondidion(), character.getxA() * 1e-2, character.getxY() * 1e-2);
    }

    //Метод визначення Qmin лічильника, з визначенням коеф. стисливості природного газу.
    public static double qMinCount(FlowCounter counter, Condition cond, NatGasCharacter character) {
        z = gerg91Mod(cond.getpMax(), cond.gettMin(), character);
        return qStConditionCount(counter.getqMin(), cond.getpMax(), cond.gettMin());
    }

    //Метод визначення Qmin лічильника, без визначення коеф. стисливості природного газу.
    public static double qMinCount(FlowCounter counter, Condition cond) {
        return qStConditionCount(counter.getqMin(), cond.getpMax(), cond.gettMin());
    }

    //Метод визначення Qmax лічильника, з визначенням коеф. стисливості природного газу
    public static double qMaxCount(FlowCounter counter, Condition cond, NatGasCharacter character) {
        z = gerg91Mod(cond.getpMin(), cond.gettMax(), character);
        return qStConditionCount(counter.getqMax(), cond.getpMin(), cond.gettMax());
    }

    //Метод визначення Qmax лічильника, ,без визначення коеф. стисливості природного газу
    public static double qMaxCount(FlowCounter counter, Condition cond) {
        return qStConditionCount(counter.getqMax(), cond.getpMin(), cond.gettMax());
    }

    //Метод перетворення витрати до стандартних умов, без визначення коеф. стисливості природного газу
    public static double qStConditionCount(double qFlow, double p, double t) {
        return (qFlow * p * T_STANDART_CONDITION) / (P_STANDART_CONDITION * (273.15 + t) * z);
    }

    //Метод перетворення витрати до стандартних умов, з вказанням коеф. стисливості природного газу
    public static double qStConditionCount(double qFlow, double p, double t, double z) {
        return (qFlow * p * T_STANDART_CONDITION) / (P_STANDART_CONDITION * (273.15 + t) * z);
    }

    //Метод перетворення витрати до стандартних умов, з з визначенням коеф. стисливості природного газу
    public static double qStConditionCount(double qFlow, double p, double t, NatGasCharacter nGasChar) {
        double z = gerg91Mod(p, t, nGasChar);
        return (qFlow * p * T_STANDART_CONDITION) / (P_STANDART_CONDITION * (273.15 + t) * z);
    }

    //Реалізація Gerg-91 мод. (T - K, p - MPa, xA, xY% * e-2)
    private static double gerg(double p, double t, double roSt, double xA, double xY) {
        double bB = 0.72 + 1.875e-5 * Math.pow((320 - t), 2);
        double xE = 1 - xA - xY;
        double zC = 1 - Math.pow((0.0741 * roSt - 0.006 - 0.063 * xA - 0.0575 * xY), 2);
        double mE = (24.05525 * zC * roSt - 28.0135 * xA - 44.01 * xY) / xE;
        double h = 128.64 + 47.479 * mE;
        double b1 = -0.425468 + 2.865e-3 * t - 4.62073e-6 * t * t
                + (8.77118e-4 - 5.56281e-6 * t + 8.81514e-9 * t * t) * h
                + (-8.24747e-7 + 4.31436e-9 * t - 6.08319e-12 * t * t) * h * h;
        double b2 = -0.1446 + 7.4091e-4 * t - 9.1195e-7 * t * t;
        double b3 = -0.86834 + 4.0376e-3 * t - 5.1657e-6 * t * t;
        double b23 = -0.339693 + 1.61176e-3 * t - 2.04429e-6 * t * t;
        double bM = xE * xE * b1 + xE * xA * bB * (b1 + b2) - 1.73 * xE * xY * Math.sqrt(b1 * b3) + xA * xA * b2
                + 2 * xA * xY * b23 + xY * xY * b3;
        double bb = 1000 * p / (2.7715 * t);
        double c1 = -0.302488 + 1.95861e-3 * t - 3.16302e-6 * t * t
                + (6.46422e-4 - 4.22876e-6 * t + 6.88157e-9 * t * t) * h
                + (-3.32805e-7 + 2.2316e-9 * t - 3.67713e-12 * t * t) * h * h;
        double c2 = 7.8498e-3 - 3.9895e-5 * t + 6.1187e-8 * t * t;
        double cC = 0.92 + 0.0013 * (t - 270);
        double c3 = 2.0513e-3 + 3.4888e-5 * t - 8.3703e-8 * t * t;
        double c223 = 5.52066e-3 - 1.68609e-5 * t + 1.57169e-8 * t * t;
        double c233 = 3.58783e-3 + 8.06674e-6 * t - 3.25798e-8 * t * t;
        double cM = Math.pow(xE, 3) * c1 + 3 * xE * xE * xA * cC * Math.cbrt(c1 * c1 * c2)
                + 2.76 * xE * xE * xY * Math.cbrt(c1 * c1 * c3) + 3 * xE * xA * xA * cC * Math.cbrt(c1 * c2 * c2)
                + 6.6 * xE * xA * xY * Math.cbrt(c1 * c2 * c3) + 2.76 * xE * xY * xY * Math.cbrt(c1 * c3 * c3)
                + Math.pow(xA, 3) * c2 + 3 * xA * xA * xY * c223 + 3 * xA * xY * xY * c233 + Math.pow(xY, 3) * c3;
        double c0 = bb * bb * cM;
        double b0 = bb * bM;
        double a0 = 1 + 1.5 * (b0 + c0);
        double a1 = 1 + b0;

        double a2 = Math.cbrt((a0 - Math.sqrt((a0 * a0 - Math.pow(a1, 3)))));
        double z = (1 + a2 + a1 / a2) / 3;
        return z / zC;
    }
}
