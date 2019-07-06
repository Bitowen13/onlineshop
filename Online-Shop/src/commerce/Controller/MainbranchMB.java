
package commerce.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import baseService.JPAOp;
import commerce.Entity.Mainbranch;
import commerce.Entity.Shop;
import commerce.ServiceInterface.MainbranchUCService;
import commerce.ServiceInterface.ShopUCService;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "MainbranchMB")
@ViewScoped

public class MainbranchMB extends baseManagedBeanController<Mainbranch> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public MainbranchMB() {
	}

	// Services Deceleration
	@Autowired
	private MainbranchUCService MainbranchService;

	@Autowired
	private ShopUCService ShopService;

	
	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Mainbranch();
		

		// new other Objects and set them into Base object
		if(baseEntity.getShop()==null)
			baseEntity.setShop(new Shop());

		// refresh Lists
		baseEntityList = MainbranchService.FindAll("id", JPAOp.Asc);
		
	}

	
	// base Object, relations Lists (1-* objects)

		public List<Shop> FindAll_Shop() {
			return ShopService.FindAll("id", JPAOp.Asc);
		}

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				MainbranchService.Edit(baseEntity);
			else
				result = MainbranchService.Add(baseEntity);

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
	public void Remove(Mainbranch baseEntity) {
		try {
			MainbranchService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
