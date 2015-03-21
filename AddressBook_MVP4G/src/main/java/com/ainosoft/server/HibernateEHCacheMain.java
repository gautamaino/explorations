package com.ainosoft.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.ainosoft.server.hibernate.util.HibernateUtil;
 

 
public class HibernateEHCacheMain {
 
    public static void main(String[] args) {
         
        System.out.println("Temp Dir:"+System.getProperty("java.io.tmpdir"));
         
        //Initialize Sessions
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
         
        Session session = sessionFactory.openSession();
        Session otherSession = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Transaction otherTransaction = otherSession.beginTransaction();
         
        printStats(stats, 0);
         
        Address adr = (Address) session.load(Address.class, 1);
        printData(adr, stats, 1);
        
         
        adr = (Address) session.load(Address.class, 1);
        printData(adr, stats, 2);
         
        //clear first level cache, so that second level cache is used
        session.evict(adr);
        adr = (Address) session.load(Address.class, 1);
        printData(adr, stats, 3);
         
        adr = (Address) session.load(Address.class, 2);
        printData(adr, stats, 4);
         
        adr = (Address) otherSession.load(Address.class, 1);
        printData(adr, stats, 5);
         
        //Release resources
        transaction.commit();
        otherTransaction.commit();
        sessionFactory.close();
    }
 
    private static void printStats(Statistics stats, int i) {
        System.out.println("----" + i + "-----");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("\nSecond Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("\nSecond Level Miss Count="
                        + stats
                                .getSecondLevelCacheMissCount());
        System.out.println("\nSecond Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }
 
    private static void printData(Address emp, Statistics stats, int count) {
        System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getZip());
        printStats(stats, count);
    }
 
}
