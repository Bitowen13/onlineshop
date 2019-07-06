
package store.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Store;
import store.ServiceInterface.StoreUCService;

@ManagedBean(name = "StoreMB")
@ViewScoped

public class StoreMB extends baseManagedBeanController<Store> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public StoreMB() {
	}

	// Services Deceleration
	@Autowired
	private StoreUCService StoreService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Store();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = StoreService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				StoreService.Edit(baseEntity);
			else
				result = StoreService.Add(baseEntity);

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
	public void Remove(Store baseEntity) {
		try {
			StoreService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			System.out.println("77777777777777");
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
