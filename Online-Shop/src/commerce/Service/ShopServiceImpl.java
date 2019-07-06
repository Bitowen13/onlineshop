package commerce.Service;

import commerce.ServiceInterface.MainbranchUCService;
import commerce.ServiceInterface.ShopUCService;
import commerce.Entity.Mainbranch;
import commerce.Entity.Shop;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ShopServiceImpl extends baseUCServiceImpl<Shop> implements ShopUCService {
	@Autowired
	MainbranchUCService mainbranchService;

	@Override
	@Transactional
	public void Remove(Shop entity) throws Exception, gException {

		// do Business Logic HERE
		List<Mainbranch> mainbranches=mainbranchService.FindAll();
		for(Mainbranch x:mainbranches)
		{
			if(x.getShop().getId()==entity.getId())
			{
				x.setShop(null);
				mainbranchService.Edit(x);
			}
		}

		super.Remove(entity);
	}

}
