package web.app.Notebook;

public class User {
		protected int id;
		protected String surname;
		protected String name;
		protected int age;
		protected String gender;
		protected String phone_number;
		
		public String getPhone_number() {
			return phone_number;
		}

		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}

		public User(){
			
		}
		
		public User(int id){
			this.id = id;
		}
		
		public User(int id, String surname, String name, int age, String gender, String phone_number){
			this(surname, name, age, gender, phone_number);
			this.id = id;
		}
		
		public User(String surname, String name, int age, String gender, String phone_number){
			this.surname = surname;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.phone_number = phone_number;
		}
		
		public int getId(){
			return id;
		}
		
		public void setId(int id){
			this.id = id;
		}
		
		public String getSurname() {
	        return surname;
	    }
	 
	    public void setSurname(String surname) {
	        this.surname = surname;
	    }
	    
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    public int getAge() {
	        return age;
	    }
	 
	    public void setAge(int age) {
	        this.age = age;
	    }
	    
	    public String getGender() {
	        return gender;
	    }
	 
	    public void setGender(String gender) {
	        this.gender = gender;
	    }
	    
	  
}		
		
		
		
		
		
		
		

