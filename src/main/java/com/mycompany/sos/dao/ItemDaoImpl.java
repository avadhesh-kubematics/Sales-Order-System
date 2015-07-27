/**
 * 
 */
package com.mycompany.sos.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.sos.dao.entities.ItemEntity;

/**
 * @author colin
 *
 */
@Repository("itemDaoImpl")
public class ItemDaoImpl implements ItemDao {

	private EntityManager entityManager;
	
	Logger logger = LoggerFactory.getLogger(ItemDaoImpl.class);
	
	@PostConstruct
	public void init(){
		logger.info("Setting up EntityManager");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
				"com.mycompany.sos.entitymanager");
		
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Cleaning up resources");
		if(entityManager.isOpen()) {
			if(logger.isDebugEnabled()) {
				logger.debug("EntityManager is open - closing it");
			}
			entityManager.close();
		}
	}
	
	@Override
	public boolean addItem(ItemEntity item) {
		
		
		
		return false;
	}

	@Override
	public List<ItemEntity> getItems() {
	
		List<ItemEntity> itemEntityList = entityManager.createQuery("from ItemEntity", ItemEntity.class)
														.getResultList();
		
		return itemEntityList;
	}

}
