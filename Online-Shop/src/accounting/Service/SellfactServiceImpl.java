package accounting.Service;

import accounting.ServiceInterface.SellfactUCService;
import accounting.ServiceInterface.TransactionUCService;
import accounting.Entity.Sellfact;
import accounting.Entity.Transaction;
import baseService.baseUCServiceImpl;
import commerce.ServiceInterface.BarcodeUCService;
import commerce.ServiceInterface.GoodsinfoUCService;
import commerce.ServiceInterface.OffUCService;
import common.SessionManager;
import common.exception.gException;
import store.ServiceInterface.GoodUCService;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aasession;

@Service
public class SellfactServiceImpl extends baseUCServiceImpl<Sellfact> implements SellfactUCService {
	@Autowired
	BarcodeUCService BarcodeService;
	@Autowired
	GoodUCService GoodService;
	@Autowired
	GoodsinfoUCService GoodsinfoService;
	@Autowired
	OffUCService OffService;
	@Autowired
	TransactionUCService TransactionService;

	@Override
	@Transactional
	public String Add(Sellfact entity) throws Exception, gException {
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		entity.setAauser(aasession.getAauser());
		Date now = new java.util.Date();
		entity.setFactdate(now);
		if (entity.getFactsituation().getId() == 1) {
			Transaction trans = new Transaction();
			Random random = new Random();
			long f = random.nextInt(99999) + 10000;
			trans.setReciptnum(f);

			trans.setTotal(entity.getPayable());

			trans.setTransdate(now);

			TransactionService.Add(trans);
			entity.setTransaction(trans);
		}
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Sellfact Edit(Sellfact entity) throws Exception, gException {
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

			trans.setTotal(entity.getPayable());

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

}
