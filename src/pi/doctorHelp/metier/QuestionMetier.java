/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.doctorHelp.dao.QuestionDAO;
import pi.doctorHelp.dao.ReponseDAO;
import pi.doctorHelp.entites.Question;
import pi.doctorHelp.entites.Reponse;

/**
 *
 * @author HP
 */
public class QuestionMetier {
    Vector <Reponse> r= new Vector<Reponse>() {};
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
       ReponseDAO repdao = new ReponseDAO();
      qdao.delete(obj);
     
        try {
            List<Reponse> rep =repdao.chercherReponse(obj.getId_Q());
            for(int i=0;i<rep.size();i++){
                         repdao.delete(rep.get(i));

               }
            qdao.delete(obj);
     
    
        } catch (SQLException ex) {
            Logger.getLogger(QuestionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void FindQuestion() throws SQLException{
      QuestionDAO qdao = new  QuestionDAO();
      qdao.lister();
    }
      
       public void modifierQuestion(Question obj) {
      QuestionDAO qdao = new  QuestionDAO();
      qdao.update(obj);
       } 
}
