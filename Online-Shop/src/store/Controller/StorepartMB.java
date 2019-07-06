package store.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Store;
import store.Entity.Storepart;

import store.ServiceInterface.StoreUCService;
import store.ServiceInterface.StorepartUCService;

@ManagedBean(name = "StorepartMB")
@ViewScoped

public class StorepartMB extends baseManagedBeanController<Storepart> implements Serializable {
	private static final long serialVersionUID = 7175342648505956385L;

	public StorepartMB() {
	}

	// Services Deceleration
	@Autowired
	private StorepartUCService StorepartService;
	@Autowired
	private StoreUCService StoreService;

	// base Object, relations Lists (1-* objects)
	public List<Store> FindAll_Store() {
		return StoreService.FindAll("id", JPAOp.Asc);
	}

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Storepart();

		// new other Objects and set them into Base object
		if (null == baseEntity.getStore())
			baseEntity.setStore(new Store());
		// refresh Lists
		baseEntityList = StorepartService.FindAll("store", JPAOp.Asc, "id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";
		try {
			if (isedit)
				StorepartService.Edit(baseEntity);
			else
				result = StorepartService.Add(baseEntity);

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
	public void Remove(Storepart baseEntity) {
		try {
			StorepartService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}