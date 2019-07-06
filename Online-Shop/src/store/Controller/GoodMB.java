
package store.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Goodsinfo;
import commerce.ServiceInterface.GoodsinfoUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Good;
import store.Entity.Storepart;
import store.ServiceInterface.GoodUCService;
import store.ServiceInterface.StorepartUCService;

@ManagedBean(name = "GoodMB")
@ViewScoped

public class GoodMB extends baseManagedBeanController<Good> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public GoodMB() {
	}

	@Autowired
	private GoodUCService GoodService;

	// Services Deceleration
	@Autowired
	private StorepartUCService StorepartService;

	@Autowired
	private GoodsinfoUCService GoodinfoService;

	// base Object, relations Lists (1-* objects)
	public List<Goodsinfo> FindAll_Goodsinfo() {
		
		Long l=new Long(1);
		
		return GoodinfoService.FindbyFields("id",JPAOp.NotEq, l,"id",JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Storepart> FindAll_Storepart() {
		return StorepartService.FindAll("id", JPAOp.Asc);
	}

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Good();

		// new other Objects and set them into Base object
		if (null == baseEntity.getGoodsinfo())
			baseEntity.setGoodsinfo(new Goodsinfo());
		if (null == baseEntity.getStorepart())
			baseEntity.setStorepart(new Storepart());

		// refresh Lists
		baseEntityList = GoodService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				GoodService.Edit(baseEntity);
			else
				result = GoodService.Add(baseEntity);

			ResetBaseObject();

			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");

		} catch (Exception ex) {
			CallCatch(ex);
		}

	}

	// UC: Remove
	public void Remove(Good baseEntity) {
		try {
			GoodService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	public Long Showtotal(Good baseEntity) throws gException, Exception {

		return GoodService.Showtotal(baseEntity);

	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
