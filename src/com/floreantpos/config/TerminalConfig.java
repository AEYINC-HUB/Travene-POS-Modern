package com.floreantpos.config;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

import com.floreantpos.model.OrderTypeFilter;
import com.floreantpos.model.PaymentStatusFilter;
import com.floreantpos.util.PasswordHasher;
import com.floreantpos.getnetinfo.NetInfo;

public class TerminalConfig {
	private static final String USE_SETTLEMENT_PROMPT = "UseSettlementPrompt"; //$NON-NLS-1$

	private static final String SHOW_GUEST_SELECTION = "show_guest_selection"; //$NON-NLS-1$

	private static final String ORDER_TYPE_FILTER = "order_type_filter"; //$NON-NLS-1$

	private static final String PS_FILTER = "ps_filter"; //$NON-NLS-1$

	private static final String SHOW_TABLE_SELECTION = "show_table_selection"; //$NON-NLS-1$

	private static final String REGULAR_MODE = "regular_mode"; //$NON-NLS-1$

	private static final String KITCHEN_MODE = "kitchen_mode"; //$NON-NLS-1$

	private static final String CASHIER_MODE = "cashier_mode"; //$NON-NLS-1$

	private static final String SHOW_DB_CONFIGURATION = "show_db_configuration"; //$NON-NLS-1$

	private static final String UI_DEFAULT_FONT = "ui_default_font"; //$NON-NLS-1$

	private static final String AUTO_LOGOFF_TIME = "AUTO_LOGOFF_TIME"; //$NON-NLS-1$

	private static final String AUTO_LOGOFF_ENABLE = "AUTO_LOGOFF_ENABLE"; //$NON-NLS-1$
	
	private static final String AUTO_CLOSESUMMARY_TIME = "AUTO_CLOSESUMMARY_TIME"; //$NON-NLS-1$

	private static final String AUTO_CLOSESUMMARY_ENABLE = "AUTO_CLOSESUMMARY_ENABLE"; //$NON-NLS-1$

	private static final String DEFAULT_PASS_LEN = "DEFAULT_PASS_LEN"; //$NON-NLS-1$
	
	private static final String EXTEND_DAY_BY_HOURS = "EXTEND_DAY_BY_HOURS"; //$NON-NLS-1$

	private static final String TOUCH_FONT_SIZE = "TOUCH_FONT_SIZE";//$NON-NLS-1$

	private static final String TOUCH_BUTTON_HEIGHT = "TOUCH_BUTTON_HEIGHT";//$NON-NLS-1$

	private static final String ADMIN_PASSWORD = "admin_pass";//$NON-NLS-1$

	static final String TERMINAL_ID = "terminal_id"; //$NON-NLS-1$
	static final String FULLSCREEN_MODE = "fullscreen_mode"; //$NON-NLS-1$
	static final String AUTO_OPEN_TAKE_OUT_TICKET = "auto_open_takeout_ticket"; //$NON-NLS-1$

	
	private static final String AUTOSAVEANDOPEN_TAKEOUT_TICKET = "auto_save_and_open";//$NON-NLS-1$
	
	private static final String AUTOTERMINAL_ID = "auto_terminal_id";//$NON-NLS-1$
	private static final String AUTOPRINTRECEIPT = "auto_print_receipt";//$NON-NLS-1$
	
	private static PropertiesConfiguration config = AppConfig.getConfig();

	public static int getTerminalId() {
		
		if (isAutoTerminalID()==true) {
			int terminalID=NetInfo.getTerminalIDFromMACAddr();
			if (terminalID!=-1) {
				return(terminalID);
			}
		}
		return config.getInt(TERMINAL_ID, -1);
	}

	public static void setTerminalId(int id) {
		config.setProperty(TERMINAL_ID, id);
	}
	
	
	public static boolean isFullscreenMode() {
		return config.getBoolean(FULLSCREEN_MODE, false);
	}

	public static boolean isAutoOpenTakeOutTicket() {
		return config.getBoolean(AUTO_OPEN_TAKE_OUT_TICKET, false);
	}

	public static void setFullscreenMode(boolean fullscreen) {
		config.setProperty(FULLSCREEN_MODE, fullscreen);
	}

	public static void setAutoOpenTakeOutTicket(boolean autoopen) {
		config.setProperty(AUTO_OPEN_TAKE_OUT_TICKET, autoopen);
	}

