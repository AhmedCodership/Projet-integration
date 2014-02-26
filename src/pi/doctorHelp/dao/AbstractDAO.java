/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.doctorHelp.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public abstract class AbstractDAO <T> {

    public abstract void insert(T obj);

    public abstract void delete(T obj);

    public abstract void update(T obj);
//public abstract List<T> findArticleByid_Cat(int id_Cat);
    public abstract List<T> lister() throws SQLException;
    
}
