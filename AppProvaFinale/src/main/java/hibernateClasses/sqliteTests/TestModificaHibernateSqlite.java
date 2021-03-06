package hibernateClasses.sqliteTests;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import core.Esito;
import core.Test;
import hibernateClasses.HibernateSessionManagerSqlite;

public class TestModificaHibernateSqlite extends Test{
	@Override
	public void run() {
		long start = System.nanoTime();
		
		Session session = HibernateSessionManagerSqlite.getSession();
		Transaction tx = session.beginTransaction();
		Query<?> query=session.createQuery("update GattoHibernate set colore=:newcolor where colore like :condition");
		query.setParameter("newcolor","magenta");
		query.setParameter("condition","bianco");
		long modificati = query.executeUpdate();
		tx.commit();
		
		long end = System.nanoTime();
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms");
		setEsito(new Esito("Test modifica valori Hibernate Sqlite:"+(end-start)/1000000 + "ms; Valori modificati: "+modificati ));
	}

}
