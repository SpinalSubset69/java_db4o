package Entities;

public class Person {

    private String Nombre;
    private String Apellido;
    private String Matricula;
    private int Edad;
    private String Direccion;
    private String Carerra;

    public Person() {
    }

    public Person(String Nombre, String Apellido, String Matricula, int Edad, String Direccion, String Carerra) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Matricula = Matricula;
        this.Edad = Edad;
        this.Direccion = Direccion;
        this.Carerra = Carerra;
    }

    public Person(String mat) {
        this.Matricula = mat;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCarerra() {
        return Carerra;
    }

    public void setCarerra(String Carerra) {
        this.Carerra = Carerra;
    }

    @Override
    public String toString() {
        return "Person: [ " + " Nombre: " + this.Nombre + ", Apellido: " + this.Apellido + ", Matrícula: " + this.Matricula + "]";
    }

}
