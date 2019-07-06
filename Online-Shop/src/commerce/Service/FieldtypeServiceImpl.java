package commerce.Service;

import commerce.ServiceInterface.FieldtypeUCService;
import commerce.Entity.Fieldtype;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FieldtypeServiceImpl extends baseUCServiceImpl<Fieldtype> implements FieldtypeUCService
{

	@Override
	@Transactional
	public String Add(Fieldtype entity) throws Exception, gException 
	{
		
		return super.Add(entity);
	}



	@Override
	@Transactional
	public Fieldtype Edit(Fieldtype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Fieldtype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
