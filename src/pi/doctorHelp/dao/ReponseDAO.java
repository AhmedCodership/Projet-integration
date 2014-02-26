/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import pi.doctorHelp.entites.Reponse;
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
public class ReponseDAO extends AbstractDAO<Reponse> {

    @Override
    public void insert(Reponse obj) {
        String requete = "insert into Reponses (Reponse,Date,id_Q,id_M) values (?,?,?,?)";
        DateFormat df = new SimpleDateFormat();
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);

            //inject
            ps.setString(1, obj.getReponse());
            ps.setString(2, df.format(obj.getDate()));
            ps.setInt(1, obj.getId_Q());
            ps.setInt(1, obj.getId_M());
           
           
           
            
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
            Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Reponse obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reponse> lister() throws SQLException {
         List<Reponse> listeReponse = new ArrayList<Reponse>();
        String requete = "select * from Reponses";
        DateFormat df = new SimpleDateFormat();
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                 
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Reponse r =new Reponse();
                r.setId_R(resultat.getInt(1));
                r.setReponse(resultat.getString(2));
                r.setDate(df.format(resultat.getString(3)));
                r.setId_Q(resultat.getInt(4));
                r.setId_M(resultat.getInt(5));
               
               
                
            }
            return listeReponse;
}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Reponses "+ex.getMessage());
            return null;
        }
    }
    
    public List<Reponse>chercherReponse(int id) throws SQLException {
         List<Reponse> r = new ArrayList<Reponse>();
        String requete = "select * from Reponse where id="+id;
        try{
         PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
                DateFormat df = new SimpleDateFormat();
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                Reponse rep =new Reponse();
                rep.setId_R(resultat.getInt(1));
                rep.setReponse(resultat.getString(2));
                rep.setDate(df.format(resultat.getString(3)));
                rep.setId_Q(resultat.getInt(4));
                rep.setId_M(resultat.getInt(5));
                r.add(rep);
      ;            
            }
            return r;
}
            catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Questions "+ex.getMessage());
            return null;
        }
    }
    
}
