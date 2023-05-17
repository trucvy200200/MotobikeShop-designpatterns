package com.MotorbikeStore.model;

import java.util.ArrayList;
import java.util.List;

public class AbstractModel<T> {
	private int[] ids;

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
	private List<T> listResult = new ArrayList<>();

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
}
