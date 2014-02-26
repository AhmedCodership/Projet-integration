/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import POCO.Article;
import POCO.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyConnection;
import java.util.Date;

/**
 *
 * @author mahmoud
 */
public class QuestionDAO extends AbstractDAO<Question> {

    @Override
    public void insert(Question obj) {
        String requete = "insert into Questions (Titre_Q,ques,Date) values (?,?,?)";
        DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getTitle_Q());
            ps.setString(2, obj.getQues());
            ps.setString(3, df.format(obj.getDate()));
           
           
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    @Override
    public void delete(Question obj) {
        String requete = "Delete from Questions where id_A="+obj.getId_Q();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Question obj) {
       
    }

    @Override
    public List<Question> lister() throws SQLException {
        List<Question> listeArticle = new ArrayList<Question>();
        String requete = "select * from Questions";
        DateFormat df = new SimpleDateFormat();
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                 
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Question Q =new Question();
                Q.setTitle_Q(resultat.getString(1));
                Q.setQues(resultat.getString(2));
                Q.setDate(df.format(resultat.getString(3)));
               
                
            }
            return listeArticle;
}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
    
    

}