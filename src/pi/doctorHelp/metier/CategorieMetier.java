/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.CategorieDAO;
import pi.doctorHelp.entites.Categorie;

/**
 *
 * @author HP
 */
public class CategorieMetier {
    public CategorieMetier(){
        
    }
    public void afficherCategorie() throws SQLException{
      CategorieDAO cdao = new  CategorieDAO();
      cdao.lister();
    }
     public void ajouterCategorie(Categorie obj) {
      CategorieDAO cdao = new  CategorieDAO();
      cdao.insert(obj);
    }
      public void supprimerCategorie(Categorie obj) {
      CategorieDAO cdao = new  CategorieDAO();
      cdao.delete(obj);
    }
       public void modifierCategorie(Categorie obj) {
      CategorieDAO cdao = new  CategorieDAO();
      cdao.update(obj);
       }
}
