/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

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
public class ReponseDAO extends AbstractDAO<Reponse> {

    @Override
    public void insert(Reponse obj) {
        String requete = "insert into Reponses (Reponse,Date) values (?,?)";
        DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getReponse());
            ps.setString(2, df.format(obj.getDate()));
           
           
           
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }

    @Override
    public void delete(Reponse obj) {
         String requete = "Delete from Reponses where id_A="+obj.getId_R();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Reponse obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Reponse> lister() throws SQLException {
             List<Reponse> listeReponse = new ArrayList<Reponse>();
        String requete = "select * from Reponse";
        DateFormat df = new SimpleDateFormat();
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                 
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Reponse r =new Reponse();
                r.setReponse(resultat.getString(1));
                r.setDate(df.format(resultat.getString(2)));
               
               
                
            }
            return listeReponse;
}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots "+ex.getMessage());
            return null;
        }
    }

}