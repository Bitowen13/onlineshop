
package accounting.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Moein;
import accounting.ServiceInterface.MoeinUCService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "MoeinMB")
@ViewScoped

public class MoeinMB extends baseManagedBeanController<Moein> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public MoeinMB() {
	}

	// Services Deceleration
	@Autowired
	private MoeinUCService MoeinService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Moein();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = MoeinService.FindAll("id", JPAOp.Asc);
	}

	String date = "";

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				MoeinService.Edit(baseEntity);
			else
				result = MoeinService.Add(baseEntity);

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
	public void Remove(Moein baseEntity) {

		try {
			MoeinService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
