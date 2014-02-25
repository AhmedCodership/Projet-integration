/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.entites;

/**
 *
 * @author HP
 */
public class Membre {
public int id_M;
public String login;
public String password;
public String nom;
public String prenom;
public int age ;
public String pays;
public String address;
public String tel;
public String mail;
public String image;

    public Membre() {
    }

    public Membre(int id_M, String login, String password, String nom, String prenom, int age, String pays, String address, String tel, String mail, String image) {
        this.id_M = id_M;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.pays = pays;
        this.address = address;
        this.tel = tel;
        this.mail = mail;
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getId_M() {
        return id_M;
    }

    public String getImage() {
        return image;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPays() {
        return pays;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId_M(int id_M) {
        this.id_M = id_M;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membre other = (Membre) obj;
        if (this.id_M != other.id_M) {
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

