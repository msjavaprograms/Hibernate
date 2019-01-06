package com.msinfo.Utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {
		if (sessionFactory == null) {
			try {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				MetadataSources MetadataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = MetadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
