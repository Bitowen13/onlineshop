
package commerce.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Fieldtype;
import commerce.ServiceInterface.FieldtypeUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "FieldtypeMB")
@ViewScoped

public class FieldtypeMB extends baseManagedBeanController<Fieldtype> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public FieldtypeMB() {
	}

	// Services Deceleration
	@Autowired
	private FieldtypeUCService FieldtypeService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Fieldtype();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = FieldtypeService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				FieldtypeService.Edit(baseEntity);
			else
				result = FieldtypeService.Add(baseEntity);

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
	public void Remove(Fieldtype baseEntity) {
		try {
			FieldtypeService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