	public static String getAdminPassword() {
		return config.getString(ADMIN_PASSWORD, PasswordHasher.hashPassword("1111")); //$NON-NLS-1$
	}
	
	public static void setAdminPassword(String password) {
		config.setProperty(ADMIN_PASSWORD, PasswordHasher.hashPassword(password));
	}

	public static boolean matchAdminPassword(String password) {
		return getAdminPassword().equals(PasswordHasher.hashPassword(password));
	}
	
	public static void setTouchScreenButtonHeight(int height) {
		config.setProperty(TOUCH_BUTTON_HEIGHT, height);
	}
	
	public static int getTouchScreenButtonHeight() {
		return config.getInt(TOUCH_BUTTON_HEIGHT, 80);
	}
	
	public static void setTouchScreenFontSize(int size) {
		config.setProperty(TOUCH_FONT_SIZE, size);
	}
	
	public static int getTouchScreenFontSize() {
		return config.getInt(TOUCH_FONT_SIZE, 12);
	}

	public static void setDefaultPassLen(int defaultPassLen) {
		config.setProperty(DEFAULT_PASS_LEN, defaultPassLen);
	}
	
	public static int getDefaultPassLen() {
		return config.getInt(DEFAULT_PASS_LEN, 4);
	}
	
	
	public static void setExtendedDayHours(int extendedDayHours) {
		config.setProperty(EXTEND_DAY_BY_HOURS, extendedDayHours);
	}
	
	public static int getExtendedDayHours() {
		return config.getInt(EXTEND_DAY_BY_HOURS, 0);
	}
	
	public static boolean isAutoLogoffEnable() {
		return config.getBoolean(AUTO_LOGOFF_ENABLE, true);
	}
	
	public static void setAutoLogoffEnable(boolean enable) {
		config.setProperty(AUTO_LOGOFF_ENABLE, enable);
	}
	
	public static void setAutoLogoffTime(int time) {
		config.setProperty(AUTO_LOGOFF_TIME, time);
	}
	
	public static int getAutoLogoffTime() {
		return config.getInt(AUTO_LOGOFF_TIME, 60);
	}
	
	
	public static boolean isAutoCloseSummaryEnable() {
		return config.getBoolean(AUTO_CLOSESUMMARY_ENABLE, true);
	}
	
	public static void setAutoCloseSummaryEnable(boolean enable) {
		config.setProperty(AUTO_CLOSESUMMARY_ENABLE, enable);
	}
	
	public static void setAutoCloseSummaryTime(int time) {
		config.setProperty(AUTO_CLOSESUMMARY_TIME, time);
	}
	
	public static int getAutoCloseSummaryTime() {
		return config.getInt(AUTO_CLOSESUMMARY_TIME, 30);
	}
	
	public static String getUiDefaultFont() {
		return config.getString(UI_DEFAULT_FONT);
	}
	
	public static void setUiDefaultFont(String fontName) {
		config.setProperty(UI_DEFAULT_FONT, fontName);
	}
	
	public static void setShowDbConfigureButton(boolean show) {
		config.setProperty(SHOW_DB_CONFIGURATION, show);
	}
	
	public static boolean isShowDbConfigureButton() {
		return config.getBoolean(SHOW_DB_CONFIGURATION, true);
	}
	
	public static boolean isCashierMode() {
		return false; //config.getBoolean(CASHIER_MODE, false);
	}
	
	public static void setCashierMode(boolean cashierMode) {
		config.setProperty(CASHIER_MODE, cashierMode);
	}
	
	public static boolean isRegularMode() {
		return config.getBoolean(REGULAR_MODE, false);
	}
	
	public static void setRegularMode(boolean regularMode) {
		config.setProperty(REGULAR_MODE, regularMode);
	}
	
	public static boolean isKitchenMode() {
		return config.getBoolean(KITCHEN_MODE, false);
	}
	
	public static void setKitchenMode(boolean kitchenMode) {
		config.setProperty(KITCHEN_MODE, kitchenMode);
	}
	
	public static boolean isUseTranslatedName() {
		return config.getBoolean("use_translated_name", false); //$NON-NLS-1$
	}
	
