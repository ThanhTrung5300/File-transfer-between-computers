package session07.ex02.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentClass")
public class StudentClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long classId;
	@Column(name="className",length=200,nullable=false)
	private String classTitle;
	
	@OneToMany(mappedBy="cls",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Student>dssv;
	
	public StudentClass() {
		this(1l,"no-name");
	}
	
	public StudentClass(long classId, String classTitle) {
		this.classId = classId;
		this.classTitle = classTitle;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public String getClassTitle() {
		return classTitle;
	}
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	@Override
	public String toString() {
		return classTitle;
	}
}
