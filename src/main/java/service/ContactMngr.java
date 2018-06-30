package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Contact;


public class ContactMngr {
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(Contact contact){  
	    String sql="insert into contact(name,surname, email)"+   
	          "values('"+contact.getName()+"','"+contact.getSurname()+"','"+contact.getEmail()+"')";  
	    return template.update(sql);  
	}  
	public int update(Contact contact){  
	    String sql="update contact set name='"+contact.getName()+"', surname='"+contact.getSurname()+"',"+
	          "email='"+contact.getEmail()+"' where id="+contact.getId()+"";  
	    return template.update(sql);  
	}  
	public int delete(int id){  
	    String sql="delete from contact where id="+id+"";  
	    return template.update(sql);  
	}  
	public Contact getById(int id){  
	    String sql="select * from contact where id=?";  
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Contact>(Contact.class));  
	}  
	public List<Contact> getContacts(){  
	    return template.query("select * from contact",new RowMapper<Contact>(){  
	        public Contact mapRow(ResultSet rs, int row) throws SQLException {  
	            Contact c= new Contact();  
	            c.setId(rs.getInt(1));  
	            c.setName(rs.getString(2));  
	            c.setSurname(rs.getString(3));  
	            c.setEmail(rs.getString(4));  
	            return c;  
	        }  
	    });  
	}  
}
