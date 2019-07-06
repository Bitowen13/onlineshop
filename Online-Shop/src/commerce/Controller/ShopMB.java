
package commerce.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Shop;
import commerce.ServiceInterface.ShopUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "ShopMB")
@ViewScoped

public class ShopMB extends baseManagedBeanController<Shop> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public ShopMB() {
	}

	// Services Deceleration
	@Autowired
	private ShopUCService ShopService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Shop();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = ShopService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				ShopService.Edit(baseEntity);
			else
				result = ShopService.Add(baseEntity);

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
	public void Remove(Shop baseEntity) {
		try {
			ShopService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
