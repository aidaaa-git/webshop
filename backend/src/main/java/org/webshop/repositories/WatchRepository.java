package org.webshop.repositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.webshop.models.Watch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WatchRepository {
    private JdbcTemplate jdbcTemplate;
    public WatchRepository (JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Watch> getWatchesPerCategory(Integer categoryId){
        String query = "select w.id, w.name, w.brand, w.price\n" +
                "from watch as w\n" +
                "inner join subcategory as s\n" +
                "on w.subcategoryId = s.id \n" +
                "where s.categoryId = ? ";
        List<Watch> watches = new ArrayList<>(jdbcTemplate.query(query, new Object[]{categoryId}, (rs, rowNum) -> {
            return new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getFloat("price"));
        }));
        return watches;
    }
    public List<Watch> getWatchesPerSubcategory(Integer subcategoryId){
        String query = "select id, name, brand, price, subcategoryId, quantity, specifications \n" +
                "from watch \n" +
                "where subcategoryId = " + subcategoryId;
        List<Watch> watches = new ArrayList<>(jdbcTemplate.query(query, (rs, rowNum) -> {
            return new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getFloat("price"), rs.getInt("subcategoryId"), rs.getInt("quantity"), rs.getString("specifications"));
        }));
        return watches;
    }

    public void addWatch(Watch watch ){
        String sql = "INSERT INTO watch (name, brand, price)\n" +
                "VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, watch.getName(), watch.getBrand(), watch.getPrice());
    }
    public void updateWatch(Watch watch){
        String sql = "UPDATE watch SET name = ?, brand = ?, price = ? WHERE id =" + watch.getId();
        jdbcTemplate.update(sql, watch.getName(), watch.getBrand(), watch.getPrice());
    }
    public void deleteWatch(Integer id){
        String sql = "DELETE FROM watch WHERE id =?";
        jdbcTemplate.update(sql, id);
    }
    public Watch getWatchById(Integer id) {
        String sql = "SELECT * FROM watch WHERE id = ?";
       return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
           Watch watch = new Watch();
           watch.setId(rs.getInt("id"));
           watch.setName(rs.getString("name"));
           watch.setBrand(rs.getString("brand"));
           watch.setPrice(rs.getFloat("price"));
           watch.setSubcategoryId(rs.getInt("subcategoryId"));
           watch.setQuantity(rs.getInt("quantity"));
           watch.setSpecifications(rs.getString("specifications"));
           return watch;

       });
    }
   /* public List<Watch> getWatchById(Integer id){
        String query = "SELECT * FROM watch WHERE id=" + id;
        List<Watch> watch = new ArrayList<>(jdbcTemplate.query(query, (rs, rowNum) -> {
            return new Watch(rs.getInt("id"), rs.getString("name"), rs.getString("brand"), rs.getFloat("price"), rs.getInt("subcategoryId"), rs.getInt("quantity"), rs.getString("specifications"));
        }));
        return watch;
    }*/

}




