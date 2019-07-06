package accounting.ServiceInterface;

import baseService.baseUCService;
import common.exception.gException;
import store.Entity.Good;
import accounting.Entity.Buyfact;

public interface BuyfactUCService extends baseUCService<Buyfact>
{

	public String cadd (Buyfact b,long id,long num)throws gException, Exception;
}
