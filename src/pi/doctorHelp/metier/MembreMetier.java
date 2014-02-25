/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.MembreDAO;
import pi.doctorHelp.entites.Membre;


/**
 *
 * @author HP
 */
public class MembreMetier {
    public MembreMetier(){
        
    }
    public void afficherMembre() throws SQLException{
      MembreDAO mdao = new  MembreDAO();
      mdao.lister();
    }
     public void ajouterMembre(Membre obj) {
      MembreDAO mdao = new  MembreDAO();
      mdao.insert(obj);
    }
      public void supprimerMembre(Membre obj) {
      MembreDAO mdao = new  MembreDAO();
      mdao.delete(obj);
    }
       public void modifierMembre(Membre obj) {
      MembreDAO mdao = new  MembreDAO();
      mdao.update(obj);
       }
}
