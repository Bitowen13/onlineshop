
package accounting.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Factsituation;
import accounting.Entity.Sellfact;
import accounting.ServiceInterface.FactsituationUCService;
import accounting.ServiceInterface.SellfactUCService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "SellfactMB")
@ViewScoped

public class SellfactMB extends baseManagedBeanController<Sellfact> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public SellfactMB() {
	}

	// Services Deceleration
	@Autowired
	private SellfactUCService SellfactService;
	@Autowired
	private FactsituationUCService FactsituationService;

	/*
	 * @Autowired private TransactionUCService transactionService;
	 */
	// base Object, relations Lists (1-* objects)
	public List<Factsituation> FindAll_Factsituation() {
		return FactsituationService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Sellfact();

		// new other Objects and set them into Base object
		if (null == baseEntity.getFactsituation())
			baseEntity.setFactsituation(new Factsituation());

		// refresh Lists
		baseEntityList = SellfactService.FindAll("id", JPAOp.Asc);
	}

	String date = "";

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				SellfactService.Edit(baseEntity);
			else
				result = SellfactService.Add(baseEntity);

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
	public void Remove(Sellfact baseEntity) {

		try {
			SellfactService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
