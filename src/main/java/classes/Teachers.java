package classes;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teachers {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String name;
		private String email;
		private String address;
		private String subject;
		private Date createdAt;
		private Date modifiedAt;

		// constructor
		public Teachers() {}

		public Teachers(int id) 
		{
			this.id = id;
		}

		public Teachers(String name,String email, String address,String subject) 
		{
			super();
			this.name = name;
			this.email = email;
			this.address= address;
			this.subject=subject;
			this.createdAt =  new Date();
			this.modifiedAt = new Date();
		}

		public Teachers(int id, String name,String email, String address,String subject) 
		{
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.address = address;
			this.subject=subject;
			this.createdAt =  new Date();
			this.modifiedAt = new Date();
		}


		public int getId() 
		{
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public String getEmail() 
		{
			return email;
		}

		public void setEmail(String email) 
		{
			this.email = email;
		}

		public String getAddress() 
		{
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		public String getSubject() 
		{
			return subject;
		}

		public void setSubject(String subject) 
		{
			this.subject = subject;
		}

		public Date getCreatedAt() 
		{
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) 
		{
			this.createdAt = createdAt;
		}

		public Date getModifiedAt() 
		{
			return modifiedAt;
		}

		public void setModifiedAt(Date modifiedAt) 
		{
			this.modifiedAt = modifiedAt;
		}

		@Override
		public String toString() {
			return "Teachers [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", subject="
					+ subject + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
		}

}