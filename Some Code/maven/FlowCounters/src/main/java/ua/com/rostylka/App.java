package ua.com.rostylka;


import ua.com.rostylka.dao.FlowCounterDao;
import ua.com.rostylka.models.FlowCounter;

import java.util.List;

public class App {
    public static void main(String[] args) {
        FlowCounter counter = new FlowCounter();
        counter.setMode("G100");
        counter.setType("KURS-01");
        counter.setqMin(0.65);
        counter.setqMax(160);
        counter.setId(17);

        /*FlowCounterDao flowCounterDao = FlowCounterDao.getInstance();
        List<FlowCounter> flowCounters = flowCounterDao.readAll();
        for (FlowCounter flowcounter: flowCounters) {
            System.out.println(flowcounter);
        }*/


    }
}
