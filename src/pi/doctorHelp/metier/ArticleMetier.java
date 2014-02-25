/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.metier;

import java.sql.SQLException;
import pi.doctorHelp.dao.ArticleDAO;
import pi.doctorHelp.entites.Article;


/**
 *
 * @author HP
 */
public class ArticleMetier {
    public ArticleMetier(){
        
    }
    public void afficherArticle() throws SQLException{
      ArticleDAO adao = new  ArticleDAO();
      adao.lister();
    }
     public void ajouterCategorie(Article obj) {
      ArticleDAO adao = new  ArticleDAO();
      adao.insert(obj);
    }
      public void supprimerArticle(Article obj) {
      ArticleDAO adao = new  ArticleDAO();
      adao.delete(obj);
    }
       public void modifierArticle(Article obj) {
      ArticleDAO adao = new  ArticleDAO();
      adao.update(obj);
       }
}
