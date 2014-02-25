/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.QuestionDAO;
import pi.doctorHelp.entites.Question;

/**
 *
 * @author HP
 */
public class QuestionMetier {
       public QuestionMetier(){
        
    }
    public void afficherQuestion() throws SQLException{
      QuestionDAO qdao = new  QuestionDAO();
      qdao.lister();
    }
     public void ajouterQuestion(Question obj) {
      QuestionDAO qdao = new  QuestionDAO();
      qdao.insert(obj);
    }
      public void supprimerQuestion(Question obj) {
      QuestionDAO qdao = new  QuestionDAO();
      qdao.delete(obj);
    }
       public void modifierQuestion(Question obj) {
      QuestionDAO qdao = new  QuestionDAO();
      qdao.update(obj);
       } 
}
