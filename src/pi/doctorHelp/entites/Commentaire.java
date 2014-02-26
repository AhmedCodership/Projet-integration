/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.entites;

import java.util.Date;

/**
 *
 * @author HP
 */
public class Commentaire {
   public int id_Com;
public String contenu_Com;
public Date date_Com;
public int id_M;
public int id_A;

    public Commentaire() {
    }

    public Commentaire(int id_Com, String contenu_Com, Date date_Com, int id_M, int id_A) {
        this.id_Com = id_Com;
        this.contenu_Com = contenu_Com;
        this.date_Com = date_Com;
        this.id_M = id_M;
        this.id_A = id_A;
    }

    public String getContenu_Com() {
        return contenu_Com;
    }

    public Date getDate_Com() {
        return date_Com;
    }

    public int getId_A() {
        return id_A;
    }

    public int getId_Com() {
        return id_Com;
    }

    public int getId_M() {
        return id_M;
    }

    public void setContenu_Com(String contenu_Com) {
        this.contenu_Com = contenu_Com;
    }

    public void setDate_Com(Date date_Com) {
        this.date_Com = date_Com;
    }

    public void setId_A(int id_A) {
        this.id_A = id_A;
    }

    public void setId_Com(int id_Com) {
        this.id_Com = id_Com;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
    }
     public void setDate_Com(String string) {
       this.date_Com=date_Com;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commentaire other = (Commentaire) obj;
        if (this.id_Com != other.id_Com) {
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
