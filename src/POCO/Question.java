/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POCO;

import java.util.Date;


public class Question {
public int id_Q;
public String ques;
public Date date_Q;
public int id_M;
public String title_Q;

    public Question() {
    }

    public Question(int id_Q, String ques, Date date, int id_M, String title_Q) {
        this.id_Q = id_Q;
        this.ques = ques;
        this.date_Q = date;
        this.id_M = id_M;
        this.title_Q = title_Q;
    }

    public Date getDate() {
        return date_Q;
    }

    public String getTitle_Q() {
        return title_Q;
    }

    public int getId_M() {
        return id_M;
    }

    public void setTitle_Q(String title_Q) {
        this.title_Q = title_Q;
    }

    public int getId_Q() {
        return id_Q;
    }

    public String getQues() {
        return ques;
    }

    public void setDate(Date date) {
        this.date_Q = date;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
    }

    public void setId_Q(int id_Q) {
        this.id_Q = id_Q;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }
    


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id_Q != other.id_Q) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public void setDate(String format) {
       this.date_Q=date_Q;
    }


}
