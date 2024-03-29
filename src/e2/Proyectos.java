package e2;

import java.util.ArrayList;
import java.util.List;

public class Proyectos {
    private final String name;
    private List<Componentes> comp = new ArrayList<>();

    public Proyectos(String name) {
        this.name = name;
    }


    public String getName(){ return name; }


    public void add(Componentes componentes){ comp.add(componentes); }


    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Proyect: ").append(getName()).append("\n");

        for (Componentes componentes:comp) {

            info.append("\t").append(componentes.getInfo());
            if (!componentes.getClass().equals(Equipo.class)) {
                info.append("\n");
            }

        }

        return new String(info);
    }

//    public static void main(String[] args) {
//        Proyectos p1 = new Proyectos("DS");
//        Equipo e1 = new Equipo("A");
//        Trabajador t1 = new Trabajador("Ger", 20);
//        t1.setHours(20);
//        e1.add(t1);
//        p1.add(e1);
//        System.out.println(p1.getInfo());
//        System.out.println("\n");
//
//        Proyectos p2 = new Proyectos("SO");
//        Equipo e2 = new Equipo("B");
//        Trabajador t2 = new Trabajador("Brr", 30);
//        t2.setHours(25);
//        e2.add(t2);
//        p2.add(e2);
//        System.out.println(p2.getInfo());
//
//    }
}