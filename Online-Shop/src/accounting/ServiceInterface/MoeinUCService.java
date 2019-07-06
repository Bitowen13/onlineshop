package accounting.ServiceInterface;

import baseService.baseUCService;
import common.exception.gException;
import accounting.Entity.Moein;

public interface MoeinUCService extends baseUCService<Moein> {
	public String Update(Moein entity) throws Exception, gException;

}
