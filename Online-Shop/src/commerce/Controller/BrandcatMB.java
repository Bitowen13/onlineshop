package commerce.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Brandcat;
import commerce.ServiceInterface.BrandcatUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "BrandcatMB")
@ViewScoped

public class BrandcatMB extends baseManagedBeanController<Brandcat> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public BrandcatMB() {
	}

	// Services Deceleration
	@Autowired
	private BrandcatUCService BrandcatService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Brandcat();

		// new other Objects and set them into Base objectص
		// refresh Lists
		baseEntityList = BrandcatService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				BrandcatService.Edit(baseEntity);
			else
				result = BrandcatService.Add(baseEntity);

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
	public void Remove(Brandcat baseEntity) {
		try {
			BrandcatService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
