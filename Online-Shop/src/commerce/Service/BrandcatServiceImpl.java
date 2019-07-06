package commerce.Service;

import commerce.ServiceInterface.BrandcatUCService;
import commerce.Entity.Brandcat;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrandcatServiceImpl extends baseUCServiceImpl<Brandcat> implements BrandcatUCService {
	@Autowired
	BrandcatUCService BrandcatService;

	@Override
	@Transactional
	public String Add(Brandcat entity) throws Exception, gException {
		String name = entity.getName();
		for (int x = 0; x < name.length(); x++)
			if (name.charAt(x) < 'A')
				throw new gException("نام برند صحیح وارد نشده است");
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Brandcat Edit(Brandcat entity) throws Exception, gException {

		String name = entity.getName();
		for (int x = 0; x < name.length(); x++)
			if (name.charAt(x) < 'A')
				throw new gException("نام برند صحیح وارد نشده است");
		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Brandcat entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

	@Override
	@Transactional
	public List<Brandcat> DISTINCTShow() {
		return null;

	}

}
