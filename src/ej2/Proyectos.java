package ej2;

import java.util.ArrayList;
import java.util.List;

public class Proyectos {
    public final String p_name;

    public Proyectos(String p_name) {
        this.p_name = p_name;
    }

    private List<Equipo> equipos = new ArrayList<>();
    private List<Trabajador> trabajadores = new ArrayList<>();

    public void addTrabajador(Trabajador t){ trabajadores.add(t); }
    public void addEquipo(Equipo e){ equipos.add(e); }
}
