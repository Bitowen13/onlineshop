package store.Service;

import store.ServiceInterface.StorepartUCService;
import store.Entity.Storepart;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorepartServiceImpl extends baseUCServiceImpl<Storepart> implements StorepartUCService {

	StorepartUCService StorepartService;

	@Override
	@Transactional
	public String Add(Storepart entity) throws Exception, gException {
		// do Business Logic HERE
		/*String name = entity.getName();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نام بخش انبار در فرمت صحیح نمیباشد");
			}
		}
		name = entity.getType();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نوع بخش انبار در فرمت صحیح نمیباشد");
			}
		}
		List<Storepart> store = StorepartService.FindAll();
		for (int x = 0; x < store.size();)
			if (entity.getName() == store.get(x).getName())
				throw new gException("این نام قبلا در سیستم ثبت شده است");
*/
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Storepart Edit(Storepart entity) throws Exception, gException {

		// do Business Logic HERE
		/*String name = entity.getName();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نام بخش انبار در فرمت صحیح نمیباشد");
			}

		}
		name = entity.getType();
		for (int x = 0; x < name.length(); x++) {
			if (name.charAt(x) < 1500) {
				throw new gException("نوع بخش انبار در فرمت صحیح نمیباشد");
			}
		}
		List<Storepart> store = StorepartService.FindAll();
		for (int x = 0; x < store.size();)
			if (entity.getName() == store.get(x).getName())
				throw new gException("این نام قبلا در سیستم ثبت شده است");*/

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Storepart entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}