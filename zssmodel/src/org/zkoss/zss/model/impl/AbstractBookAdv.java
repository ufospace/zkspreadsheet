/*

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/12/01 , Created by dennis
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zss.model.impl;

import java.io.Serializable;

import org.zkoss.zss.model.ModelEvent;
import org.zkoss.zss.model.SBook;
import org.zkoss.zss.model.SBookSeries;
import org.zkoss.zss.model.SCellStyle;
import org.zkoss.zss.model.SExtraStyle;
import org.zkoss.zss.model.SFont;
import org.zkoss.zss.model.SName;
import org.zkoss.zss.model.STable;
import org.zkoss.zss.model.STableStyle;
import org.zkoss.zss.model.sys.formula.EvaluationContributorContainer;
/**
 * 
 * @author dennis
 * @since 3.5.0
 */
public abstract class AbstractBookAdv implements SBook,EvaluationContributorContainer,Serializable{
	private static final long serialVersionUID = 1L;
	
	public abstract void sendModelEvent(ModelEvent event);
	
	/*package*/ abstract String nextObjId(String type);

	/*package*/ abstract void setBookSeries(SBookSeries bookSeries);

	public abstract String getId();
	
	//ZSS-854
	public abstract void clearDefaultCellStyles();
	
	//ZSS-854
	public abstract void clearNamedStyles();

	//ZSS-854
	public abstract void initDefaultCellStyles();
	
	//ZSS-855
	public abstract SName createTableName(STable table);
	
	//ZSS-855
	public abstract void addTable(STable table);

	//ZSS-855
	public abstract STable getTable(String name);
	
	//ZSS-855
	public abstract STable removeTable(String name);
	
	//ZSS-967
	//return null if newName is not duplicated in the Table
	public abstract String setTableColumnName(STable table, String oldName, String newName);
	
	//ZSS-1132: setup default font
	//@since 3.8.2
	public abstract void initDefaultFont();
	
	//ZSS-1132: get character width in pixel per the default font of this book
	//@since 3.8.2
	public abstract int getCharWidth();
	
	//ZSS-1140
	//@since 3.8.2
	public abstract void clearExtraStyles();
	
	//ZSS-1141
	//@since 3.8.2
	public abstract int indexOfExtraStyle(SExtraStyle style);
	
	//ZSS-1183
	//@since 3.9.0
	/*package*/ abstract SCellStyle getOrCreateCellStyle(SCellStyle style);
	
	//ZSS-1183
	//@since 3.9.0
	/*package*/ abstract SFont getOrCreateFont(SFont font);
	
	//ZSS-1183
	//@since 3.9.0
	/*package*/ abstract SName getOrCreateName(SName name, String sheetName);
	
	//ZSS-1183
	//@since 3.9.0
	/*package*/ abstract STableStyle getOrCreateTableStyle(STableStyle src);
	//ZSS-1283
	//Returns whether this book is in post import processing. In this life 
	//cycle, none of Range.xxx() methods will do clear cell cache and do auto
	//refresh and thus speed up data population.
	//@since 3.9.1
	public abstract boolean isPostProcessing();
	public abstract void setPostProcessing(boolean b);
}
