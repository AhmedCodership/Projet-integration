/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POCO;


public class Categorie {
public int id_Cat;
public String nom;
public String description;

    public Categorie() {
    }

    public Categorie(int id_Cat, String nom, String description) {
        this.id_Cat = id_Cat;
        this.nom = nom;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getId_Cat() {
        return id_Cat;
    }

    public String getNom() {
        return nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_Cat(int id_Cat) {
        this.id_Cat = id_Cat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorie other = (Categorie) obj;
        if (this.id_Cat != other.id_Cat) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