	public static void setUseTranslatedName(boolean useTranslatedName) {
		config.setProperty("use_translated_name", useTranslatedName); //$NON-NLS-1$
	}
	
	public static OrderTypeFilter getOrderTypeFilter() {
		return OrderTypeFilter.fromString(config.getString(ORDER_TYPE_FILTER));
	}
	
	public static void setOrderTypeFilter(String filter) {
		config.setProperty(ORDER_TYPE_FILTER, filter);
	}
	
	public static PaymentStatusFilter getPaymentStatusFilter() {
		return PaymentStatusFilter.fromString(config.getString(PS_FILTER));
	}
	
	public static void setPaymentStatusFilter(String filter) {
		config.setProperty(PS_FILTER, filter);
	}
	
	public static void setShouldShowTableSelection(boolean showTableSelection) {
		config.setProperty(SHOW_TABLE_SELECTION, Boolean.valueOf(showTableSelection));
	}
	
	public static boolean isShouldShowTableSelection() {
		return config.getBoolean(SHOW_TABLE_SELECTION, Boolean.TRUE);
	}
	
	public static void setShouldShowGuestSelection(boolean showGuestSelection) {
		config.setProperty(SHOW_GUEST_SELECTION, Boolean.valueOf(showGuestSelection));
	}
	
	public static boolean isShouldShowGuestSelection() {
		return config.getBoolean(SHOW_GUEST_SELECTION, Boolean.TRUE);
	}
	
	public static void setUseSettlementPrompt(boolean settlementPrompt) {
		config.setProperty(USE_SETTLEMENT_PROMPT, Boolean.valueOf(settlementPrompt));
	}
	
	public static boolean isUseSettlementPrompt() {
		return config.getBoolean(USE_SETTLEMENT_PROMPT, Boolean.FALSE);
	}
	
	public static void setMiscItemDefaultTaxId(int id) {
		config.setProperty("mistitemdefaulttaxid", id); //$NON-NLS-1$
	}
	
	public static int getMiscItemDefaultTaxId() {
		return config.getInt("mistitemdefaulttaxid", -1); //$NON-NLS-1$
	}
	
	public static void setDrawerPortName(String drawerPortName) {
		config.setProperty("drawerPortName", drawerPortName); //$NON-NLS-1$
	}
	
	public static String getDrawerPortName() {
		return config.getString("drawerPortName", "/dev/usb/lp0"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public static void setDrawerControlCodes(String controlCode) {
		config.setProperty("controlCode", controlCode.replace(",", "\\,")); //$NON-NLS-1$
	}
	
	public static String getDrawerControlCodes() {
		return config.getString("controlCode", "27,112,0,25,250"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public static String getDefaultDrawerControlCodes() {
		return "27,112,0,25,250"; //$NON-NLS-1$
	}
	
	public static boolean isAutoSaveOpen() {
		return config.getBoolean(AUTOSAVEANDOPEN_TAKEOUT_TICKET, false);
	}
	
	public static void setAutoSaveOpen(boolean autosaveandopen) {
		config.setProperty(AUTOSAVEANDOPEN_TAKEOUT_TICKET, autosaveandopen);
	}
	

	public static boolean isAutoTerminalID() {
		return config.getBoolean(AUTOTERMINAL_ID, false);
	}
	
	public static void setAutoTerminalID(boolean autoterminalid) {
		config.setProperty(AUTOTERMINAL_ID, autoterminalid);
	}

	public static boolean isAutoPrintReceipt() {
		return config.getBoolean(AUTOPRINTRECEIPT, false);
	}
	
	public static void setAutoPrintReceipt(boolean autoprintreceipt) {
		config.setProperty(AUTOPRINTRECEIPT,autoprintreceipt);
	}
	
	
	public static char[] getDrawerControlCodesArray() {
		String drawerControlCodes = getDefaultDrawerControlCodes();
		if(StringUtils.isEmpty(drawerControlCodes)) {
			drawerControlCodes = getDefaultDrawerControlCodes();
		}
		
		String[] split = drawerControlCodes.split("\\,"); //$NON-NLS-1$
		char[] codes = new char[split.length];
		for (int i = 0; i < split.length; i++) {
			try {
				codes[i] = (char) Integer.parseInt(split[i]);
			} catch (Exception x) {
				codes[i] = '0';
			}
		}
		
		return codes;
	}
}
