package com.faysal.pi4LED.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fay on 6/6/2017.
 */
public class LedController {
    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting(){

        return "Hello World";
    }
    @RequestMapping("/light")
    public String light(){
        if(pin==null){
            GpioController gpio = GpioFactory.getInstance();

             pin = gpio.provisionDigitalOutputPin(
                     RaspiPin.GPIO_04,
                     "LED2",
                     PinState.LOW);
        }

        pin.toggle();
        return "ok";
    }
}
