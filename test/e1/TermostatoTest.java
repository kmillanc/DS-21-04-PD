package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.StreamPrintService;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {


    @Test
    void stringConstructors() {
        String st = "";

        Termostato term = new Termostato();
        term.calentar();
        term.newTemperature((float)20.1);       //Estado inicial
        term.calentar();                        //5 min en modo OFF
        term.setModo(Manual.getInstancia());
        term.calentar();                        //5 min en modo MANUAL
        term.newTemperature((float)20.1);
        assertEquals("20.1 ON M", term.screenInfo() );
        term.calentar();                        //5 min en modo MANUAL
        term.newTemperature((float)21.5);
        term.calentar();                        //5 min en modo MANUAL
        term.newTemperature((float)21.1);
        term.calentar();                        //5 min en modo MANUAL
        term.setModo(Timer.getInstancia(), 19);
        assertEquals("21.1 ON T 19", term.screenInfo());
        term.newTemperature((float)21.1);
        term.calentar();                        //5 min en modo TIMER
        term.newTemperature((float)21.0);
        term.calentar();                        //5 min en modo TIMER
        term.newTemperature((float)21.9);
        assertEquals("21.9 ON T 4", term.screenInfo());
        term.calentar();                        //5 min en modo TIMER
        term.newTemperature((float)22.8);
        term.calentar();                        //5 min en modo MANUAL
        term.newTemperature((float)22.5);
        term.calentar();                        //5 min en modo MANUAL
        term.newTemperature((float)22.9);
        term.calentar();                        //5 min en modo MANUAL
        term.setModo(Off.getInstancia());
        term.calentar();                        //5 min en modo Off
        assertEquals("22.9 OFF O", term.screenInfo());
        term.newTemperature((float)18);
        term.setModo(Program.getInstancia(), (float) 20.0);
        term.calentar();                        //5 min en modo PROGRAM
        term.newTemperature((float)19.4);
        assertEquals("19.4 ON P 20.0", term.screenInfo());
        term.calentar();                        //5 min en modo PROGRAM
        term.newTemperature((float)21.2);
        term.calentar();                        //5 min en modo OFF
        term.newTemperature((float)21.2);
        assertEquals("21.2 OFF O", term.screenInfo());
        term.calentar();

        assertEquals(
                "20.1 Modo Off - Calefacción apagada.\n" +
                "Se activa el modo Manual.\n" +
                "20.1 Modo Manual - Calefacción  encendida.\n" +
                "21.5 Modo Manual - Calefacción  encendida.\n" +
                "21.1 Modo Manual - Calefacción  encendida.\n" +
                "Se activa el modo Timer 19.0 minutos.\n" +
                "21.1 Modo Timer (faltan 19 minutos) - Calefacción  encendida.\n" +
                "21.0 Modo Timer (faltan 14 minutos) - Calefacción  encendida.\n" +
                "21.9 Modo Timer (faltan 9 minutos) - Calefacción  encendida.\n" +
                "22.8 Modo Timer (faltan 4 minutos) - Calefacción  encendida.\n" +
                "Se desactiva el modo Timer\n" +
                "Se activa el modo Off.\n" +
                "22.5 Modo Off - Calefacción apagada.\n" +
                "22.9 Modo Off - Calefacción apagada.\n" +
                "Se activa el modo Off.\n" +
                "18.0 Modo Off - Calefacción apagada.\n" +
                "Se activa el modo Program 20.0 grados.\n" +
                "19.4 Modo Program (a 20.0 grados) - Calefacción  encendida.\n" +
                "21.2 Modo Program (a 20.0 grados) - Calefacción  encendida.\n" +
                "Se activa el modo Off.\n" +
                "21.2 Modo Off - Calefacción apagada.\n", term.register());

    }

}