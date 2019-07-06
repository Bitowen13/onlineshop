package commerce.Service;

import commerce.ServiceInterface.FieldvalUCService;
import commerce.Entity.Fieldval;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FieldvalServiceImpl extends baseUCServiceImpl<Fieldval> implements FieldvalUCService {

	@Override
	@Transactional
	public String Add(Fieldval entity) throws Exception, gException {

		return super.Add(entity);
	}

	@Override
	@Transactional
	public Fieldval Edit(Fieldval entity) throws Exception, gException {

		// do Business Logic HERE

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Fieldval entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
