
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Mainbranch;
import commerce.Entity.Subbranch;
import commerce.ServiceInterface.MainbranchUCService;
import commerce.ServiceInterface.SubbranchUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "SubbranchMB")
@ViewScoped

public class SubbranchMB extends baseManagedBeanController<Subbranch> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public SubbranchMB() {
	}

	// Services Deceleration
	@Autowired
	private SubbranchUCService SubbranchService;

	@Autowired
	private MainbranchUCService MainbranchService;

	// base Object, relations Lists (1-* objects)
	public List<Mainbranch> FindAll_Mainbranch() {
		return MainbranchService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Subbranch();

		// new other Objects and set them into Base object
		if (baseEntity.getMainbranch() == null)
			baseEntity.setMainbranch(new Mainbranch());

		// refresh Lists
		baseEntityList = SubbranchService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				SubbranchService.Edit(baseEntity);
			else
				result = SubbranchService.Add(baseEntity);

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
	public void Remove(Subbranch baseEntity) {
		try {
			SubbranchService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
