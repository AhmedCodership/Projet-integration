/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import POCO.Membre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.MyConnection;

/**
 *
 * @author mahmoud
 */
public class MembreDAO extends AbstractDAO<Membre>{

    @Override
    public void insert(Membre obj) {
       String requete = "insert into membres (login,password,nom ,prenom,age,pays,address,tel,mail,image) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getLogin());
            ps.setString(2, obj.getPassword());
            ps.setString(3, obj.getNom());
            ps.setString(4, obj.getPrenom());
            ps.setInt(5, obj.getAge());
            ps.setString(6, obj.getPays());
            ps.setString(7, obj.getAddress());
            ps.setString(8, obj.getTel());
            ps.setString(9, obj.getMail());
            ps.setString(10, obj.getImage());
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    @Override
    public void delete(Membre obj) {
       String requete = "Delete from membres where id_M="+obj.getId_M();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    

    
    public List<Membre> lister() throws SQLException {
        List<Membre> listeMembre = new ArrayList<Membre>();
        String requete = "select * from membres";
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Membre m =new Membre();
                m.setId_M(resultat.getInt(1));
                m.setLogin(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setNom(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setAge(resultat.getInt(6));
                m.setPays(resultat.getString(7));
                m.setAddress(resultat.getString(8));
                m.setTel(resultat.getString(9));
                m.setLogin(resultat.getString(10));
                m.setMail(resultat.getString(11));
                m.setImage(resultat.getString(12));
                listeMembre.add(m);
            }
            return listeMembre;}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
        }

    @Override
    public void update(Membre obj) {
        String requete = "update membres set password =? where id_M=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             ps.setString(1, obj.getPassword());
             ps.setInt(2, obj.getId_M());
             ps.executeUpdate();
             System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
           // Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
