package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentClass")
@NamedQueries({
	@NamedQuery(name="StudentClass.findAll",query="select sc from StudentClass sc"),
	@NamedQuery(name="StudentClass.findById",
		query="select sc from StudentClass sc where sc.classId=:id")
})
public class StudentClass {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long classId;
	@Column(name="className",length=200,nullable=false)
	private String classTitle;

	@OneToMany(mappedBy="cls",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Student>dssv;

	public StudentClass() {
		this("no-name");
	}

	public StudentClass(String classTitle) {
		this.classTitle = classTitle;
	}
	public long getClassId() {
		return classId;
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
