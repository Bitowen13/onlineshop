
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Chooseval;
import commerce.Entity.Field;
import commerce.Entity.Fieldval;
import commerce.Entity.Goodsinfo;
import commerce.ServiceInterface.ChoosevalUCService;
import commerce.ServiceInterface.FieldUCService;
import commerce.ServiceInterface.FieldvalUCService;
import commerce.ServiceInterface.GoodsinfoUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "FieldvalMB")
@ViewScoped

public class FieldvalMB extends baseManagedBeanController<Fieldval> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public FieldvalMB() {
	}

	// Services Deceleration
	@Autowired
	private FieldvalUCService FieldvalService;

	@Autowired
	private ChoosevalUCService ChoosevalService;

	@Autowired
	private GoodsinfoUCService GoodsinfoService;

	@Autowired
	private FieldUCService FieldService;

	// base Object, relations Lists (1-* objects)
	public List<Chooseval> FindAll_Chooseval() {
		return ChoosevalService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Goodsinfo> FindAll_Goodsinfo() {
		return GoodsinfoService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Field> FindAll_Field() {
		return FieldService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Fieldval();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = FieldvalService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				FieldvalService.Edit(baseEntity);
			else
				result = FieldvalService.Add(baseEntity);

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
	public void Remove(Fieldval baseEntity) {
		try {
			FieldvalService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
