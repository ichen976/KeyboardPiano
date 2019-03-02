import javax.swing.JToggleButton;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;

public class KeyboardHook implements Runnable {

	KeyboardPiano kp;
	private HHOOK hhk = null;
	private LowLevelKeyboardProc keyboardProc = new KeyboardProc();
	private int type = 0;
	
	private static final int FLAG_ENTER_DOWN = 0;
	private static final int FLAG_ENTER_UP = FLAG_ENTER_DOWN + 128;
	private static final int FLAG_NUMPADENTER_DOWN = 1;
	private static final int FLAG_NUMPADENTER_UP = FLAG_NUMPADENTER_DOWN + 128;
	
	private static final int ALT_DOWN = 260;
	private static final int ALT_UP = 257;
	
	public KeyboardHook(KeyboardPiano kp) {
		this.kp = kp;
	}

	private class KeyboardProc implements LowLevelKeyboardProc {

		private int key = 0;
		private int flags = 0;
		
		@Override
		public LRESULT callback(int code, WPARAM wParam, KBDLLHOOKSTRUCT event) {
			if(code >= 0) {
				key = event.vkCode;
				type = Integer.parseInt(wParam.toString());
				System.out.println(type);
				flags = event.flags;
				switchKey(key, type);
				return new LRESULT(1); //KIA all keys
			}
			return User32.INSTANCE.CallNextHookEx(hhk, code, wParam, null);
		}
		
