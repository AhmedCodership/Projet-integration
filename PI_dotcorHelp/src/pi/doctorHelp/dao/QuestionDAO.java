/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import pi.doctorHelp.entites.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.doctorHelp.util.MyConnection;

/**
 *
 * @author HP
 */
public class QuestionDAO extends AbstractDAO<Question>{

    @Override
    public void insert(Question obj) {
          String requete = "insert into Questions (Titre_Q,ques,Date,id_M) values (?,?,?,?)";
        DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getTitle_Q());
            ps.setString(2, obj.getQues());
            ps.setString(3, df.format(obj.getDate()));
            ps.setString(4, df.format(obj.getId_M()));
           
            
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
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Question obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                Q.setId_Q(resultat.getInt(1));
                Q.setTitle_Q(resultat.getString(2));
                Q.setQues(resultat.getString(3));
                Q.setDate(df.format(resultat.getString(4)));
               
                
            }
            return listeArticle;
}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Questions "+ex.getMessage());
            return null;
        }
    }
    
}
