  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Contacts List</h1>  
<table>  
<tr><th>Id</th><th>Name</th><th>Surname</th><th>Email</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="contact" items="${list}">   
   <tr>  
   <td>${contact.id}</td>  
   <td>${contact.name}</td>  
   <td>${contact.surname}</td>  
   <td>${contact.email}</td>  
   <td><a href="editcontact/${contact.id}">Edit</a></td>  
   <td><a href="delete/${contact.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="form">Add New Contact</a>  