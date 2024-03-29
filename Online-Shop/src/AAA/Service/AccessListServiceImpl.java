
package AAA.Service;

import AAA.ServiceInterface.AccessListWebService;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import AAA.Entity.Aaaccesslist;
import AAA.Entity.Aapage;
import AAA.Entity.Aarole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccessListServiceImpl extends baseUCServiceImpl<Aaaccesslist> implements AccessListWebService
{

	@Transactional
	public void Add(long RoleId, long Pages[]) throws gException, Exception
	{

		// delete all previous access list
		em.createQuery("DELETE FROM Aaaccesslist a WHERE a.aarole.id=:RoleId").setParameter("RoleId", RoleId).executeUpdate();


		// add new access list
		Aarole role = em.find(Aarole.class, RoleId);
		for (long PageId : Pages)
		{
			Aapage page = em.find(Aapage.class, PageId);
			Aaaccesslist aaa = new Aaaccesslist();
			aaa.setAapage(page);
			aaa.setAarole(role);
			this.Add(aaa);
		}
	}
}
