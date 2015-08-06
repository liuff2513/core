package mine.test;

import mine.core.ssh.hibernate.HibernateSessionFactory;

import org.hibernate.Session;

import junit.framework.TestCase;

public class HibernateTest extends TestCase{
	private final static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	public Session getSession(){
		Session session=HibernateSessionFactory.getSession();
		Session session2=threadLocal.get();
		System.out.println(session2==null);
		return session;
	}
	public void closeSession(){
		Session session=threadLocal.get();
		System.out.println(session.isOpen());
	}
	@SuppressWarnings("unused")
	private void test(){
		Session session=this.getSession();
		closeSession();
	}
}
