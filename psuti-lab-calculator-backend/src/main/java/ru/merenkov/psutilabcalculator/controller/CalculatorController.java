package ru.merenkov.psutilabcalculator.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.merenkov.psutilabcalculator.service.CalculatorService;

@RestController
@RequestMapping("/api/v1/calculator")
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/calculate")
    public int calculate(@RequestParam("x") int x, @RequestParam("y") int y) {
        return calculatorService.calculate(x, y);
    }

    @GetMapping("/calculate-wait-time")
    public double calculateWaitTime(@RequestParam("arrivalRate") double arrivalRate,
                                    @RequestParam("serviceRate") double serviceRate,
                                    @RequestParam("numberOfChannels") int numberOfChannels) {
        return calculatorService.calculateWaitTime(arrivalRate, serviceRate, numberOfChannels);
    }
}
