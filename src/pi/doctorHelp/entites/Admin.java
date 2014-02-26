/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.entites;

/**
 *
 * @author HP
 */
public class Admin {
public int id;
public String login;
public String password;
public String mail;
public String image;

    public Admin() {
    }

    public Admin(int id, String login, String password, String mail, String image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.image = image;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin other = (Admin) obj;
        if (this.id != other.id) {
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

