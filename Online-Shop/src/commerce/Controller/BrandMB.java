package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Brand;
import commerce.Entity.Brandcat;
import commerce.ServiceInterface.BrandUCService;
import commerce.ServiceInterface.BrandcatUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "BrandMB")
@ViewScoped

public class BrandMB extends baseManagedBeanController<Brand> implements Serializable {
	private static final long serialVersionUID = 7175342648505956385L;

	public BrandMB() {
	}

	// Services Deceleration
	@Autowired
	private BrandUCService Brandervice;

	@Autowired
	private BrandcatUCService BrandcatService;

	// base Object, relations Lists (1-* objects)
	public List<Brandcat> FindAll_Brandcat() {
		return BrandcatService.FindAll("id", JPAOp.Asc);
	}

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Brand();

		// new other Objects and set them into Base object
		if (null == baseEntity.getBrandcat())
			baseEntity.setBrandcat(new Brandcat());

		// refresh Lists
		baseEntityList = Brandervice.FindAll("brandcat", JPAOp.Asc, "id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";
		try {
			if (isedit)
				Brandervice.Edit(baseEntity);
			else
				result = Brandervice.Add(baseEntity);

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
	public void Remove(Brand baseEntity) {
		try {
			Brandervice.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}