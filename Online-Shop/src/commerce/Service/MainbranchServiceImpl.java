package commerce.Service;

import commerce.ServiceInterface.MainbranchUCService;
import commerce.ServiceInterface.SubbranchUCService;
import commerce.Entity.Mainbranch;
import commerce.Entity.Subbranch;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MainbranchServiceImpl extends baseUCServiceImpl<Mainbranch> implements MainbranchUCService {

	@Autowired
	SubbranchUCService SubbranchService;
	@Override
	@Transactional
	public void Remove(Mainbranch entity) throws Exception, gException {

		// do Business Logic HERE
		List<Subbranch> subbranches=SubbranchService.FindAll();
		for(Subbranch x: subbranches)
		{
			if(x.getMainbranch().getId()==entity.getId())
				x.setMainbranch(null);
		}

		super.Remove(entity);
	}

}
