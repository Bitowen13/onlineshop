package store.Service;

import store.ServiceInterface.StoreUCService;
import store.ServiceInterface.StorepartUCService;
import store.Entity.Store;
import store.Entity.Storepart;

import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreServiceImpl extends baseUCServiceImpl<Store> implements StoreUCService {

	@Autowired
	StoreUCService StoreService;
	@Autowired
	StorepartUCService StorepartService;

	@Override
	@Transactional
	public String Add(Store entity) throws Exception, gException {
		// do Business Logic HERE
/*
		String name = entity.getName();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نام انبار در فرمت صحیح نمیباشد");
			}
		}
		List<Store> store = StoreService.FindAll();
		for (int x = 0; x < store.size();)
			if (entity.getName() == store.get(x).getName())
				throw new gException("این نام قبلا در سیستم ثبت شده است");*/
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Store Edit(Store entity) throws Exception, gException {

		// do Business Logic HERE
		/*String name = entity.getName();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نام انبار در فرمت صحیح نمیباشد");
			}
		}
		List<Store> store = StoreService.FindAll();
		for (int x = 0; x < store.size();)
			if (entity.getName() == store.get(x).getName())
				throw new gException("این نام قبلا در سیستم ثبت شده است");
*/
		return super.Edit(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void Remove(Store entity) throws Exception, gException {
	
/*
		List<Storepart> storepart = (List<Storepart>) em.createNamedQuery("Storepart.find")
				.setParameter("Storeid", entity.getId()).getResultList();*/
		
		List<Storepart> storepart =StorepartService.FindAll();

		for (Storepart x:storepart) {
			if(x.getStore().getId()==entity.getId())
				StorepartService.Remove(x);
		}
		super.Remove(entity);
	}


}