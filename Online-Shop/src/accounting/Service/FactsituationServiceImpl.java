package accounting.Service;

import accounting.ServiceInterface.FactsituationUCService;
import accounting.Entity.Factsituation;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FactsituationServiceImpl extends baseUCServiceImpl<Factsituation> implements FactsituationUCService {

	@Override
	@Transactional
	public String Add(Factsituation entity) throws Exception, gException {
		// do Business Logic HERE

		return super.Add(entity);
	}

	@Override
	@Transactional
	public Factsituation Edit(Factsituation entity) throws Exception, gException {

		// do Business Logic HERE

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Factsituation entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
