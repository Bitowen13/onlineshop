
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Choosecat;
import commerce.Entity.Chooseval;
import commerce.ServiceInterface.ChoosecatUCService;
import commerce.ServiceInterface.ChoosevalUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "ChoosevalMB")
@ViewScoped

public class ChoosevalMB extends baseManagedBeanController<Chooseval> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public ChoosevalMB() {
	}

	// Services Deceleration
	@Autowired
	private ChoosevalUCService ChoosevalService;
	@Autowired
	private ChoosecatUCService ChoosecatService;

	// base Object, relations Lists (1-* objects)
	public List<Choosecat> FindAll_Choosecat() {
		return ChoosecatService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Chooseval();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = ChoosevalService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				ChoosevalService.Edit(baseEntity);
			else
				result = ChoosevalService.Add(baseEntity);

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
	public void Remove(Chooseval baseEntity) {
		try {
			ChoosevalService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
