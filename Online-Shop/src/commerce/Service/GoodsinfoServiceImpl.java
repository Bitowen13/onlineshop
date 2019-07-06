package commerce.Service;

import commerce.ServiceInterface.GoodsinfoUCService;
import commerce.Entity.Goodsinfo;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsinfoServiceImpl extends baseUCServiceImpl<Goodsinfo> implements GoodsinfoUCService {

	@Override
	@Transactional
	public String Add(Goodsinfo entity) throws Exception, gException {
		if (entity.getMaxstock() < entity.getMinstock())
			throw new gException("مقدار ماکسیمم و مینیمم مقدار درست وارد نشده است");
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Goodsinfo Edit(Goodsinfo entity) throws Exception, gException {

		if (entity.getMaxstock() < entity.getMinstock())
			throw new gException("مقدار ماکسیمم و مینیمم مقدار درست وارد نشده است");

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Goodsinfo entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
