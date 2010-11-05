/* DocumentLink.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Sep 27, 2010 5:55:09 PM , Created by Sam
}}IS_NOTE

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 3.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zss.app.link;

import java.util.List;

import org.zkoss.zk.ui.HtmlMacroComponent;

/**
 * @author Sam
 *
 */
public class DocumentLink extends HtmlMacroComponent {
	
	public DocumentLink() {
		this.setMacroURI("/menus/hyperlink/docLink.zul");
	}
	
	/**
	 * Sets the available url to select
	 */
//	public void setAddress(List addr) {
//		Combobox cb = this.getFellow("")
//	}
//	
//	public String getSelectedAddress() {
//		
//	}
}
