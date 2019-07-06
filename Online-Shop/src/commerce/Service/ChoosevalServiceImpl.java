package commerce.Service;

import commerce.ServiceInterface.ChoosevalUCService;
import commerce.Entity.Chooseval;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ChoosevalServiceImpl extends baseUCServiceImpl<Chooseval> implements ChoosevalUCService
{

	@Override
	@Transactional
	public String Add(Chooseval entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Chooseval Edit(Chooseval entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Chooseval entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
