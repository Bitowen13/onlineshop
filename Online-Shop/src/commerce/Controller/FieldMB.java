
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import commerce.Entity.Choosecat;
import commerce.Entity.Field;

import baseService.JPAOp;
import commerce.Entity.Fieldcat;
import commerce.Entity.Fieldtype;
import commerce.ServiceInterface.ChoosecatUCService;
import commerce.ServiceInterface.FieldUCService;
import commerce.ServiceInterface.FieldcatUCService;
import commerce.ServiceInterface.FieldtypeUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "FieldMB")
@ViewScoped

public class FieldMB extends baseManagedBeanController<Field> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public FieldMB() {
	}

	// Services Deceleration
	@Autowired
	private FieldUCService FieldService;

	@Autowired
	private ChoosecatUCService ChoosecatService;

	@Autowired
	private FieldtypeUCService FieldtypeService;

	@Autowired
	private FieldcatUCService FieldcatService;

	// base Object, relations Lists (1-* objects)
	public List<Choosecat> FindAll_Choosecat() {
		return ChoosecatService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Fieldtype> FindAll_Fieldtype() {
		return FieldtypeService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Fieldcat> FindAll_Fieldcat() {
		return FieldcatService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Field();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = FieldService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				FieldService.Edit(baseEntity);
			else
				result = FieldService.Add(baseEntity);

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
	public void Remove(Field baseEntity) {
		try {
			FieldService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
