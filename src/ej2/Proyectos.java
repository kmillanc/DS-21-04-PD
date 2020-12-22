package ej2;

import java.util.ArrayList;
import java.util.List;

public class Proyectos extends Componentes{
    public final String p_name;

    public Proyectos(String p_name) {
        this.p_name = p_name;
    }

//    private List<Equipo> equipos = new ArrayList<>();
//    private List<Trabajador> trabajadores = new ArrayList<>();
//
//    public void addTrabajador(Trabajador t){ trabajadores.add(t); }
//    public void addEquipo(Equipo e){ equipos.add(e); }
    private List<Componentes> comp = new ArrayList<>();
    public void add(Componentes componentes){ comp.add(componentes); }

    public static void main(String[] args) {
        Proyectos proyectos = new Proyectos("Software Design");
        Proyectos proyectos1 = new Proyectos("Operating Sistems");
    }
}
