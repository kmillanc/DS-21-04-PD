package ej2;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Componentes{
    public final String name;
    public double hours = 0;
    public double salary = 0;
    private List<Componentes> comp = new ArrayList<>();

    public Equipo(String name) {
        this.name = name;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getHours() {

        for(Componentes componentes:comp){
            hours += componentes.getHours();
        }
        return hours;
    }

    @Override
    public double getSalary() {
        for(Componentes componentes:comp){
            salary += componentes.getSalary();
        }
        return salary;
    }

    @Override
    public void add(Componentes componentes){ comp.add(componentes); }

    @Override
    public String getInfo(){
        StringBuilder info = new StringBuilder();


        info.append("Team ").append(getName()).append(": ").append(getHours()).append(" hours, ").append(getSalary()).append(" €\n");
        //info.append("\t").append(getInfo()).append("\n");


        for (Componentes componentes:comp) {
            //componentes.getInfo();
//            if(componentes.getInfo().contains("Team"))
//                info.append("Team ").append(getName()).append(": ").append(getHours()).append(" hours, ").append(getSalary()).append(" €\n");
//            else
                info.append("\t").append(componentes.getInfo()).append("\n");
        }

        return new String(info);
    }
//
//    public static void main(String[] args) {
//
//        Trabajador t1 = new Trabajador("Juan", 18);
//        t1.setHours(8);
//        t1.setHours(8);
//        Trabajador t2 = new Trabajador("Mateo", 20);
//        t2.setHours(6);
//        t2.setHours(12);
//        Trabajador t3 = new Trabajador("Peter", 10);
//        t3.setHours(7);
//        t3.setHours(14);
//        Trabajador t4 = new Trabajador("Tupac", 15);
//        t4.setHours(10);
//        t4.setHours(8);
//        Trabajador t5 = new Trabajador("Sultan", 13);
//        t5.setHours(14);
//        t5.setHours(8);
//        Trabajador t6 = new Trabajador("Anton", 12);
//        t6.setHours(14);
//        t6.setHours(8);
//        Trabajador t7 = new Trabajador("Mario", 17);
//        t7.setHours(14);
//        t7.setHours(8);
//
//        Equipo e1 = new Equipo("Equipo A");
//        e1.add(t1);
//        e1.add(t2);
//        e1.add(t3);
//
//        Equipo e2 = new Equipo("Equipo A1");
//        e2.add(t4);
//        e2.add(t5);
//        e1.add(e2);
//
//        Equipo e3 = new Equipo("Equipo A2");
//        e3.add(t6);
//        e3.add(t7);
//        e1.add(e3);
//
//        System.out.println(e1.getInfo());
//    }
}