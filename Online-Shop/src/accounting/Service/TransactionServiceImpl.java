package accounting.Service;

import accounting.ServiceInterface.MoeinUCService;
import accounting.ServiceInterface.TransactionUCService;
import accounting.Entity.Moein;
import accounting.Entity.Transaction;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl extends baseUCServiceImpl<Transaction> implements TransactionUCService {

	@Autowired
	MoeinUCService MoeinService;
	@Autowired
	TransactionUCService TransactionService;

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public String Add2(Transaction entity) throws Exception, gException {

		List<Transaction> transaction = TransactionService.FindAll();
		Moein moein = new Moein();
		Date now = new java.util.Date();

		long total = 0;

		if (now.getDate() == 1) {

			for (Transaction x : transaction)
				if (x.getMoein() == null && x.getTransdate().getMonth() == now.getMonth() - 1)
					total += x.getTotal();

			moein.setTotal(total);
			moein.setDate(now);
			moein.setSdate(new Date(now.getYear(), now.getMonth() - 1, now.getDate()));
			moein.setEdate(new Date(now.getYear(), now.getMonth() - 1, now.getDate() + 29));

			MoeinService.Add(moein);

			for (Transaction x : transaction) {
				if (x.getMoein() == null && x.getTransdate().getMonth() == now.getMonth() - 1) {
					x.setMoein(moein);
					TransactionService.Edit(x);
				}
			}
			return super.Add2(entity);
		}

		else {
			throw new gException("نمیتوان");
		}
	}

	@Override
	@Transactional
	public String Add(Transaction entity) throws Exception, gException {
		return super.Add(entity);
	}
	@Override
	@Transactional
	public Long sum() throws Exception, gException {
		// TODO Auto-generated method stub
		
		Long sum=(long) 0;
		List<Transaction> transactions=TransactionService.FindAll();
		for(Transaction t:transactions)
		{
			sum+=t.getTotal();
		}
		
		return sum;
	}

}
