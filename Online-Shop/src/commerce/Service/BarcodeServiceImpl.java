package commerce.Service;

import commerce.ServiceInterface.BarcodeUCService;
import commerce.Entity.Barcode;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BarcodeServiceImpl extends baseUCServiceImpl<Barcode> implements BarcodeUCService {

	@Override
	@Transactional
	public String Add(Barcode entity) throws Exception, gException {
		// do Business Logic HERE

		return super.Add(entity);
	}

	@Override
	@Transactional
	public Barcode Edit(Barcode entity) throws Exception, gException {

		// do Business Logic HERE

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Barcode entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
