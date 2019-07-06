package commerce.Service;

import commerce.ServiceInterface.OffUCService;
import commerce.Entity.Off;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OffServiceImpl extends baseUCServiceImpl<Off> implements OffUCService {

	@Override
	@Transactional
	public String Add(Off entity) throws Exception, gException {
		Long off = entity.getOffpercent();
		if (off > 100)
			throw new gException("مقدار تخفیف بیش از حد مجاز");
		Date start = entity.getStartdate();
		Date end = entity.getEnddate();
		if (start.after(end))
			throw new gException("تاریخ شروع از تاریخ پایان بیشتر است");
		if (start.equals(end))
			throw new gException("تاریخ شروع با پایان برابر است");
		
		return super.Add(entity);
	}

	@Override
	@Transactional
	public Off Edit(Off entity) throws Exception, gException {

		Long off = entity.getOffpercent();
		if (off > 100)
			throw new gException("مقدار تخفیف بیش از حد مجاز");
		Date start = entity.getStartdate();
		Date end = entity.getEnddate();
		if (start.after(end))
			throw new gException("تاریخ شروع از تاریخ پایان بیشتر است");
		if (start.equals(end))
			throw new gException("تاریخ شروع با پایان برابر است");

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Off entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
