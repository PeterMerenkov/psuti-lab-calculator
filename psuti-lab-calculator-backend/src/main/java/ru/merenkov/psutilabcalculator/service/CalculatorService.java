package ru.merenkov.psutilabcalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int calculate(int x, int y) {
        return x + y;
    }

    public double calculateWaitTime(double arrivalRate, double serviceRate, int numberOfChannels) {
        double trafficIntensity = arrivalRate / (numberOfChannels * serviceRate);

        if (trafficIntensity >= 1.0) {
            System.out.println("Система перегружена. Интенсивность трафика больше 1.0");
            return -1;
        }

        double utilization = trafficIntensity / (1 - trafficIntensity);

        return utilization / (numberOfChannels * serviceRate - arrivalRate);
    }

}
