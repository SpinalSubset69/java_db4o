/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frames;

import DataAccess.PersonDbAccess;
import Entities.Person;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Spina
 */
public class Operations {

    private PersonDbAccess db;

    public Operations() {
        this.db = new PersonDbAccess();
    }

    public void getStudentsAndPaintTable(JTable table) {
        Person[] lst = this.db.getPersons();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (Person lst1 : lst) {
            model.addRow(new Object[]{">", lst1.getNombre(), lst1.getApellido(), lst1.getMatricula(), lst1.getDireccion(), lst1.getCarerra(), (int) lst1.getEdad()});
        }
        this.db.closeConnection();
    }

    public void addStudent(JTable table, Person args) {
        this.db.addPerson(args);
        this.getStudentsAndPaintTable(table);
    }

    public void updateStudent(JTable table, Person args) {
        this.db.updatePerson(args);
        this.getStudentsAndPaintTable(table);
    }
    
    public void deleteStudent(JTable table, Person args){
        this.db.deletePerons(args);
        this.getStudentsAndPaintTable(table);
    }

}
