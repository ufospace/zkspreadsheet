/* EnumUtil.java

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

import org.zkoss.poi.common.usermodel.Hyperlink;
import org.zkoss.zss.api.Range.ApplyBorderType;
import org.zkoss.zss.api.Range.AutoFillType;
import org.zkoss.zss.api.Range.AutoFilterOperation;
import org.zkoss.zss.api.Range.DeleteShift;
import org.zkoss.zss.api.Range.InsertCopyOrigin;
import org.zkoss.zss.api.Range.InsertShift;
import org.zkoss.zss.api.Range.PasteOperation;
import org.zkoss.zss.api.Range.PasteType;
import org.zkoss.zss.api.Range.SortDataOption;
import org.zkoss.zss.api.model.*;
import org.zkoss.zss.api.model.CellStyle.Alignment;
import org.zkoss.zss.api.model.CellStyle.BorderType;
import org.zkoss.zss.api.model.CellStyle.FillPattern;
import org.zkoss.zss.api.model.CellStyle.VerticalAlignment;
import org.zkoss.zss.api.model.Chart.Grouping;
import org.zkoss.zss.api.model.Chart.LegendPosition;
import org.zkoss.zss.api.model.Chart.Type;
import org.zkoss.zss.api.model.Font.Boldweight;
import org.zkoss.zss.api.model.Font.TypeOffset;
import org.zkoss.zss.api.model.Font.Underline;
import org.zkoss.zss.api.model.Hyperlink.HyperlinkType;
import org.zkoss.zss.api.model.Picture.Format;
import org.zkoss.zss.model.*;
import org.zkoss.zss.model.SAutoFilter.FilterOp;
import org.zkoss.zss.model.SChart.NChartGrouping;
import org.zkoss.zss.model.SChart.NChartLegendPosition;
import org.zkoss.zss.model.SChart.NChartType;
import org.zkoss.zss.ngapi.NRange;
import org.zkoss.zss.ngapi.NRange.FillType;
/**
 * 
 * @author dennis
 * @since 3.0.0
 */
public class EnumUtil {
	
	private static <T> void assertArgNotNull(T obj,String name){
		if(obj == null){
			throw new IllegalArgumentException("argument "+name==null?"":name+" is null");
		}
	}
	
	public static NRange.PasteOperation toRangePasteOpNative(PasteOperation op) {
		assertArgNotNull(op,"paste operation");
		switch(op){
		case ADD:
			return NRange.PasteOperation.ADD;
		case SUB:
			return NRange.PasteOperation.SUB;
		case MUL:
			return NRange.PasteOperation.MUL;
		case DIV:
			return NRange.PasteOperation.DIV;
		case NONE:
			return NRange.PasteOperation.NONE;
		}
		throw new IllegalArgumentException("unknow paste operation "+op);
	}


	public static NRange.PasteType toRangePasteTypeNative(PasteType type) {
		assertArgNotNull(type,"paste type");
		switch(type){
		case ALL:
			return NRange.PasteType.ALL;
		case ALL_EXCEPT_BORDERS:
			return NRange.PasteType.ALL_EXCEPT_BORDERS;
		case COLUMN_WIDTHS:
			return NRange.PasteType.COLUMN_WIDTHS;
		case COMMENTS:
			return NRange.PasteType.COMMENTS;
		case FORMATS:
			return NRange.PasteType.FORMATS;
		case FORMULAS:
			return NRange.PasteType.FORMULAS;
		case FORMULAS_AND_NUMBER_FORMATS:
			return NRange.PasteType.FORMULAS_AND_NUMBER_FORMATS;
		case VALIDATAION:
			return NRange.PasteType.VALIDATAION;
		case VALUES:
			return NRange.PasteType.VALUES;
		case VALUES_AND_NUMBER_FORMATS:
			return NRange.PasteType.VALUES_AND_NUMBER_FORMATS;
		}
		throw new IllegalArgumentException("unknow paste operation "+type);
	}
	
	public static TypeOffset toFontTypeOffset(SFont.TypeOffset typeOffset){
		switch(typeOffset){
		case NONE:
			return Font.TypeOffset.NONE;
		case SUB:
			return Font.TypeOffset.SUB;
		case SUPER:
			return Font.TypeOffset.SUPER;
		}
		throw new IllegalArgumentException("unknow font type offset "+typeOffset);
	}

