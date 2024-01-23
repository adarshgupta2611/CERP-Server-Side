package com.app.entity.projection;

import java.io.Serializable;

import com.app.entities.Student;

public class AttendanceList implements Serializable {
    private Student student;
    private int attendance;

    public AttendanceList(Student student, int attendance) {
        super();
        this.student = student;
        this.attendance = attendance;
    }

    public AttendanceList() {
        super();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }


}