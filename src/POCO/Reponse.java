/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POCO;

import java.util.Date;

/**
 *
 * @author mahmoud
 */
public class Reponse {
public int id_R;
public String reponse;
public Date date;
public int id_Q;
public int id_M;

    public Reponse() {
    }

    public Reponse(int id_R, String reponse, Date date, int id_Q, int id_M) {
        this.id_R = id_R;
        this.reponse = reponse;
        this.date = date;
        this.id_Q = id_Q;
        this.id_M = id_M;
    }

    public Date getDate() {
        return date;
    }

    public int getId_M() {
        return id_M;
    }

    public int getId_Q() {
        return id_Q;
    }

    public int getId_R() {
        return id_R;
    }

    public String getReponse() {
        return reponse;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
    }

    public void setId_Q(int id_Q) {
        this.id_Q = id_Q;
    }

    public void setId_R(int id_R) {
        this.id_R = id_R;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reponse other = (Reponse) obj;
        if (this.id_R != other.id_R) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
