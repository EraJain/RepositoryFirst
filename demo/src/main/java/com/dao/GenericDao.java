package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.bean.Customer;

public class GenericDao {

	public void add(Customer customer) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.save(customer);
			t.commit();
			/**
			 * Logging
			 * */
			System.out.println("successfully saved"+customer);
		}finally {
			sf.close();
			session.close();
		}
	}

	public void remove(Customer customer) {

	}

}
