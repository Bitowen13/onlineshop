
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Goodsinfo;
import commerce.Entity.Off;
import commerce.ServiceInterface.GoodsinfoUCService;
import commerce.ServiceInterface.OffUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "OffMB")
@ViewScoped

public class OffMB extends baseManagedBeanController<Off> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public OffMB() {
	}

	// Services Deceleration
	@Autowired
	private OffUCService OffService;

	@Autowired
	private GoodsinfoUCService GoodsinfoService;

	// base Object, relations Lists (1-* objects)
	public List<Goodsinfo> FindAll_Goodsinfo() {
		return GoodsinfoService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Off();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = OffService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				OffService.Edit(baseEntity);
			else
				result = OffService.Add(baseEntity);

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
	public void Remove(Off baseEntity) {
		try {
			OffService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
