/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import pi.doctorHelp.entites.Membre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pi.doctorHelp.entites.Article;
import pi.doctorHelp.util.MyConnection;

/**
 *
 * @author HP
 */
public class MembreDAO extends AbstractDAO<Membre> {

    @Override
    public void insert(Membre obj) {
        String requete = "insert into membres (login,password,nom ,prenom,age,pays,address,mail,image) values (?,?,?,?,?,?,?,?,?)";
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
            ps.setString(8, obj.getMail());
            ps.setString(9, obj.getImage());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {

            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void delete(Membre obj) {
        String requete = "Delete from membres where id_M=" + obj.getId_M();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());

        }

    }

    @Override
    public List<Membre> lister() throws SQLException {
        List<Membre> listeMembre = new ArrayList<Membre>();
        String requete = "select * from membres";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            ResultSet resultat = ps.executeQuery(requete);
            while (resultat.next()) {
                Membre m = new Membre();
                m.setId_M(resultat.getInt(1));
                m.setLogin(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setNom(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setAge(resultat.getInt(6));
                m.setPays(resultat.getString(7));
                m.setAddress(resultat.getString(8));

                m.setLogin(resultat.getString(9));
                m.setMail(resultat.getString(10));
                m.setImage(resultat.getString(11));
                listeMembre.add(m);
            }
            return listeMembre;
        } catch (SQLException ex) {

            System.out.println("erreur lors du chargement des Membres " + ex.getMessage());
            return null;
        }
    }

    public Membre findMembreByid_M(int id_M) {
        Membre m = new Membre();

        String requete = "select * from membres where id_M = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_M);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                m.setId_M(resultat.getInt(1));
                m.setLogin(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setNom(resultat.getString(4));
                m.setAge(resultat.getInt(6));
                m.setPays(resultat.getString(7));
                m.setAddress(resultat.getString(8));

                m.setLogin(resultat.getString(9));
                m.setMail(resultat.getString(10));
                m.setImage(resultat.getString(11));
                ;
            }
            return m;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return null;
        }
    }

    public Membre findMembreBynom(String nom) {
        Membre m = new Membre();

        String requete = "select * from membres where nom = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                m.setId_M(resultat.getInt(1));
                m.setLogin(resultat.getString(2));
                m.setPassword(resultat.getString(3));
                m.setNom(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setAge(resultat.getInt(6));
                m.setPays(resultat.getString(7));
                m.setAddress(resultat.getString(8));

                m.setLogin(resultat.getString(9));
                m.setMail(resultat.getString(10));
                m.setImage(resultat.getString(11));
                ;
            }
            return m;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return null;
        }
    }

    public List<Article> findArticle(String critere) {
        List<Article> ListeA = new ArrayList<Article>();
      
        String requete = "select * from articles where Titre_A ='" + critere + "'";
        //String requete = "select * from articles where Titre_A =?";
        try {
            // PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            Statement ps = MyConnection.getInstance().createStatement();

            ResultSet resultat = ps.executeQuery(requete);
            while (resultat.next()) {
                  Article a = new Article();
                a.setId_A(resultat.getInt(1));
                a.setTitre_A(resultat.getString(2));
                a.setContenu_A(resultat.getString(3));
                a.setDate_A(resultat.getString(4));
                a.setImage_A(resultat.getString(5));
                a.setId_M(resultat.getInt(6));
                a.setId_Cat(resultat.getInt(7));
                ListeA.add(a);
            }
            return ListeA;
        } catch (SQLException ex) {

            System.out.println("erreur lors de la recherche de l'article " + ex.getMessage());
            return null;
        }
    }
}
