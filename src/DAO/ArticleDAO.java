/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import POCO.Article;
import POCO.Question;
import POCO.Reponse;
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


/**
 *
 * @author mahmoud
 */
public class ArticleDAO extends AbstractDAO<Article>{

    @Override
    public void insert(Article obj) {
      String requete = "insert into article (Titre_A,Contenu_A,Date_A,Image_A) values (?,?,?,?)";
      DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getTitle_A());
            ps.setString(2, obj.getContenu_A());
            ps.setString(3, df.format(obj.getDate_A()));
            ps.setString(4, obj.getImage_A());
           
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    @Override
    public void delete(Article obj) {
        String requete = "Delete from articles where id_A="+obj.getId_A();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override   
    public void update(Article obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    
    @Override
    public List<Article> lister() throws SQLException {
        List<Article> listeArticle = new ArrayList<Article>();
        String requete = "select * from Articles";
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                 
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Article A =new Article();
                A.setTitle_A(resultat.getString(1));
                A.setContenu_A(resultat.getString(2));
//                A.setDate_A(resultat.getString(3));
//                A.setImage_A(resultat.getString(4));
//                
//            }
//            return listeArticle;
//}
//            catch (SQLException ex) {
//           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
//            return null;
//        }
    }

}