	public static SFont.TypeOffset toFontTypeOffset(TypeOffset typeOffset) {
		assertArgNotNull(typeOffset,"typeOffset");
		switch(typeOffset){
		case NONE:
			return SFont.TypeOffset.NONE;
		case SUB:
			return SFont.TypeOffset.SUB;
		case SUPER:
			return SFont.TypeOffset.SUPER;
		}
		throw new IllegalArgumentException("unknow font type offset "+typeOffset);
	}

	public static Underline toFontUnderline(SFont.Underline underline) {
		switch(underline){
		case NONE:
			return Font.Underline.NONE;
		case SINGLE:
			return Font.Underline.SINGLE;
		case SINGLE_ACCOUNTING:
			return Font.Underline.SINGLE_ACCOUNTING;
		case DOUBLE:
			return Font.Underline.DOUBLE;
		case DOUBLE_ACCOUNTING:
			return Font.Underline.DOUBLE_ACCOUNTING;
		}
		throw new IllegalArgumentException("unknow font underline "+underline);
	}


	public static SFont.Underline toFontUnderline(Underline underline) {
		assertArgNotNull(underline,"underline");
		switch(underline){
		case NONE:
			return SFont.Underline.NONE;
		case SINGLE:
			return SFont.Underline.SINGLE;
		case SINGLE_ACCOUNTING:
			return SFont.Underline.SINGLE_ACCOUNTING;
		case DOUBLE:
			return SFont.Underline.DOUBLE;
		case DOUBLE_ACCOUNTING:
			return SFont.Underline.DOUBLE_ACCOUNTING;
		}
		throw new IllegalArgumentException("unknow font underline "+underline);
	}

	public static Boldweight toFontBoldweight(org.zkoss.zss.model.SFont.Boldweight boldweight) {
		switch(boldweight){
		case BOLD:
			return Font.Boldweight.BOLD;
		case NORMAL:
			return Font.Boldweight.NORMAL;
		}
		throw new IllegalArgumentException("unknow font boldweight "+boldweight);
	}
	
	public static SFont.Boldweight toFontBoldweight(Boldweight boldweight) {
		switch(boldweight){
		case BOLD:
			return SFont.Boldweight.BOLD;
		case NORMAL:
			return SFont.Boldweight.NORMAL;
		}
		throw new IllegalArgumentException("unknow font boldweight "+boldweight);
	}

	public static FillPattern toStyleFillPattern(SCellStyle.FillPattern pattern) {
		switch(pattern){
		case NO_FILL:
			return CellStyle.FillPattern.NO_FILL;
		case SOLID_FOREGROUND:
			return CellStyle.FillPattern.SOLID_FOREGROUND;
		case FINE_DOTS:
			return CellStyle.FillPattern.FINE_DOTS;
		case ALT_BARS:
			return CellStyle.FillPattern.ALT_BARS;
		case SPARSE_DOTS:
			return CellStyle.FillPattern.SPARSE_DOTS;
		case THICK_HORZ_BANDS:
			return CellStyle.FillPattern.THICK_HORZ_BANDS;
		case THICK_VERT_BANDS:
			return CellStyle.FillPattern.THICK_VERT_BANDS;
		case THICK_BACKWARD_DIAG:
			return CellStyle.FillPattern.THICK_BACKWARD_DIAG;
		case THICK_FORWARD_DIAG:
			return CellStyle.FillPattern.THICK_FORWARD_DIAG;
		case BIG_SPOTS:
			return CellStyle.FillPattern.BIG_SPOTS;
		case BRICKS:
			return CellStyle.FillPattern.BRICKS;
		case THIN_HORZ_BANDS:
			return CellStyle.FillPattern.THIN_HORZ_BANDS;
		case THIN_VERT_BANDS:
			return CellStyle.FillPattern.THIN_VERT_BANDS;
		case THIN_BACKWARD_DIAG:
			return CellStyle.FillPattern.THIN_BACKWARD_DIAG;
		case THIN_FORWARD_DIAG:
			return CellStyle.FillPattern.THIN_FORWARD_DIAG;
		case SQUARES:
			return CellStyle.FillPattern.SQUARES;
		case DIAMONDS:
			return CellStyle.FillPattern.DIAMONDS;
		case LESS_DOTS:
			return CellStyle.FillPattern.LESS_DOTS;
		case LEAST_DOTS:
			return CellStyle.FillPattern.LEAST_DOTS;
		}
		throw new IllegalArgumentException("unknow pattern type "+pattern);	
	}
	
