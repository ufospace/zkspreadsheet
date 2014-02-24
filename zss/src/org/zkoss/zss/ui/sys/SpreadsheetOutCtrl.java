/* SpreadsheetOutCtrl.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Dec 18, 2007 12:18:09 PM     2007, Created by Dennis.Chen
}}IS_NOTE

Copyright (C) 2007 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
	This program is distributed under GPL Version 2.0 in the hope that
	it will be useful, but WITHOUT ANY WARRANTY.
}}IS_RIGHT
*/
package org.zkoss.zss.ui.sys;

import org.zkoss.zss.ngmodel.NSheet;

/**
 * Special controller interface for controlling Server to Client behavior.
 * Only spreadsheet developer need to use this interface. 
 * @author Dennis.Chen
 *
 */
public interface SpreadsheetOutCtrl {
	
	public void insertColumns(NSheet sheet,int col,int size);
	
	public void insertRows(NSheet sheet,int row,int size);
	
	public void removeColumns(NSheet sheet,int col,int size);
	
	public void removeRows(NSheet sheet,int row,int size);
	
	public void updateMergeCell(NSheet sheet,int left,int top,int right,int bottom,
			int oleft,int otop,int oright,int obottom);
	public void deleteMergeCell(NSheet sheet,int left,int top,int right,int bottom);
	
	public void addMergeCell(NSheet sheet,int left,int top,int right,int bottom);
	
	public void setColumnWidth(NSheet sheet,int col,int width, int id, boolean hidden);
	public void setRowHeight(NSheet sheet,int row, int height, int id, boolean hidden, boolean isCustom);
}
