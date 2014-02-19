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
public class Article {
public int id_A;
public String contenu_A;
public Date date_A;
public String image_A;
public int id_M;
public int id_Cat;
public String title_A;

    public Article() {
    }

    public String getContenu_A() {
        return contenu_A;
    }

    public String getTitle_A() {
        return title_A;
    }
    
    public Date getDate_A() {
        return date_A;
    }

    public int getId_A() {
        return id_A;
    }

    public int getId_Cat() {
        return id_Cat;
    }

    public int getId_M() {
        return id_M;
    }

    public String getImage_A() {
        return image_A;
    }

    public Article(int id_A, String contenu_A, Date date_A, String image_A, int id_M, int id_Cat) {
        this.id_A = id_A;
        this.contenu_A = contenu_A;
        this.date_A = date_A;
        this.image_A = image_A;
        this.id_M = id_M;
        this.id_Cat = id_Cat;
    }

    public void setContenu_A(String contenu_A) {
        this.contenu_A = contenu_A;
    }

    public void setDate_A(Date date_A) {
        this.date_A = date_A;
    }

    public void setTitle_A(String title_A) {
        this.title_A= title_A;
    }
    
    public void setId_A(int id_A) {
        this.id_A = id_A;
    }

    public void setId_Cat(int id_Cat) {
        this.id_Cat = id_Cat;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
    }

    public void setImage_A(String image_A) {
        this.image_A = image_A;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.id_A != other.id_A) {
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
