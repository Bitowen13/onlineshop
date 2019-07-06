
package accounting.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Transaction;
import accounting.ServiceInterface.TransactionUCService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;

@ManagedBean(name = "TransactionMB")
@ViewScoped

public class TransactionMB extends baseManagedBeanController<Transaction> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public TransactionMB() {
	}

	// Services Deceleration
	@Autowired
	private TransactionUCService TransactionService;

	// base Object, relations Lists (1-* objects)

	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Transaction();

		// new other Objects and set them into Base object

		// refresh Lists
		baseEntityList = TransactionService.FindAll("id", JPAOp.Asc);
	}

	String date = "";

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				TransactionService.Edit(baseEntity);
			else
				result = TransactionService.Add(baseEntity);

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
	public void Remove(Transaction baseEntity) {

		try {
			TransactionService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}
	public Long sum() throws gException, Exception 
	{
		Long sum=TransactionService.sum();
		
		return sum;
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}
