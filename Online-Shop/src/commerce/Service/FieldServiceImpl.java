package commerce.Service;

import commerce.ServiceInterface.FieldUCService;
import commerce.Entity.Field;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FieldServiceImpl extends baseUCServiceImpl<Field> implements FieldUCService {

	@Override
	@Transactional
	public String Add(Field entity) throws Exception, gException {
		entity.setDefaultval(":):D");
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Field Edit(Field entity) throws Exception, gException {

		// do Business Logic HERE

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Field entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
