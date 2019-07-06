
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Buyfact;
import accounting.Entity.Sellfact;
import accounting.ServiceInterface.BuyfactUCService;
import accounting.ServiceInterface.SellfactUCService;
import baseService.JPAOp;
import commerce.Entity.Barcode;
import commerce.Entity.Returninfo;
import commerce.ServiceInterface.BarcodeUCService;
import commerce.ServiceInterface.ReturninfoUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Good;
import store.ServiceInterface.GoodUCService;

@ManagedBean(name = "‌ssMB")
@ViewScoped

public class BarcodeMB extends baseManagedBeanController<Barcode> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public BarcodeMB() {
	}

	// Services Deceleration
	@Autowired
	private BarcodeUCService BarcodeService;

	@Autowired
	private GoodUCService GoodService;

	@Autowired
	private SellfactUCService SellfactService;

	@Autowired
	private BuyfactUCService BuyfactService;

	@Autowired
	private ReturninfoUCService ReturninfoService;

	// base Object, relations Lists (1-* objects)
	public List<Good> FindAll_Good() {
		return GoodService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Sellfact> FindAll_Sellfact() {
		return SellfactService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Buyfact> FindAll_Buyfact() {
		return BuyfactService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Returninfo> FindAll_Returninfo() {
		return ReturninfoService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Barcode();

		// new other Objects and set them into Base object
		if (baseEntity.getGood() == null)
			baseEntity.setGood(new Good());
		if (baseEntity.getReturninfo() == null)
			baseEntity.setReturninfo(new Returninfo());
		if (baseEntity.getBuyfact() == null)
			baseEntity.setBuyfact(new Buyfact());
		if (baseEntity.getSellfact() == null)
			baseEntity.setSellfact(new Sellfact());
		
		// refresh Lists
		baseEntityList = BarcodeService.FindAll("id", JPAOp.Asc);
	}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				BarcodeService.Edit(baseEntity);
			else
				result = BarcodeService.Add(baseEntity);

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
	public void Remove(Barcode baseEntity) {
		try {
			BarcodeService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
