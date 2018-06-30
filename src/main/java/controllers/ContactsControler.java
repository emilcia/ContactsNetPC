package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Contact;
import service.ContactMngr;


@Controller  
public class ContactsControler { 
	
    @Autowired  
    ContactMngr contactManager;//will inject dao from xml file  
    

	@RequestMapping("/")
	public String home(ModelMap map) {
	        return "index";
	}

    @RequestMapping("/form")  
    public ModelAndView showform(){  
        return new ModelAndView("form","command",new Contact());  
    }  
 
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("contact") Contact contact){  
        contactManager.save(contact);  
        return new ModelAndView("redirect:/contacts");
    }  
    @RequestMapping("/contacts")  
    public ModelAndView viewContacts(){  
        List<Contact> list=contactManager.getContacts();  
        return new ModelAndView("contacts","list",list);  
    }  
    @RequestMapping(value="/editcontact/{id}")  
    public ModelAndView edit(@PathVariable int id){  
        Contact contact=contactManager.getById(id);  
        return new ModelAndView("editform","command",contact);  
    }  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("contact") Contact contact){  
        contactManager.update(contact);  
        return new ModelAndView("redirect:/contacts");  
    }  
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        contactManager.delete(id);  
        return new ModelAndView("redirect:/contacts");  
    }  
  
}  
