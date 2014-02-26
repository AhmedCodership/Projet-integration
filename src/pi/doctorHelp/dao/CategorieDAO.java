/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import pi.doctorHelp.entites.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.doctorHelp.util.MyConnection;

/**
 *
 * @author HP
 */
public class CategorieDAO extends AbstractDAO<Categorie> {

    @Override
    public void insert(Categorie obj) {
        String requete = "insert into categories (nom ,description) values (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            
            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getDescription());
            
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(CategorieDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        } 
    }

    @Override
    public void delete(Categorie obj) {
          String requete = "Delete from categories where id_M="+obj.getId_Cat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CategorieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Categorie obj) {
         String requete = "update categorie set nom =? where id_Cat=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             ps.setString(1, obj.getNom());
             ps.setInt(2, obj.getId_Cat());
             ps.executeUpdate();
             System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
          
        }
    }

    @Override
    public List<Categorie> lister() throws SQLException {
        List<Categorie> listeCategorie = new ArrayList<Categorie>();
        String requete = "select * from categories";
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Categorie m =new Categorie();
                m.setId_Cat(resultat.getInt(1));
                m.setNom(resultat.getString(2));
                m.setDescription(resultat.getString(3));  
                listeCategorie.add(m);
            }
            return listeCategorie;}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }
}
    

