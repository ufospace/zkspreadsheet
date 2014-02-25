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
package org.zkoss.zss.ngapi.impl.imexp;

import java.io.*;

import org.zkoss.zss.model.SBook;
import org.zkoss.zss.ngapi.NExporter;

public abstract class AbstractExporter implements NExporter, Serializable{
	@Override
	public void export(SBook book, File file) throws IOException {
		OutputStream os = null;
		try{
			os = new FileOutputStream(file);
			export(book,os);
		}finally{
			if(os!=null){
				try{
					os.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
}
