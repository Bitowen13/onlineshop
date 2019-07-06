
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Brand;
import commerce.Entity.Goodsinfo;
import commerce.Entity.Subbranch;
import commerce.ServiceInterface.BrandUCService;
import commerce.ServiceInterface.GoodsinfoUCService;
import commerce.ServiceInterface.SubbranchUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Good;

@ManagedBean(name = "GoodsinfoMB")
@ViewScoped

public class GoodsinfoMB extends baseManagedBeanController<Goodsinfo> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public GoodsinfoMB() {
	}

	// Services Deceleration
	@Autowired
	private GoodsinfoUCService GoodsinfoService;

	@Autowired
	private BrandUCService BrandService;

	@Autowired
	private SubbranchUCService SubbranchService;

	// base Object, relations Lists (1-* objects)
	public List<Brand> FindAll_Brand() {
		return BrandService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Subbranch> FindAll_Subbranch() {
		return SubbranchService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Goodsinfo();

		// new other Objects and set them into Base object
		if (baseEntity.getBrand() == null)
			baseEntity.setBrand(new Brand());
		if (baseEntity.getSubbranch() == null)
			baseEntity.setSubbranch(new Subbranch());

		// refresh Lists
		baseEntityList = GoodsinfoService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				GoodsinfoService.Edit(baseEntity);
			else
				result = GoodsinfoService.Add(baseEntity);

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
	public void Remove(Goodsinfo baseEntity) {
		try {
			GoodsinfoService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
