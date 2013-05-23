package org.zkoss.zss.api.impl;

import java.io.OutputStream;

import org.zkoss.poi.hssf.util.AreaReference;
import org.zkoss.poi.hssf.util.CellReference;
import org.zkoss.zss.api.Exporter;
import org.zkoss.zss.api.model.Book;
import org.zkoss.zss.api.model.Sheet;
import org.zkoss.zss.api.model.impl.BookImpl;
import org.zkoss.zss.api.model.impl.SheetImpl;
import org.zkoss.zss.model.sys.XExporter;
import org.zkoss.zss.model.sys.impl.Headings;
import org.zkoss.zss.ui.Rect;

public class ExporterImpl implements Exporter {
	XExporter exporter;
	public ExporterImpl(XExporter exporter){
		if(exporter==null){
			throw new IllegalAccessError("exporter not found");
		}
		
		this.exporter =exporter;
	}
	public void export(Book book, OutputStream fos) {
		exporter.export(((BookImpl)book).getNative(), fos);
	}
	public void export(Sheet sheet, OutputStream fos) {
		exporter.export(((SheetImpl)sheet).getNative(), fos);
	}
	public void export(Sheet sheet,Rect selection,OutputStream fos) {
		AreaReference af = new AreaReference(new CellReference(selection.getTop(), selection.getLeft()),
				new CellReference(selection.getBottom(), selection.getRight()));
		exporter.exportSelection(((SheetImpl)sheet).getNative(), af, fos);
	}
	@Override
	public boolean isSupportHeadings() {
		return exporter instanceof Headings;
	}
	@Override
	public void enableHeadings(boolean enable) {
		if(isSupportHeadings()){
			((Headings)exporter).enableHeadings(enable);
		}else{
			throw new RuntimeException("this export doesn't support headings");
		}
	}
}
