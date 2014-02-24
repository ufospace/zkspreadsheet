/* PictureImpl.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/5/1 , Created by dennis
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zss.api.model.impl;

import org.zkoss.poi.ss.usermodel.ClientAnchor;
import org.zkoss.zss.api.SheetAnchor;
import org.zkoss.zss.api.model.Picture;
import org.zkoss.zss.ngmodel.NPicture;
import org.zkoss.zss.ngmodel.NSheet;
import org.zkoss.zss.ngmodel.NViewAnchor;
/**
 * 
 * @author dennis
 * @since 3.0.0
 */
public class PictureImpl implements Picture{
	
	private ModelRef<NSheet> _sheetRef;
	private ModelRef<NPicture> _picRef;
	
	public PictureImpl(ModelRef<NSheet> sheetRef, ModelRef<NPicture> picRef) {
		this._sheetRef = sheetRef;
		this._picRef = picRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_picRef == null) ? 0 : _picRef.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PictureImpl other = (PictureImpl) obj;
		if (_picRef == null) {
			if (other._picRef != null)
				return false;
		} else if (!_picRef.equals(other._picRef))
			return false;
		return true;
	}
	
	public NPicture getNative() {
		return _picRef.get();
	}
	
	
	public String getId(){
		return getNative().getId();
	}

	@Override
	public SheetAnchor getAnchor() {
		NViewAnchor anchor = getNative().getAnchor();
		return anchor==null?null:SheetImpl.toSheetAnchor(_sheetRef.get(), anchor);
	}
}
