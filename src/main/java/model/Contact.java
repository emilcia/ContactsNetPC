package model;

public class Contact {
	
	private long id;
    private String name;
    private String surname;
	private String email;
    private String password;
   // private int phone;
    
//    public Contact(String name, String surname, int phone) {
//        this.name = name;
//        this.surname = surname;
//        this.phone = phone;
//    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
//	public int getPhone() {
//		return phone;
//	}
//	public void setPhone(int phone) {
//		this.phone = phone;
//	}
}
