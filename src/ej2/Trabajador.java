package ej2;

public class Trabajador extends Componentes{
    private final String name;
    private final double cost_hour;
    public double hours;
    public double salary;

    public Trabajador(String name, double cost_hour) {
        this.name = name;
        this.cost_hour = cost_hour;
    }

    public void setHours(double hours) {
        this.hours += hours;
    }

    @Override
    public double getHours(){ return hours; }

    @Override
    public String getName(){ return name; }

    @Override
    public double getSalary(){
        return salary = (hours * cost_hour);
    }

    @Override
    public String getInfo(){
        return ("Worker "+getName()+": "+getHours()+" hours, "+getSalary()+" €");
    }

}
