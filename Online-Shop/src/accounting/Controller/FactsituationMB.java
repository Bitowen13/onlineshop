
package accounting.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Factsituation;
import accounting.ServiceInterface.FactsituationUCService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "FactsituationMB")
@ViewScoped

public class FactsituationMB extends baseManagedBeanController<Factsituation> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public FactsituationMB() {
	}

	// Services Deceleration
	@Autowired
	private FactsituationUCService FactsituationService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Factsituation();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = FactsituationService.FindAll("id", JPAOp.Asc);
	}

	String date = "";

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				FactsituationService.Edit(baseEntity);
			else
				result = FactsituationService.Add(baseEntity);

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
	public void Remove(Factsituation baseEntity) {

		try {
			FactsituationService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
