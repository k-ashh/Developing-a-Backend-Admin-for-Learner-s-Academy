package classes;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classes 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String classname;
	private String roomno;
	private String section;
	
	public Classes(int id) {
		super();
		this.id = id;
	}
	public Classes() {
		
	}
	public Classes(String classname, String roomno, String section) {
		super();
		this.classname = classname;
		this.roomno = roomno;
		this.section = section;
	}


	public Classes(int id, String classname, String roomno, String section) {
		super();
		this.id = id;
		this.classname = classname;
		this.roomno = roomno;
		this.section = section;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", classname=" + classname + ", roomno=" + roomno + ", section=" + section + "]";
	}
	
}