	public static SCellStyle.FillPattern toStyleFillPattern(FillPattern pattern) {
		switch(pattern){
		case NO_FILL:
			return SCellStyle.FillPattern.NO_FILL;
		case SOLID_FOREGROUND:
			return SCellStyle.FillPattern.SOLID_FOREGROUND;
		case FINE_DOTS:
			return SCellStyle.FillPattern.FINE_DOTS;
		case ALT_BARS:
			return SCellStyle.FillPattern.ALT_BARS;
		case SPARSE_DOTS:
			return SCellStyle.FillPattern.SPARSE_DOTS;
		case THICK_HORZ_BANDS:
			return SCellStyle.FillPattern.THICK_HORZ_BANDS;
		case THICK_VERT_BANDS:
			return SCellStyle.FillPattern.THICK_VERT_BANDS;
		case THICK_BACKWARD_DIAG:
			return SCellStyle.FillPattern.THICK_BACKWARD_DIAG;
		case THICK_FORWARD_DIAG:
			return SCellStyle.FillPattern.THICK_FORWARD_DIAG;
		case BIG_SPOTS:
			return SCellStyle.FillPattern.BIG_SPOTS;
		case BRICKS:
			return SCellStyle.FillPattern.BRICKS;
		case THIN_HORZ_BANDS:
			return SCellStyle.FillPattern.THIN_HORZ_BANDS;
		case THIN_VERT_BANDS:
			return SCellStyle.FillPattern.THIN_VERT_BANDS;
		case THIN_BACKWARD_DIAG:
			return SCellStyle.FillPattern.THIN_BACKWARD_DIAG;
		case THIN_FORWARD_DIAG:
			return SCellStyle.FillPattern.THIN_FORWARD_DIAG;
		case SQUARES:
			return SCellStyle.FillPattern.SQUARES;
		case DIAMONDS:
			return SCellStyle.FillPattern.DIAMONDS;
		case LESS_DOTS:
			return SCellStyle.FillPattern.LESS_DOTS;
		case LEAST_DOTS:
			return SCellStyle.FillPattern.LEAST_DOTS;
		}
		throw new IllegalArgumentException("unknow pattern type "+pattern);
	}

	public static SCellStyle.Alignment toStyleAlignemnt(Alignment alignment) {
		switch(alignment){
		case GENERAL:
			return SCellStyle.Alignment.GENERAL;
		case LEFT:
			return SCellStyle.Alignment.LEFT;
		case CENTER:
			return SCellStyle.Alignment.CENTER;
		case RIGHT:
			return SCellStyle.Alignment.RIGHT;
		case FILL:
			return SCellStyle.Alignment.FILL;
		case JUSTIFY:
			return SCellStyle.Alignment.JUSTIFY;
		case CENTER_SELECTION:
			return SCellStyle.Alignment.CENTER_SELECTION;
		}
		throw new IllegalArgumentException("unknow cell alignment "+alignment);
	}
	public static Alignment toStyleAlignemnt(SCellStyle.Alignment alignment) {
		switch(alignment){
		case GENERAL:
			return Alignment.GENERAL;
		case LEFT:
			return Alignment.LEFT;
		case CENTER:
			return Alignment.CENTER;
		case RIGHT:
			return Alignment.RIGHT;
		case FILL:
			return Alignment.FILL;
		case JUSTIFY:
			return Alignment.JUSTIFY;
		case CENTER_SELECTION:
			return Alignment.CENTER_SELECTION;
		}
		throw new IllegalArgumentException("unknow cell alignment "+alignment);
	}
	public static SCellStyle.VerticalAlignment toStyleVerticalAlignemnt(VerticalAlignment alignment) {
		switch(alignment){
		case TOP:
			return SCellStyle.VerticalAlignment.TOP;
		case CENTER:
			return SCellStyle.VerticalAlignment.CENTER;
		case BOTTOM:
			return SCellStyle.VerticalAlignment.BOTTOM;
		case JUSTIFY:
			return SCellStyle.VerticalAlignment.JUSTIFY;
		}
		throw new IllegalArgumentException("unknow cell vertical alignment "+alignment);
	}
	public static VerticalAlignment toStyleVerticalAlignemnt(SCellStyle.VerticalAlignment alignment) {
		switch(alignment){
		case TOP:
			return VerticalAlignment.TOP;
		case CENTER:
			return VerticalAlignment.CENTER;
		case BOTTOM:
			return VerticalAlignment.BOTTOM;
		case JUSTIFY:
			return VerticalAlignment.JUSTIFY;
		}
		throw new IllegalArgumentException("unknow cell vertical alignment "+alignment);
	}

