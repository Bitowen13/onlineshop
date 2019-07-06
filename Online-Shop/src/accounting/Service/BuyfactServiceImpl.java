package accounting.Service;

import accounting.ServiceInterface.BuyfactUCService;
import accounting.ServiceInterface.TransactionUCService;
import accounting.Entity.Buyfact;
import accounting.Entity.Transaction;
import baseService.JPAOp;
import baseService.baseUCServiceImpl;
import commerce.Entity.Barcode;
import commerce.Entity.Goodsinfo;
import commerce.ServiceInterface.BarcodeUCService;
import commerce.ServiceInterface.GoodsinfoUCService;
import common.SessionManager;
import common.exception.gException;
import store.Entity.Good;
import store.ServiceInterface.GoodUCService;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aasession;

@Service
public class BuyfactServiceImpl extends baseUCServiceImpl<Buyfact> implements BuyfactUCService {

	@Autowired
	TransactionUCService TransactionService;
	@Autowired
	GoodUCService GoodService;
	@Autowired
	BarcodeUCService BarcodeService;
	@Autowired
	GoodsinfoUCService GoodinfoService;

	@Override
	@Transactional
	public String Add(Buyfact entity) throws Exception, gException {
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		entity.setAauser(aasession.getAauser());
		entity.setCoefficient((long) -1);
		Date now = new java.util.Date();
		if (entity.getFactdate().after(now))
			throw new gException("تاریخ آینده نمیتواند باشد");

		if (entity.getFactsituation().getId() == 1) {
			Transaction trans = new Transaction();
			Random random = new Random();
			long f = random.nextInt(99999) + 10000;
			trans.setReciptnum(f);

			trans.setTotal(entity.getTotal() * entity.getCoefficient());

			trans.setTransdate(now);

			TransactionService.Add(trans);
			entity.setTransaction(trans);
		}

		return super.Add(entity);
	}

	@Override
	@Transactional
	public Buyfact Edit(Buyfact entity) throws Exception, gException {

		// do Business Logic HERE
		Date now = new java.util.Date();
		if (entity.getFactdate().after(now))
			throw new gException("تاریخ آینده نمیتواند باشد");
		int flag = 0;

		if (entity.getFactsituation().getId() == 1) {
			Transaction trans = new Transaction();
			Random random = new Random();
			long f = random.nextInt(99999) + 10000;
			trans.setReciptnum(f);

			trans.setTotal(entity.getTotal() * entity.getCoefficient());

			trans.setTransdate(now);
			entity.setTransaction(trans);

			TransactionService.Add(trans);
			entity.setTransaction(trans);
			flag++;
		}
		if (entity.getTransaction() != null && flag == 0) {
			throw new gException("نمیتوان حالت پرداخت شده را تغییر وضعیت داد");
		}

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Buyfact entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

	@Override
	@Transactional
	public String cadd(Buyfact b, long id, long num) throws gException, Exception {
		// TODO Auto-generated method stub
		List<Good> goods = GoodService.FindAll();
		List<Goodsinfo> goodsinfos = GoodinfoService.FindAll("id", JPAOp.Asc);
		Good g = new Good();
		for (Good x : goods) {
			if (x.getId() == id) {
				g.setGoodsinfo(x.getGoodsinfo());
				g.setStorepart(x.getStorepart());
				// g.setGoodsinfo(goodsinfos.get(0));
				GoodService.Add(g);
			}
		}
		for (long x = 0; x < num; x++) {
			Barcode barcode = new Barcode();
			barcode.setGood(g);
			barcode.setBuyfact(b);
			BarcodeService.Add(barcode);

		}

		return Add(b);
	}

}