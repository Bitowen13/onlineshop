package store.Service;

import store.ServiceInterface.GoodUCService;
import store.Entity.Good;
import baseService.baseUCServiceImpl;
import commerce.ServiceInterface.BarcodeUCService;
import common.exception.gException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodServiceImpl extends baseUCServiceImpl<Good> implements GoodUCService {

	@Autowired
	BarcodeUCService BarcodeService;

	@Override
	@Transactional
	public String Add(Good entity) throws Exception, gException {
		/*
		 * String Price = entity.getPrice() + ""; for (int x = 0; x < Price.length();
		 * x++) { if (Price.charAt(x) > '9' || Price.charAt(x) < '0') { throw new
		 * gException("فیلد درآمد در فرمت صحیح نمیباشد"); } } Date start =
		 * entity.getPruddate(); Date end = entity.getExpdate(); if (start.after(end))
		 * throw new gException("تاریخ شروع از تاریخ پایان بیشتر است"); if
		 * (start.equals(end)) throw new gException("تاریخ شروع با پایان برابر است");
		 */

		return super.Add(entity);

	}

	@Override
	@Transactional
	public Good Edit(Good entity) throws Exception, gException {

		/*
		 * String Price = entity.getPrice() + ""; for (int x = 0; x < Price.length();
		 * x++) { if (Price.charAt(x) > '9' || Price.charAt(x) < '0') { throw new
		 * gException("فیلد درآمد در فرمت صحیح نمیباشد"); } } Date start =
		 * entity.getPruddate(); Date end = entity.getExpdate(); if (start.after(end))
		 * throw new gException("تاریخ شروع از تاریخ پایان بیشتر است"); if
		 * (start.equals(end)) throw new gException("تاریخ شروع با پایان برابر است");
		 */
		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Good entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

	@Override
	public Long Showtotal(Good baseEntity) throws Exception, gException {
		long total = 0;
		List<commerce.Entity.Barcode> barcode = BarcodeService.FindAll();

		for (commerce.Entity.Barcode x : barcode) {
			if (x.getGood().getId() == baseEntity.getId()) {
				total++;
			}
		}

		return total;
	}

}
