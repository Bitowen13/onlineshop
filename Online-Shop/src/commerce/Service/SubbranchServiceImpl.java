package commerce.Service;

import commerce.ServiceInterface.SubbranchUCService;
import commerce.Entity.Subbranch;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubbranchServiceImpl extends baseUCServiceImpl<Subbranch> implements SubbranchUCService {

	@Override
	@Transactional
	public String Add(Subbranch entity) throws Exception, gException {
		String name = entity.getName();
		for (int x = 0; x < name.length(); x++)
			if (name.charAt(x) < 1500)
				throw new gException("نام زیر دسته صحیح وارد نشده است");
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Subbranch Edit(Subbranch entity) throws Exception, gException {

		String name = entity.getName();
		for (int x = 0; x < name.length(); x++)
			if (name.charAt(x) < 1500)
				throw new gException("نام زیردسته صحیح وارد نشده است");

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Subbranch entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