	public static NRange.ApplyBorderType toRangeApplyBorderType(ApplyBorderType type) {
		switch(type){
		case FULL:
			return NRange.ApplyBorderType.FULL;
		case EDGE_BOTTOM:
			return NRange.ApplyBorderType.EDGE_BOTTOM;
		case EDGE_RIGHT:
			return NRange.ApplyBorderType.EDGE_RIGHT;
		case EDGE_TOP:
			return NRange.ApplyBorderType.EDGE_TOP;
		case EDGE_LEFT:
			return NRange.ApplyBorderType.EDGE_LEFT;
		case OUTLINE:
			return NRange.ApplyBorderType.OUTLINE;
		case INSIDE:
			return NRange.ApplyBorderType.INSIDE;
		case INSIDE_HORIZONTAL:
			return NRange.ApplyBorderType.INSIDE_HORIZONTAL;
		case INSIDE_VERTICAL:
			return NRange.ApplyBorderType.INSIDE_VERTICAL;
		case DIAGONAL:
			return NRange.ApplyBorderType.DIAGONAL;
		case DIAGONAL_DOWN:
			return NRange.ApplyBorderType.DIAGONAL_DOWN;
		case DIAGONAL_UP:
			return NRange.ApplyBorderType.DIAGONAL_UP;
		}
		throw new IllegalArgumentException("unknow cell border apply type "+type);
	}

	public static SCellStyle.BorderType toStyleBorderType(BorderType borderType) {
		switch(borderType){
		case NONE:
			return SCellStyle.BorderType.NONE;
		case THIN:
			return SCellStyle.BorderType.THIN;
		case MEDIUM:
			return SCellStyle.BorderType.MEDIUM;
		case DASHED:
			return SCellStyle.BorderType.DASHED;
		case HAIR:
			return SCellStyle.BorderType.HAIR;
		case THICK:
			return SCellStyle.BorderType.THICK;
		case DOUBLE:
			return SCellStyle.BorderType.DOUBLE;
		case DOTTED:
			return SCellStyle.BorderType.DOTTED;
		case MEDIUM_DASHED:
			return SCellStyle.BorderType.MEDIUM_DASHED;
		case DASH_DOT:
			return SCellStyle.BorderType.DASH_DOT;
		case MEDIUM_DASH_DOT:
			return SCellStyle.BorderType.MEDIUM_DASH_DOT;
		case DASH_DOT_DOT:
			return SCellStyle.BorderType.DASH_DOT_DOT;
		case MEDIUM_DASH_DOT_DOT:
			return SCellStyle.BorderType.MEDIUM_DASH_DOT_DOT;
		case SLANTED_DASH_DOT:
			return SCellStyle.BorderType.SLANTED_DASH_DOT;
		}
		throw new IllegalArgumentException("unknow style border type "+borderType);
	}
	
	public static BorderType toStyleBorderType(SCellStyle.BorderType borderType) {
		switch(borderType){
		case NONE:
			return BorderType.NONE;
		case THIN:
			return BorderType.THIN;
		case MEDIUM:
			return BorderType.MEDIUM;
		case DASHED:
			return BorderType.DASHED;
		case HAIR:
			return BorderType.HAIR;
		case THICK:
			return BorderType.THICK;
		case DOUBLE:
			return BorderType.DOUBLE;
		case DOTTED:
			return BorderType.DOTTED;
		case MEDIUM_DASHED:
			return BorderType.MEDIUM_DASHED;
		case DASH_DOT:
			return BorderType.DASH_DOT;
		case MEDIUM_DASH_DOT:
			return BorderType.MEDIUM_DASH_DOT;
		case DASH_DOT_DOT:
			return BorderType.DASH_DOT_DOT;
		case MEDIUM_DASH_DOT_DOT:
			return BorderType.MEDIUM_DASH_DOT_DOT;
		case SLANTED_DASH_DOT:
			return BorderType.SLANTED_DASH_DOT;
		}
		throw new IllegalArgumentException("unknow style border type "+borderType);
	}
	
