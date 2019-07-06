package commerce.Service;

import commerce.ServiceInterface.FieldcatUCService;
import commerce.Entity.Fieldcat;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FieldcatServiceImpl extends baseUCServiceImpl<Fieldcat> implements FieldcatUCService
{

	@Override
	@Transactional
	public String Add(Fieldcat entity) throws Exception, gException 
	{
		
		return super.Add(entity);
	}



	@Override
	@Transactional
	public Fieldcat Edit(Fieldcat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Fieldcat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
