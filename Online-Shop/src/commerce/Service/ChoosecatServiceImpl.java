package commerce.Service;

import commerce.ServiceInterface.ChoosecatUCService;
import commerce.Entity.Choosecat;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ChoosecatServiceImpl extends baseUCServiceImpl<Choosecat> implements ChoosecatUCService
{

	@Override
	@Transactional
	public String Add(Choosecat entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Choosecat Edit(Choosecat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Choosecat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
