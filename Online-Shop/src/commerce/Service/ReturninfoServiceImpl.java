package commerce.Service;

import commerce.ServiceInterface.ReturninfoUCService;
import commerce.Entity.Returninfo;
import baseService.baseUCServiceImpl;
import common.SessionManager;
import common.exception.gException;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aasession;

@Service
public class ReturninfoServiceImpl extends baseUCServiceImpl<Returninfo> implements ReturninfoUCService {

	@Override
	@Transactional
	public String Add(Returninfo entity) throws Exception, gException {
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		entity.setAauser(aasession.getAauser());
		Date now = new java.util.Date();
		entity.setDate(now);

		if (entity.getDescription() == "عودت") {
			entity.setType((long) -1);
		} else if (entity.getDescription() == "تعویض") {
			entity.setType((long) 0);
		}

		return super.Add(entity);
	}

	@Override
	@Transactional
	public Returninfo Edit(Returninfo entity) throws Exception, gException {

		Date now = new java.util.Date();
		entity.setDate(now);

		if (entity.getDescription() == "عودت") {
			entity.setType((long) -1);
		} else if (entity.getDescription() == "تعویض") {
			entity.setType((long) 0);
		}

		return super.Edit(entity);
	}

	@Override
	@Transactional
	public void Remove(Returninfo entity) throws Exception, gException {

		// do Business Logic HERE

		super.Remove(entity);
	}

}
