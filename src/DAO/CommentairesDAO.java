/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import POCO.Commentaires;
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
public class CommentairesDAO extends AbstractDAO<Commentaires>{

    @Override
    public void insert(Commentaires obj) {
        String requete = "insert into commentaires (contenu_Com ,date_Com,id_M,id_A) values (?,?,?,?)";
        DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getContenu_Com());
            ps.setString(2,df.format(obj.getDate_Com()));
            ps.setInt(1, obj.getId_M());
            ps.setInt(1, obj.getId_A());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(CommentairesDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        } 
    }

    @Override
    public void delete(Commentaires obj) {
        String requete = "Delete from commentaires where id_Com="+obj.getId_Com();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentairesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Commentaires obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Commentaires> lister() throws SQLException {
        List<Commentaires> listeCategorie = new ArrayList<Commentaires>();
        String requete = "select * from commentaires";
        DateFormat df = new SimpleDateFormat();
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                   
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Commentaires c =new Commentaires();
                c.setId_Com(resultat.getInt(1));
                c.setContenu_Com(resultat.getString(2));
                c.setId_A(resultat.getInt(3));
                c.setId_M(resultat.getInt(3));
                c.setDate_Com(resultat.getString(3));
                listeCategorie.add(c);
            }
            return listeCategorie;}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }

}