	public static SCellStyle.BorderType toRangeBorderType(BorderType lineStyle) {
		switch(lineStyle){
		case NONE:
			return SCellStyle.BorderType.NONE;
		case THIN:
			return SCellStyle.BorderType.THIN;
		case MEDIUM:
			return SCellStyle.BorderType.MEDIUM;
		case DASHED:
			return SCellStyle.BorderType.DASHED;
		case HAIR:
			return SCellStyle.BorderType.HAIR;
		case THICK:
			return SCellStyle.BorderType.THICK;
		case DOUBLE:
			return SCellStyle.BorderType.DOUBLE;
		case DOTTED:
			return SCellStyle.BorderType.DOTTED;
		case MEDIUM_DASHED:
			return SCellStyle.BorderType.MEDIUM_DASHED;
		case DASH_DOT:
			return SCellStyle.BorderType.DASH_DOT;
		case MEDIUM_DASH_DOT:
			return SCellStyle.BorderType.MEDIUM_DASH_DOT;
		case DASH_DOT_DOT:
			return SCellStyle.BorderType.DASH_DOT_DOT;
		case MEDIUM_DASH_DOT_DOT:
			return SCellStyle.BorderType.MEDIUM_DASH_DOT_DOT;
		case SLANTED_DASH_DOT:
			return SCellStyle.BorderType.SLANTED_DASH_DOT;
		}
		throw new IllegalArgumentException("unknow cell border line style "+lineStyle);
	}

	public static NRange.InsertShift toRangeInsertShift(InsertShift shift) {
		switch(shift){
		case DEFAULT:
			return NRange.InsertShift.DEFAULT;
		case DOWN:
			return NRange.InsertShift.DOWN;
		case RIGHT:
			return NRange.InsertShift.RIGHT;
		}
		throw new IllegalArgumentException("unknow range insert shift "+shift);
	}

	public static NRange.InsertCopyOrigin toRangeInsertCopyOrigin(InsertCopyOrigin copyOrigin) {
		switch(copyOrigin){
		case FORMAT_NONE:
			return NRange.InsertCopyOrigin.FORMAT_NONE;
		case FORMAT_LEFT_ABOVE:
			return NRange.InsertCopyOrigin.FORMAT_LEFT_ABOVE;
		case FORMAT_RIGHT_BELOW:
			return NRange.InsertCopyOrigin.FORMAT_RIGHT_BELOW;
		}
		throw new IllegalArgumentException("unknow range insert copy origin "+copyOrigin);
	}
	
	public static NRange.DeleteShift toRangeDeleteShift(DeleteShift shift) {
		switch(shift){
		case DEFAULT:
			return NRange.DeleteShift.DEFAULT;
		case UP:
			return NRange.DeleteShift.UP;
		case LEFT:
			return NRange.DeleteShift.LEFT;
		}
		throw new IllegalArgumentException("unknow range delete shift "+shift);
	}

	public static NRange.SortDataOption toRangeSortDataOption(SortDataOption dataOption) {
		switch(dataOption){
		case TEXT_AS_NUMBERS:
			return NRange.SortDataOption.TEXT_AS_NUMBERS;
		case NORMAL_DEFAULT:
			return NRange.SortDataOption.NORMAL_DEFAULT;
		}
		throw new IllegalArgumentException("unknow sort data option "+dataOption);
	}

	public static FilterOp toRangeAutoFilterOperation(AutoFilterOperation filterOp) {
		switch(filterOp){
		case AND:
			return FilterOp.AND;
		case OR:
			return FilterOp.OR;
		case TOP10:
			return FilterOp.TOP10;
		case TOP10PERCENT:
			return FilterOp.TOP10_PERCENT;
		case BOTTOM10:
			return FilterOp.BOTTOM10;
		case BOTOOM10PERCENT:
			return FilterOp.BOTOOM10_PERCENT;
		case VALUES:
			return FilterOp.VALUES;
		}
		throw new IllegalArgumentException("unknow autofilter operation "+filterOp);
	}

	public static FillType toRangeFillType(AutoFillType fillType) {
		switch(fillType){
		case COPY:
			return FillType.COPY;
		case DAYS:
			return FillType.DAYS;
		case DEFAULT:
			return FillType.DEFAULT;
		case FORMATS:
			return FillType.FORMATS;
		case MONTHS:
			return FillType.MONTHS;
		case SERIES:
			return FillType.SERIES;
		case VALUES:
			return FillType.VALUES;
		case WEEKDAYS:
			return FillType.WEEKDAYS;
		case YEARS:
			return FillType.YEARS;
		case GROWTH_TREND:
			return FillType.GROWTH_TREND;
		case LINER_TREND:
			return FillType.LINER_TREND;
		}
		throw new IllegalArgumentException("unknow fill type "+fillType);
	}

