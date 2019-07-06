
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Fieldcat;
import commerce.Entity.Subbranch;
import commerce.ServiceInterface.FieldcatUCService;
import commerce.ServiceInterface.SubbranchUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "FieldcatMB")
@ViewScoped

public class FieldcatMB extends baseManagedBeanController<Fieldcat> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public FieldcatMB() {
	}

	// Services Deceleration
	@Autowired
	private FieldcatUCService FieldcatService;

	@Autowired
	private SubbranchUCService SubbranchService;

	// base Object, relations Lists (1-* objects)
	public List<Subbranch> FindAll_Subbranch() {
		return SubbranchService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Fieldcat();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = FieldcatService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				FieldcatService.Edit(baseEntity);
			else
				result = FieldcatService.Add(baseEntity);

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
	public void Remove(Fieldcat baseEntity) {
		try {
			FieldcatService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
