package accounting.Service;

import accounting.ServiceInterface.LedgerUCService;
import accounting.Entity.Ledger;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LedgerServiceImpl extends baseUCServiceImpl<Ledger> implements LedgerUCService {

	@Override
	@Transactional
	public String Add(Ledger entity) throws Exception, gException {
		String income = entity.getIncome() + "";
		for (int x = 0; x < income.length(); x++) {
			if (income.charAt(x) >= 'A') {
				throw new gException("فیلد درآمد در فرمت صحیح نمیباشد");
			}
		}
		Date start = entity.getSdate();
		Date end = entity.getEdate();
		if (start.after(end))
			throw new gException("تاریخ شروع از تاریخ پایان بیشتر است");
		if (start.equals(end))
			throw new gException("تاریخ شروع با پایان برابر است");
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Ledger Edit(Ledger entity) throws Exception, gException {

		String income = entity.getIncome() + "";
		for (int x = 0; x < income.length(); x++) {
			if (income.charAt(x) >= 'A') {
				throw new gException("فیلد درآمد در فرمت صحیح نمیباشد");
			}
		}
		Date start = entity.getSdate();
		Date end = entity.getEdate();
		if (start.after(end))
			throw new gException("تاریخ شروع از تاریخ پایان بیشتر است");
		if (start.equals(end))
			throw new gException("تاریخ شروع با پایان برابر است");

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Ledger entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
