package e1;

import java.util.ArrayList;
import java.util.List;

/*public*/ interface ModoTermostato {
    void calentar(Termostato t);
    default void setArgu(float n){ }
    default StringBuilder screenInfoAux(){
        return new StringBuilder();
    }
    default float getArgu(){ return -1 ;};
}

/*public*/ class Off implements ModoTermostato {
    private static final Off instancia = new Off();
    private Off(){ }
    public static Off getInstancia() { return instancia; }

    @Override
    public void calentar(Termostato t) {
        t.power = false;
    }
}

/*public*/ class Manual implements ModoTermostato {
    private static final Manual instancia = new Manual();
    private Manual(){ }
    public static Manual getInstancia() { return instancia; }

    @Override
    public void calentar(Termostato t) {
        t.power = true;

    }
}

/*public*/ class Timer implements ModoTermostato {
    private static final Timer instancia = new Timer();
    private Timer(){ }
    public static Timer getInstancia() { return instancia; }
    public int tRestante = 0;

    @Override
    public float getArgu() {
        return tRestante;
    }

    @Override
    public void setArgu(float tRestante) {
        this.tRestante = (int) (this.tRestante + tRestante);
    }

    @Override
    public void calentar(Termostato t) {
        if(tRestante > 0){
            t.power = true;
        }else{
            t.power = false;
            t.registro.add("Se desactiva el modo Timer");
            t.setModo(Off.getInstancia());
        }

    }

    @Override
    public StringBuilder screenInfoAux() {
        StringBuilder sbA = new StringBuilder();
        sbA.append(" ").append(tRestante);
        return sbA;
    }
}

/*public*/ class Program implements ModoTermostato {
    private static final Program instancia = new Program();
    private Program(){ }
    public static Program getInstancia() { return instancia; }
    public float tConsigna;

    @Override
    public float getArgu() {
        return tConsigna;
    }

    @Override
    public void setArgu(float tConsigna) {
        this.tConsigna = tConsigna;
    }

    @Override
    public void calentar(Termostato t) {
        if(t.temperatura < tConsigna){
            t.power = true;
        }else{
            t.power = false;
            t.setModo(Off.getInstancia());
        }
    }

    @Override
    public StringBuilder screenInfoAux() {
        StringBuilder sbA = new StringBuilder();
        sbA.append(" ").append(tConsigna);
        return sbA;
    }
}

public class Termostato {
    ModoTermostato modo = Off.getInstancia();
    boolean power;
    float temperatura;
    List<String> registro = new ArrayList<>();

//    permite registrar una nueva
//    temperatura. Este metodo se llamara periodicamente para actualizar la temperatura
//    en base a la informacion almacenada en los sensores. Con el objeto
//    de simplicar el problema, simularemos el paso del tiempo considerando que
//    cada vez que se llama al metodo han pasado 5 minutos
    void newTemperature(float currentTemperature){
        temperatura = currentTemperature;
        StringBuilder sb = new StringBuilder();
        sb.append(currentTemperature).append(" Modo ").append(this.modo.toString().substring(3, modo.toString().indexOf('@')));
            if(modo.equals(Timer.getInstancia())){
                if(modo.getArgu() > 0){
                    sb.append(" (faltan " + (int)modo.getArgu() + " minutos)");
                }
            }else if((modo.equals(Program.getInstancia()))){
                sb.append(" (a " + modo.getArgu() + " grados)");
            }
        sb.append(" - Calefacción ");
        if(power){
            sb.append(" encendida.");
        }else{
            sb.append("apagada.");
        }
        this.registro.add(sb.toString());

        if(modo.equals(Timer.getInstancia())){
            modo.setArgu(-5);
        }
    }


//    proporciona la informacion requerida para la pantalla del termostato.
//    A continuacion, se indica los datos a mostrar para cada modo de
//    funcionamiento y el formato solicitado. Ademas, se facilitan algunos ejemplos
//    concretos.

//* Modos de funcionamiento Off y Manual :
//    Formato : Temperatura Calefacción (ON/ OFF ) Modo funcionamiento (O/M)
//    Ejemplo 1: 20.1 OFF O
//    Ejemplo 2: 20.1 ON M
//* Modo de funcionamiento Timer :
//    Formato : Temperatura Calefacción Modo funcionamiento (T) ( tiempo restante )
//    Ejemplo : 21.0 ON T 14
//* Modo de funcionamiento Program :
//    Formato : Temperatura Calefacción Modo funcionamiento (P) ( temp . consigna )
//    Ejemplo : 20.1 OFF P 20.0
    String screenInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.temperatura);
        if(power){
            sb.append(" ON ");
        }
        else{
            sb.append(" OFF ");
        }
        sb.append(modo.toString().toUpperCase().charAt(3));
        sb.append(modo.screenInfoAux());

        System.out.println(sb);
        return sb.toString();
    }
    public void setModo(ModoTermostato estado){
        this.modo = estado;
        StringBuilder sb = new StringBuilder();
        sb.append("Se activa el modo ").append(estado.toString().substring(3, estado.toString().indexOf('@'))).append(".");
        this.registro.add(sb.toString());
    }

    public void setModo(ModoTermostato estado, float n){
        this.modo = estado;
        StringBuilder sb = new StringBuilder();
        sb.append("Se activa el modo ").append(estado.toString().substring(3, estado.toString().indexOf('@'))).append(" ");
        if(estado.equals(Timer.getInstancia())){
            sb.append(n).append(" minutos.");
        }else if(estado.equals(Program.getInstancia())){
            sb.append(n).append(" grados.");
        }
        this.registro.add(sb.toString());
        modo.setArgu(n);
    }

    public void calentar(){
        modo.calentar(this);
    }

    public String register(){
        StringBuilder sb = new StringBuilder();
        for(String s : registro){
            System.out.println(s);
            sb.append(s).append('\n');
        }
        return sb.toString();
    }


}