/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import pi.doctorHelp.entites.Article;
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
public class ArticleDAO extends AbstractDAO<Article>{

    @Override
    public void insert(Article obj) {
         String requete = "insert into articles (Titre_A,Contenu_A,Date_A,Image_A) values (?,?,?,?,?,?)";
      DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            
            ps.setString(1, obj.getTitre_A());
            ps.setString(2, obj.getContenu_A());
            ps.setString(3, df.format(obj.getDate_A()));
            ps.setString(4, obj.getImage_A());
            ps.setInt(5, obj.getId_M());
            ps.setInt(6, obj.getId_Cat());
           
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           
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
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                A.setId_A(resultat.getInt(1));
                A.setTitre_A(resultat.getString(2));
                A.setContenu_A(resultat.getString(3));
                A.setDate_A(resultat.getString(4));
                A.setImage_A(resultat.getString(5));
                A.setId_M(resultat.getInt(6));
                A.setId_Cat(resultat.getInt(7));
                
            }
            return listeArticle;
           }
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des articles "+ex.getMessage());
            return null;
        }
    }
  
   public List<Article> findArticleByid_Cat(int id_Cat){
    List<Article> listeArticle = new ArrayList<>();
 
     String requete = "select * from articles where id_Cat = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_Cat);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                Article art = new Article();
                art.setId_Cat(resultat.getInt(7));
                
            }
            return listeArticle;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du article "+ex.getMessage());
            return null;
        }
} 
    
}
