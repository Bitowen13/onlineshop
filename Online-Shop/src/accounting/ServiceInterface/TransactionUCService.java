package accounting.ServiceInterface;

import baseService.baseUCService;
import common.exception.gException;
import accounting.Entity.Transaction;

public interface TransactionUCService extends baseUCService<Transaction> {

	public String Add2(Transaction entity) throws Exception, gException;
	public Long sum() throws Exception, gException;
}
