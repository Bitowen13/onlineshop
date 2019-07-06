
package accounting.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import accounting.Entity.Buyfact;
import accounting.Entity.Factsituation;
import accounting.Entity.Transaction;
import accounting.ServiceInterface.BuyfactUCService;
import accounting.ServiceInterface.FactsituationUCService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import store.Entity.Good;
import store.ServiceInterface.GoodUCService;

@ManagedBean(name = "BuyfactMB")
@ViewScoped

public class BuyfactMB extends baseManagedBeanController<Buyfact> implements Serializable {
	private static final long serialVersionUID = 7175212628505956385L;

	public BuyfactMB() {
	}

	// Services Deceleration
	@Autowired
	private BuyfactUCService buyfactService;
	@Autowired
	private FactsituationUCService FactsituationService;
	@Autowired
	private GoodUCService GoodService;

	/*
	 * @Autowired private TransactionUCService transactionService;
	 */

	private Long gid;
	private Long gnum;

	// base Object, relations Lists (1-* objects)
	public List<Factsituation> FindAll_Factsituation() {
		return FactsituationService.FindAll("id", JPAOp.Asc);
	}

	// base Object, relations Lists (1-* objects)
	public List<Good> FindAll_Goods() {
		return GoodService.FindAll("id", JPAOp.Asc);
	}

	/*
	 * public List<Transaction> FindAll_Transaction() { return
	 * transactionService.FindAll("id", JPAOp.Asc); }
	 */
	@Override
	protected void ResetBaseObject() {
		super.ResetBaseObject();

		// new Base Object
		baseEntity = new Buyfact();

		// new other Objects and set them into Base object

		if (null == baseEntity.getTransaction())
			baseEntity.setTransaction(new Transaction());

		if (null == baseEntity.getFactsituation())
			baseEntity.setFactsituation(new Factsituation());

		// refresh Lists
		baseEntityList = buyfactService.FindAll("id", JPAOp.Asc);
	}

	String date = "";

	// UC: Add/Edit
	public void AddEdit() throws gException {
		String result = "";

		try {
			if (isedit)
				buyfactService.Edit(baseEntity);
			else
				result = buyfactService.Add(baseEntity);

			ResetBaseObject();

			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");

		} catch (Exception ex) {
			CallCatch(ex);
		}

	}

	public void Add() throws gException {
		String result = "";
		try {
			result = buyfactService.cadd(baseEntity, gid, gnum);

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
	public void Remove(Buyfact baseEntity) {

		try {
			buyfactService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		} catch (Exception ex) {
			CallCatch(ex);
		}
	}

	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters
	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Long getGnum() {
		return gnum;
	}

	public void setGnum(Long gnum) {
		this.gnum = gnum;
	}
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Setters & Getters

}