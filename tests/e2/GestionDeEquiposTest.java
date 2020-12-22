package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestionDeEquiposTest {

    @Test
    void mainTest(){
        Proyectos p1 = new Proyectos("Software Design");
        Proyectos p2 = new Proyectos("Algorithms");
        Trabajador t1 = new Trabajador("Juan", 18);
        t1.setHours(8);
        t1.setHours(8);
        assertEquals("Worker Juan: 16.0 hours, 288.0 €", t1.getInfo());
        Trabajador t2 = new Trabajador("Mateo", 20);
        t2.setHours(6);
        t2.setHours(12);
        assertEquals("Worker Mateo: 18.0 hours, 360.0 €", t2.getInfo());
        Trabajador t3 = new Trabajador("Peter", 10);
        t3.setHours(7);
        t3.setHours(14);
        assertEquals("Worker Peter: 21.0 hours, 210.0 €", t3.getInfo());
        Trabajador t4 = new Trabajador("Tupac", 15);
        t4.setHours(10);
        t4.setHours(8);
        assertEquals("Worker Tupac: 18.0 hours, 270.0 €", t4.getInfo());
        Trabajador t5 = new Trabajador("Sultan", 13);
        t5.setHours(14);
        t5.setHours(8);
        assertEquals("Worker Sultan: 22.0 hours, 286.0 €", t5.getInfo());
        Trabajador t6 = new Trabajador("Anton", 12);
        t6.setHours(14);
        t6.setHours(8);
        assertEquals("Worker Anton: 22.0 hours, 264.0 €", t6.getInfo());
        Trabajador t7 = new Trabajador("Mario", 17);
        t7.setHours(14);
        t7.setHours(8);
        assertEquals("Worker Mario: 22.0 hours, 374.0 €", t7.getInfo());

        Equipo e1 = new Equipo("Equipo A");
        e1.add(t1);
        e1.add(t2);
        e1.add(t3);
        assertEquals("""
                Team Equipo A: 55.0 hours, 858.0 €
                \tWorker Juan: 16.0 hours, 288.0 €
                \tWorker Mateo: 18.0 hours, 360.0 €
                \tWorker Peter: 21.0 hours, 210.0 €
                """, e1.getInfo());


        Equipo e2 = new Equipo("Equipo A1");
        e2.add(t4);
        e2.add(t5);
        e1.add(e2);
        assertEquals("""
                Team Equipo A: 55.0 hours, 858.0 €
                \tWorker Juan: 16.0 hours, 288.0 €
                \tWorker Mateo: 18.0 hours, 360.0 €
                \tWorker Peter: 21.0 hours, 210.0 €
                \tTeam Equipo A1: 40.0 hours, 556.0 €
                \tWorker Tupac: 18.0 hours, 270.0 €
                \tWorker Sultan: 22.0 hours, 286.0 €
                """, e1.getInfo());

        p1.add(e1);
        p1.getInfo();
        assertEquals("""
                Proyect: Software Design
                \tTeam Equipo A: 55.0 hours, 858.0 €
                \tWorker Juan: 16.0 hours, 288.0 €
                \tWorker Mateo: 18.0 hours, 360.0 €
                \tWorker Peter: 21.0 hours, 210.0 €
                \tTeam Equipo A1: 40.0 hours, 556.0 €
                \tWorker Tupac: 18.0 hours, 270.0 €
                \tWorker Sultan: 22.0 hours, 286.0 €
                """, p1.getInfo());

        Equipo e3 = new Equipo("Equipo A2");
        e3.add(t6);
        e3.add(t7);
        assertEquals("""
                Team Equipo A2: 44.0 hours, 638.0 €
                \tWorker Anton: 22.0 hours, 264.0 €
                \tWorker Mario: 22.0 hours, 374.0 €
                """, e3.getInfo());

        p2.add(e3);
        p2.getInfo();
        assertEquals("""
                Proyect: Algorithms
                \tTeam Equipo A2: 44.0 hours, 638.0 €
                \tWorker Anton: 22.0 hours, 264.0 €
                \tWorker Mario: 22.0 hours, 374.0 €
                """, p2.getInfo());



    }
}