	public static SHyperlink.HyperlinkType toHyperlinkType(HyperlinkType type) {
		switch(type){
		case URL:
			return SHyperlink.HyperlinkType.URL;
		case DOCUMENT:
			return SHyperlink.HyperlinkType.DOCUMENT;
		case EMAIL:
			return SHyperlink.HyperlinkType.EMAIL;
		case FILE:
			return SHyperlink.HyperlinkType.FILE;
		}
		throw new IllegalArgumentException("unknow hyperlink type "+type);
	}
	public static HyperlinkType toHyperlinkType(int type) {
		switch(type){
		case Hyperlink.LINK_URL:
			return HyperlinkType.URL;
		case Hyperlink.LINK_DOCUMENT:
			return HyperlinkType.DOCUMENT;
		case Hyperlink.LINK_EMAIL:
			return HyperlinkType.EMAIL;
		case Hyperlink.LINK_FILE:
			return HyperlinkType.FILE;
		}
		throw new IllegalArgumentException("unknow hyperlink type "+type);
	}
	public static HyperlinkType toHyperlinkType(SHyperlink.HyperlinkType type) {
		switch(type){
		case URL:
			return HyperlinkType.URL;
		case DOCUMENT:
			return HyperlinkType.DOCUMENT;
		case EMAIL:
			return HyperlinkType.EMAIL;
		case FILE:
			return HyperlinkType.FILE;
		}
		throw new IllegalArgumentException("unknow hyperlink type "+type);
	}

	public static SPicture.Format toPictureFormat(Format format) {
		switch(format){
		case EMF:
			return SPicture.Format.EMF;
		case WMF:
			return SPicture.Format.WMF;
		case PICT:
			return SPicture.Format.PICT;
		case JPEG:
			return SPicture.Format.JPG;
		case PNG:
			return SPicture.Format.PNG;
		case DIB:
			return SPicture.Format.DIB;
		}
		throw new IllegalArgumentException("unknow pciture format "+format);
	}

	public static NChartType toChartType(Type type) {
		switch(type){
		case AREA_3D:
		case AREA:
			return NChartType.AREA;
		case BAR_3D:
		case BAR:
			return NChartType.BAR;
		case BUBBLE:
			return NChartType.BUBBLE;
		case COLUMN:
		case COLUMN_3D:
			return NChartType.COLUMN;
		case DOUGHNUT:
			return NChartType.DOUGHNUT;
		case LINE_3D:
		case LINE:
			return NChartType.LINE;
		case OF_PIE:
			return NChartType.OF_PIE;
		case PIE_3D:
		case PIE:
			return NChartType.PIE;
		case RADAR:
			return NChartType.RADAR;
		case SCATTER:
			return NChartType.SCATTER;
		case STOCK:
			return NChartType.STOCK;
		case SURFACE_3D:
		case SURFACE:
			return NChartType.SURFACE;
		}
		throw new IllegalArgumentException("unknow chart type "+type);
	}
	
	public static boolean isThreeDimentionalChart(Type type) {
		switch(type){
		case AREA_3D:
		case BAR_3D:
		case COLUMN_3D:
		case LINE_3D:
		case PIE_3D:
		case SURFACE_3D:
			return true;
		default:
			return false;
		}
	}

	public static NChartGrouping toChartGrouping(Grouping grouping) {
		switch(grouping){
		case STANDARD:
			return NChartGrouping.STANDARD;
		case STACKED:
			return NChartGrouping.STACKED;
		case PERCENT_STACKED:
			return NChartGrouping.PERCENT_STACKED;
		case CLUSTERED:
			return NChartGrouping.CLUSTERED;//bar only
		}
		throw new IllegalArgumentException("unknow grouping "+grouping);
	}

	public static NChartLegendPosition toLegendPosition(LegendPosition pos) {
		switch(pos){
		case BOTTOM:
			return NChartLegendPosition.BOTTOM;
		case LEFT:
			return NChartLegendPosition.LEFT;
		case RIGHT:
			return NChartLegendPosition.RIGHT;
		case TOP:
			return NChartLegendPosition.TOP;
		case TOP_RIGHT:
			return NChartLegendPosition.TOP_RIGHT;
		}
		throw new IllegalArgumentException("unknow legend position "+pos);
	}
}
