package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.StudentClass;

public class Driver {

	public static void main(String[] args){
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("teo-orm");
		EntityManager em = emFactory.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		try {
			transaction.begin();
			StudentClass cls=new StudentClass("Dai hoc KTPM 11B");
			//save
			em.persist(cls);

			//StudentClass sc = em.find(StudentClass.class, new Long(2));
			//System.out.println(sc.getClassId()+"\t"+sc.getClassTitle());
			//			if(sc!=null) em.remove(sc);

			/*	Query q1 = em.createNamedQuery("StudentClass.findAll",StudentClass.class);
			List<StudentClass> lst = q1.getResultList();
			for(StudentClass s:lst) {
				System.out.println(s.getClassTitle());
			}*/

			/*Query q2 = em.createQuery("select sc from StudentClass sc");
			List<StudentClass> lst = q2.getResultList();
			for(StudentClass s:lst) {
				System.out.println(s.getClassTitle());
			}*/
			/*Query q3 = em.createNamedQuery("StudentClass.findById",StudentClass.class);
			q3.setParameter("id", new Long(1));
			StudentClass st = (StudentClass) q3.getSingleResult();
			System.out.println(st);*/

			/*Query q4 = 
					em.createQuery("select sc from StudentClass sc where sc.classId=?1");
			q4.setParameter(1, new Long(13));
			StudentClass st = (StudentClass) q4.getSingleResult();
			System.out.println(st);*/

//			String sql="select * from StudentClass";
//			Query q5 = em.createNativeQuery(sql, StudentClass.class);
//			List<StudentClass> lst = q5.getResultList();
//			for(StudentClass s:lst) {
//				System.out.println(s.getClassTitle());
//			}

			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		System.out.println("Xong");
	}

}
