/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.CommentaireDAO;
import pi.doctorHelp.entites.Commentaire;


/**
 *
 * @author HP
 */
public class CommentaireMetier {
       public CommentaireMetier(){
        
    }
    public void afficherCommentaire() throws SQLException{
      CommentaireDAO cdao = new  CommentaireDAO();
      cdao.lister();
    }
     public void ajouterCommentaire(Commentaire obj) {
      CommentaireDAO cdao = new  CommentaireDAO();
      cdao.insert(obj);
    }
      public void supprimerCommentaire(Commentaire obj) {
      CommentaireDAO cdao = new  CommentaireDAO();
      cdao.delete(obj);
    }
       public void modifierCommentaire(Commentaire obj) {
      CommentaireDAO cdao = new  CommentaireDAO();
      cdao.update(obj);
       }
}
