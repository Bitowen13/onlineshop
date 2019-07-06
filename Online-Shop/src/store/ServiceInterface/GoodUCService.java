package store.ServiceInterface;

import baseService.baseUCService;
import common.exception.gException;
import store.Entity.Good;

public interface GoodUCService extends baseUCService<Good> {

	public Long Showtotal(Good BaseEntity) throws Exception, gException;
}
