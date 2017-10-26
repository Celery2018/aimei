package com.bizconf.dao.domain.common;

import java.io.Serializable;

/**
 * joy add
 * 基本domain对象
 *
 * */
public abstract class BaseEntity implements Serializable{

	 /**
	 * Default equality implementation 
	 * from the model point of view, if two objects have the 
	 * same id (ids are equal ) then the objects are the same 
	 * object. This equal method checks for equal ids.
	 * 
	 * Note: if you put un-initalized entities ( null id )in a collection,
	 * you will get indeterminate behavior
	 * @return
	 */
	@Override
	public boolean equals(Object ob) {
		Integer id = getId();
		if (id == null) {
			return super.equals(ob);
		}
		boolean rc = false;
		if (ob instanceof BaseEntity) {
			Integer obId = ((BaseEntity) ob).getId();
			if (obId != null && id != null) {
				rc = id.equals(obId);
			}
		}
		return rc;
	}

	/**
	 * Overridden hashcode method. if the object has an id, use the id as the
	 * hash else use default hash of the parent .
	 */
	@Override
	public int hashCode() {
		Integer id = getId();
		int hash = super.hashCode();
		if (id != null) {
			hash = id.hashCode();
		}
		return hash;
	}
	
	public abstract void setId(int id);
	
	public abstract int getId();

}
