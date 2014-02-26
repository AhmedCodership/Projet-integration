/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.ReponseDAO;
import pi.doctorHelp.entites.Reponse;

/**
 *
 * @author HP
 */
public class ReponseMetier {
    public ReponseMetier(){
        
    }
    public void afficherReponse() throws SQLException{
      ReponseDAO rdao = new  ReponseDAO();
      rdao.lister();
    }
     public void ajouterReponse(Reponse obj) {
      ReponseDAO rdao = new  ReponseDAO();
      rdao.insert(obj);
    }
      public void supprimerReponse(Reponse obj) {
      ReponseDAO rdao = new  ReponseDAO();
      rdao.delete(obj);
    }
       public void modifierReponse(Reponse obj) {
      ReponseDAO rdao = new  ReponseDAO();
      rdao.update(obj);
       }   
}
