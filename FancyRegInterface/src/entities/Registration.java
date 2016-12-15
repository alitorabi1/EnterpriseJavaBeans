/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ipd
 */
@Entity
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    @ManyToOne
    private entities.Student student;

    @ManyToOne
    private entities.Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public entities.Student getStudent() {
        return student;
    }

    public void setStudent(entities.Student student) {
        this.student = student;
    }

    public entities.Course getCourse() {
        return course;
    }

    public void setCourse(entities.Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof entities.Registration)) {
            return false;
        }
        entities.Registration other = (entities.Registration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (student == null || course == null) {
            return "";
        } else {
            return student.getName() + "-" + course.getSubject() + "-" + date;
        }
    }

    public Registration() {
    }

    public Registration(Date date, entities.Student student, entities.Course course) {
        this.date = date;
        this.student = student;
        this.course = course;
    }

}