		public void switchKey(int key, int type) {
			switch(key) {
			case KeyboardPiano.VK_ESC :
				select(kp.tglbtnEsc, type);
				break;
			case KeyboardPiano.VK_F1 :
				select(kp.tglbtnF_1, type);
				break;
			case KeyboardPiano.VK_F2 :
				select(kp.tglbtnF_2, type);
				break;
			case KeyboardPiano.VK_F3 :
				select(kp.tglbtnF_3, type);
				break;
			case KeyboardPiano.VK_F4 :
				select(kp.tglbtnF_4, type);
				break;
			case KeyboardPiano.VK_F5 :
				select(kp.tglbtnF_5, type);
				break;
			case KeyboardPiano.VK_F6 :
				select(kp.tglbtnF_6, type);
				break;
			case KeyboardPiano.VK_F7 :
				select(kp.tglbtnF_7, type);
				 break;
			case KeyboardPiano.VK_F8 :
				select(kp.tglbtnF_8, type);
				 break;
			case KeyboardPiano.VK_F9 :
				select(kp.tglbtnF_9, type);
				 break;
			case KeyboardPiano.VK_F10 :
				select(kp.tglbtnF_10, type);
				 break;
			case KeyboardPiano.VK_F11 :
				select(kp.tglbtnF_11, type);
				 break;
			case KeyboardPiano.VK_F12 :
				select(kp.tglbtnF_12, type);
				break;
				
			case KeyboardPiano.VK_BACK_QUOTE :
				select(kp.tglbtnBackquote, type);
				break;
			case KeyboardPiano.VK_1 :
				select(kp.tglbtn_1, type);
				break;
			case KeyboardPiano.VK_2 :
				select(kp.tglbtn_2, type);
				break;
			case KeyboardPiano.VK_3 :
				select(kp.tglbtn_3, type);
				break;
			case KeyboardPiano.VK_4 :
				select(kp.tglbtn_4, type);
				break;
			case KeyboardPiano.VK_5 :
				select(kp.tglbtn_5, type);
				break;
			case KeyboardPiano.VK_6 :
				select(kp.tglbtn_6, type);
				break;
			case KeyboardPiano.VK_7 :
				select(kp.tglbtn_7, type);
				break;
			case KeyboardPiano.VK_8 :
				select(kp.tglbtn_8, type);
				break;
			case KeyboardPiano.VK_9 :
				select(kp.tglbtn_9, type);
				break;
			case KeyboardPiano.VK_0 :
				select(kp.tglbtn_0, type);
				break;
			case KeyboardPiano.VK_MINUS :
				select(kp.tglbtnMinus, type);
				break;
			case KeyboardPiano.VK_EQUALS :
				select(kp.tglbtnEquals, type);
				break;
			case KeyboardPiano.VK_BACKSPACE :
				select(kp.tglbtnBackspace, type);	
				break;
			case KeyboardPiano.VK_TAB :
				select(kp.tglbtnTab, type);
				break;
			case KeyboardPiano.VK_Q :
				select(kp.tglbtnQ, type);
				break;
			case KeyboardPiano.VK_W :
				select(kp.tglbtnW, type);
				break;
			case KeyboardPiano.VK_E :
				select(kp.tglbtnE, type);
				break;
			case KeyboardPiano.VK_R :
				select(kp.tglbtnR, type);
				break;
			case KeyboardPiano.VK_T :
				select(kp.tglbtnT, type);
				break;
			case KeyboardPiano.VK_Y :
				select(kp.tglbtnY, type);
				break;
			case KeyboardPiano.VK_U :
				select(kp.tglbtnU, type);
				break;
			case KeyboardPiano.VK_I :
				select(kp.tglbtnI, type);
				break;
			case KeyboardPiano.VK_O :
				select(kp.tglbtnO, type);
				break;
			case KeyboardPiano.VK_P :
				select(kp.tglbtnP, type);
				break;
			case KeyboardPiano.VK_OPEN_BRACKET :
				select(kp.tglbtnOpenbracket, type);
				break;
			case KeyboardPiano.VK_CLOSE_BRACKET :
				select(kp.tglbtnClosebracket, type);
				break;
			case KeyboardPiano.VK_BACKSLASH :
				select(kp.tglbtnBackslash, type);
				break;
				
			case KeyboardPiano.VK_CAPS_LOCK :
				select(kp.tglbtnCaps, type);
				break;
			case KeyboardPiano.VK_A :
				select(kp.tglbtnA, type);
				break;
			case KeyboardPiano.VK_S :
				select(kp.tglbtnS, type);
				break;
			case KeyboardPiano.VK_D :
				select(kp.tglbtnD, type);
				break;
			case KeyboardPiano.VK_F :
				select(kp.tglbtnF, type);
				break;
			case KeyboardPiano.VK_G :
				select(kp.tglbtnG, type);
				break;
			case KeyboardPiano.VK_H :
				select(kp.tglbtnH, type);
				break;
			case KeyboardPiano.VK_J :
				select(kp.tglbtnJ, type);
				break;
			case KeyboardPiano.VK_K :
				select(kp.tglbtnK, type);
				break;
			case KeyboardPiano.VK_L :
				select(kp.tglbtnL, type);
				break;
			case KeyboardPiano.VK_SEMICOLON :
				select(kp.tglbtnSemicolon, type);
				break;
			case KeyboardPiano.VK_QUOTE :
				select(kp.tglbtnQuote, type);
				break;

			case KeyboardPiano.VK_SHIFT_LEFT :
				select(kp.tglbtnShiftleft, type);
				break;
			case KeyboardPiano.VK_Z :
				select(kp.tglbtnZ, type);
				break;
			case KeyboardPiano.VK_X :
				select(kp.tglbtnX, type);
				break;
			case KeyboardPiano.VK_C :
				select(kp.tglbtnC, type);
				break;
			case KeyboardPiano.VK_V :
				select(kp.tglbtnV, type);
				break;
			case KeyboardPiano.VK_B :
				select(kp.tglbtnB, type);
				break;
			case KeyboardPiano.VK_N :
				select(kp.tglbtnN, type);
				break;
			case KeyboardPiano.VK_M :
				select(kp.tglbtnM, type);
				break;
			case KeyboardPiano.VK_COMMA :
				select(kp.tglbtnComma, type);
				break;
			case KeyboardPiano.VK_PERIOD :
				select(kp.tglbtnPeriod, type);
				break;
			case KeyboardPiano.VK_SLASH :
				select(kp.tglbtnSlash, type);
				break;
			case KeyboardPiano.VK_SHIFT_RIGHT :
				select(kp.tglbtnShiftright, type);
				break;
				
			case KeyboardPiano.VK_CTRL_LEFT :
				select(kp.tglbtnCtrlleft, type);
				break;
			case KeyboardPiano.VK_WIN_LEFT :
				select(kp.tglbtnWinleft, type);
				break;
			case KeyboardPiano.VK_SPACE :
				select(kp.tglbtnSpace, type);
				break;
			case KeyboardPiano.VK_WIN_RIGHT :
				select(kp.tglbtnWinright, type);
				break;
			case KeyboardPiano.VK_CTRL_RIGHT :
				select(kp.tglbtnCtrlright, type);
				break;
				
			case KeyboardPiano.VK_PRINT_SCREEN :
				select(kp.tglbtnPrtsc, type);
				break;
			case KeyboardPiano.VK_SCROLL_LOCK :
				select(kp.tglbtnScrlk, type);
				break;
			case KeyboardPiano.VK_PAUSE :
				select(kp.tglbtnPause, type);
				break;
				
			case KeyboardPiano.VK_INSERT :
				select(kp.tglbtnIns, type);
				break;
			case KeyboardPiano.VK_HOME :
				select(kp.tglbtnHome, type);
				break;
			case KeyboardPiano.VK_PAGE_UP :
				select(kp.tglbtnPgup, type);
				break;
			case KeyboardPiano.VK_DELETE :
				select(kp.tglbtnDel, type);
				break;
			case KeyboardPiano.VK_END :
				select(kp.tglbtnEnd, type);
				break;
			case KeyboardPiano.VK_PAGE_DOWN :
				select(kp.tglbtnPgdn, type);
				break;
				
			case KeyboardPiano.VK_UP :
				select(kp.tglbtnUp, type);
				break;
			case KeyboardPiano.VK_LEFT :
				select(kp.tglbtnLeft, type);
				break;
			case KeyboardPiano.VK_DOWN :
				select(kp.tglbtnDown, type);
				break;
			case KeyboardPiano.VK_RIGHT :
				select(kp.tglbtnRight, type);
				break;
				
			case KeyboardPiano.VK_NUM_LOCK :
				select(kp.tglbtnNum, type);
				break;
			case KeyboardPiano.VK_NUMPAD_DIVIDE :
				select(kp.tglbtnNumpaddivide, type);
				break;
			case KeyboardPiano.VK_NUMPAD_MULTIPLY :
				select(kp.tglbtnNumpadmultiply, type);
				break;
			case KeyboardPiano.VK_NUMPAD_MINUS :
				select(kp.tglbtnNumpadminus, type);
				break;
			case KeyboardPiano.VK_NUMPAD_7 :
				select(kp.tglbtnNumpad_7, type);
				break;
			case KeyboardPiano.VK_NUMPAD_8 :
				select(kp.tglbtnNumpad_8, type);
				break;
			case KeyboardPiano.VK_NUMPAD_9 :
				select(kp.tglbtnNumpad_9, type);
				break;
			case KeyboardPiano.VK_NUMPAD_4 :
				select(kp.tglbtnNumpad_4, type);
				break;
			case KeyboardPiano.VK_NUMPAD_5 :
				select(kp.tglbtnNumpad_5, type);
				break;
			case KeyboardPiano.VK_NUMPAD_6 :
				select(kp.tglbtnNumpad_6, type);
				break;
			case KeyboardPiano.VK_NUMPAD_1 :
				select(kp.tglbtnNumpad_1, type);
				break;
			case KeyboardPiano.VK_NUMPAD_2 :
				select(kp.tglbtnNumpad_2, type);
				break;
			case KeyboardPiano.VK_NUMPAD_3 :
				select(kp.tglbtnNumpad_3, type);
				break;
			case KeyboardPiano.VK_NUMPAD_0 :
				select(kp.tglbtnNumpad_0, type);
				break;
			case KeyboardPiano.VK_NUMPAD_DECIMAL :
				select(kp.tglbtnNumpaddecimal, type);
				break;
			case KeyboardPiano.VK_NUMPAD_PLUS :
				select(kp.tglbtnNumpadplus, type);
				break;
			
			/*
			 * special case
			 */
			case KeyboardPiano.VK_FN : //-1
				select(kp.tglbtnFn, type);
				break;
			case KeyboardPiano.VK_ENTER : //two case
				System.out.println(flags);
				if(flags == FLAG_ENTER_UP) {
					kp.tglbtnEnter.setSelected(false);	
				} else if(flags == FLAG_NUMPADENTER_UP) {
					kp.tglbtnNumpadenter.setSelected(false);
				} 
				if(flags == FLAG_ENTER_DOWN) {
					kp.tglbtnEnter.setSelected(true);	
				} else if(flags == FLAG_NUMPADENTER_DOWN) {
					kp.tglbtnNumpadenter.setSelected(true);
				}
				break;
			case KeyboardPiano.VK_ALT_LEFT :
				if(type == ALT_UP) {
					kp.tglbtnAltleft.setSelected(false);
				} else if(type == ALT_DOWN) {
					kp.tglbtnAltleft.setSelected(true);
				}
//System.out.println("ALT_LEFT");
				break;
			case KeyboardPiano.VK_ALT_RIGHT :
				if(type == ALT_UP) {
					kp.tglbtnAltright.setSelected(false);
				} else if(type == ALT_DOWN) {
					kp.tglbtnAltright.setSelected(true);
				}
//System.out.println("ALT_RIGHT");
				break;
			}
		}

 		public void select(JToggleButton jtb, int type) {
			if(type == KeyboardPiano.BUTTON_UP) {
				jtb.setSelected(false);
			} else if(type == KeyboardPiano.BUTTON_DOWN) {
				jtb.setSelected(true);
			}
		}
		
	}

	@Override
	public void run() {
		HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
		hhk = User32.INSTANCE.SetWindowsHookEx(User32.WH_KEYBOARD_LL, keyboardProc, hMod, 0);
		WinUser.MSG msg = new WinUser.MSG();
		while ((User32.INSTANCE.GetMessage(msg, null, 0, 0)) != 0) { }
	}

}