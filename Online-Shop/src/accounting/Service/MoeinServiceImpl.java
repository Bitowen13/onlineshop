package accounting.Service;

import accounting.ServiceInterface.LedgerUCService;
import accounting.ServiceInterface.MoeinUCService;
import accounting.Entity.Ledger;
import accounting.Entity.Moein;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoeinServiceImpl extends baseUCServiceImpl<Moein> implements MoeinUCService {

	@Autowired
	LedgerUCService LedgerService;
	@Autowired
	MoeinUCService MoeinService;

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public String Update(Moein entity) throws Exception, gException {
		List<Moein> moein = MoeinService.FindAll();
		Date now = new java.util.Date();
		Ledger ledger = new Ledger();

		long total = 0;
		if (now.getMonth() == 0) {

			for (Moein x : moein)
				if (x.getLedger() == null && x.getDate().getYear() == now.getYear() - 1)
					total += x.getTotal();
			ledger.setIncome(total);
			ledger.setDate(now);
			ledger.setSdate(new Date(now.getYear() - 1, now.getMonth(), now.getDate()));
			ledger.setEdate(new Date(now.getYear() - 1, now.getMonth() + 11, now.getDate()));

			for (Moein x : moein)
				if (x.getLedger() == null && x.getDate().getYear() == now.getYear() - 1) {
					x.setLedger(ledger);

					MoeinService.Edit(x);
				}
			return super.Add(entity);

		}

		else {
			throw new gException("نمیتوان");
		}
	}

}
