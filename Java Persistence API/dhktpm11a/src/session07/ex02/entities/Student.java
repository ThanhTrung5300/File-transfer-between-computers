package session07.ex02.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@Column(name="studentId")
	private long studentId;
	
	@Column(name="studentName",length=150,nullable=false)
	private String studentName;
	
	private Date dateOfBirth;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private StudentClass cls;
	
	@OneToOne
	private Address address;
	
	public Student() {
	}

	public Student(long studentId, String studentName, Date dateOfBirth) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
