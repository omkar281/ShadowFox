/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task3;
public class Student {
    private String rollNo;
    private String name;
    private String course;

    public Student(String rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public String getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
}
