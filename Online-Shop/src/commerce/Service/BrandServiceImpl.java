package commerce.Service;

import commerce.ServiceInterface.BrandUCService;
import commerce.Entity.Brand;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandServiceImpl extends baseUCServiceImpl<Brand> implements BrandUCService {

	@Override
	@Transactional
	public String Add(Brand entity) throws Exception, gException {
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Brand Edit(Brand entity) throws Exception, gException {

		// do Business Logic HERE
		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Brand entity) throws Exception, gException {
		// do Business Logic HERE
		super.Remove(entity);
	}

}
