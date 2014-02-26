package com.calendar;

import java.util.ArrayList;
import java.util.Calendar;

import com.calendar.DateWidgetDayCell.OnItemClick;
import com.jiyuan.pmis.R;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DateLayout extends RelativeLayout {

	private ArrayList<DateWidgetDayCell>	days					= new ArrayList<DateWidgetDayCell>();
	private Calendar						calStartDate			= Calendar.getInstance();
	private Calendar						calToday				= Calendar.getInstance();
	private Calendar						calCalendar				= Calendar.getInstance();
	private Calendar						calSelected				= Calendar.getInstance();

	private LinearLayout					layContent				= null;
	
	private int								iFirstDayOfWeek			= Calendar.SUNDAY;
	private int								iMonthViewCurrentMonth	= 0;
	private int								iMonthViewCurrentYear	= 0;
	public static final int					SELECT_DATE_REQUEST		= 111;
	private static final int				iDayCellSize			= 38;
	private static final int				iDayHeaderHeight		= 34;
	private static final int				iDayCellHeight			= 34;
	private TextView						yearTextView, monthTextView;
	private int								mYear;
	private int								mMonth;
	private int								mDay;
	
	private Context context;
	private TextView tv;
	private PopupWindow pop;


	public DateLayout(Context context,View v,TextView tv){
		super(context);
		this.init(context,v);
		this.tv = tv;
	}
	public DateLayout(Context context, AttributeSet attrs,View v) {  
		super(context, attrs);  
		init(context,v);  
	}
	private void init(Context context,View v){
		this.context = context;
		iFirstDayOfWeek = Calendar.SUNDAY;
		mYear = calSelected.get(Calendar.YEAR);
		mMonth = calSelected.get(Calendar.MONTH);
		mDay = calSelected.get(Calendar.DAY_OF_MONTH);
		this.generateContentView(v);
		calStartDate = getCalendarStartDate();
		DateWidgetDayCell daySelected = updateCalendar();
		if (daySelected != null)
			daySelected.requestFocus();	
		this.setBackgroundColor(Color.parseColor("#b0000000"));
	}


	private LinearLayout createLayout(int iOrientation) {
		LinearLayout lay = new LinearLayout(this.context);
		lay.setLayoutParams(new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
		lay.setOrientation(iOrientation);
		return lay;
	}


	private void generateTopButtons(LinearLayout layTopControls) {

		yearTextView = new TextView(this.context);
		yearTextView.setText(mYear + "年");

		monthTextView = new TextView(this.context);
		monthTextView.setText(format(mMonth + 1) + "月");
		
		Button btnPrevMonth = new Button(this.context);
		btnPrevMonth.setBackgroundResource(R.drawable.prev_month);
		
		Button btnPrevYear = new Button(this.context);
		btnPrevYear.setBackgroundResource(R.drawable.prev_year);
		
		Button btnNextMonth = new Button(this.context);
		btnNextMonth.setBackgroundResource(R.drawable.next_month);
		
		Button btnNextYear = new Button(this.context);
		btnNextYear.setBackgroundResource(R.drawable.next_year);

		// set events
		btnPrevMonth.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				setPrevMonthViewItem();
			}
		});

		btnNextMonth.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				setNextMonthViewItem();
			}
		});
		
		btnPrevYear.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				setPrevYearViewItem();
			}
		});
		
		btnNextYear.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View arg0) {
				setNextYearViewItem();
			}
		});

		layTopControls.addView(btnPrevYear);
		layTopControls.addView(btnPrevMonth);
		layTopControls.addView(yearTextView);
		layTopControls.addView(monthTextView);
		layTopControls.addView(btnNextMonth);
		layTopControls.addView(btnNextYear);
	}


	private void generateContentView(View v) {
		LinearLayout layMain = createLayout(LinearLayout.VERTICAL);
		layMain.setPadding(8, 8, 8, 8);
		layMain.setGravity(Gravity.CENTER_HORIZONTAL);
		LinearLayout layTopControls = createLayout(LinearLayout.HORIZONTAL);
		layTopControls.setBackgroundResource(R.drawable.calendar_btn_bg);
		layTopControls.setLayoutParams(new LayoutParams(iDayCellSize * 7, LayoutParams.WRAP_CONTENT));
		layTopControls.setGravity(Gravity.CENTER);

		layContent = createLayout(LinearLayout.VERTICAL);
		layContent.setLayoutParams(new LayoutParams(iDayCellSize * 7, LayoutParams.WRAP_CONTENT));
		generateTopButtons(layTopControls);
		generateCalendar(layContent);
		layMain.addView(layTopControls);
		layMain.addView(layContent);
		this.addView(layMain);
		RelativeLayout.LayoutParams layoutParams = 
			    (RelativeLayout.LayoutParams)layMain.getLayoutParams();
			layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		
		layMain.setLayoutParams(layoutParams);
		pop = new PopupWindow(this,
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		pop.setBackgroundDrawable(new BitmapDrawable());
		pop.setOutsideTouchable(true);
		pop.setFocusable(true);
		pop.showAtLocation(v, Gravity.CENTER, 0, 0);
	}


	private View generateCalendarRow() {
		LinearLayout layRow = createLayout(LinearLayout.HORIZONTAL);
		for (int iDay = 0; iDay < 7; iDay++) {
			DateWidgetDayCell dayCell = new DateWidgetDayCell(this.context,
					iDayCellSize, iDayCellHeight);
			dayCell.setItemClick(mOnDayCellClick);
			days.add(dayCell);
			layRow.addView(dayCell);
		}
		return layRow;
	}


	private View generateCalendarHeader() {
		LinearLayout layRow = createLayout(LinearLayout.HORIZONTAL);
		for (int iDay = 0; iDay < 7; iDay++) {
			DateWidgetDayHeader day = new DateWidgetDayHeader(this.context,
					iDayCellSize, iDayHeaderHeight);
			final int iWeekDay = DayStyle.getWeekDay(iDay, iFirstDayOfWeek);
			day.setData(iWeekDay);
			layRow.addView(day);
		}
		return layRow;
	}


	private void generateCalendar(LinearLayout layContent) {
		layContent.addView(generateCalendarHeader());
		days.clear();
		for (int iRow = 0; iRow < 6; iRow++) {
			layContent.addView(generateCalendarRow());
		}
	}


	private Calendar getCalendarStartDate() {
		calToday.setTimeInMillis(System.currentTimeMillis());
		calToday.setFirstDayOfWeek(iFirstDayOfWeek);

		if (calSelected.getTimeInMillis() == 0) {
			calStartDate.setTimeInMillis(System.currentTimeMillis());
			calStartDate.setFirstDayOfWeek(iFirstDayOfWeek);
		} else {
			calStartDate.setTimeInMillis(calSelected.getTimeInMillis());
			calStartDate.setFirstDayOfWeek(iFirstDayOfWeek);
		}
		updateStartDateForMonth();

		return calStartDate;
	}


	private DateWidgetDayCell updateCalendar() {
		DateWidgetDayCell daySelected = null;
		boolean bSelected = false;
		final boolean bIsSelection = (calSelected.getTimeInMillis() != 0);
		final int iSelectedYear = calSelected.get(Calendar.YEAR);
		final int iSelectedMonth = calSelected.get(Calendar.MONTH);
		final int iSelectedDay = calSelected.get(Calendar.DAY_OF_MONTH);
		calCalendar.setTimeInMillis(calStartDate.getTimeInMillis());
		for (int i = 0; i < days.size(); i++) {
			final int iYear = calCalendar.get(Calendar.YEAR);
			final int iMonth = calCalendar.get(Calendar.MONTH);
			final int iDay = calCalendar.get(Calendar.DAY_OF_MONTH);
			final int iDayOfWeek = calCalendar.get(Calendar.DAY_OF_WEEK);
			DateWidgetDayCell dayCell = days.get(i);
			// check today
			boolean bToday = false;
			if (calToday.get(Calendar.YEAR) == iYear)
				if (calToday.get(Calendar.MONTH) == iMonth)
					if (calToday.get(Calendar.DAY_OF_MONTH) == iDay)
						bToday = true;
			// check holiday
			boolean bHoliday = false;
			if ((iDayOfWeek == Calendar.SATURDAY)
					|| (iDayOfWeek == Calendar.SUNDAY))
				bHoliday = true;
			if ((iMonth == Calendar.JANUARY) && (iDay == 1))
				bHoliday = true;

			dayCell.setData(iYear, iMonth, iDay, bToday, bHoliday,
					iMonthViewCurrentMonth, iDayOfWeek);
			bSelected = false;
			if (bIsSelection)
				if ((iSelectedDay == iDay) && (iSelectedMonth == iMonth)
						&& (iSelectedYear == iYear)) {
					bSelected = true;
				}
			dayCell.setSelected(bSelected);
			if (bSelected)
				daySelected = dayCell;
			calCalendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		layContent.invalidate();
		return daySelected;
	}


	private void updateStartDateForMonth() {
		iMonthViewCurrentMonth = calStartDate.get(Calendar.MONTH);
		iMonthViewCurrentYear = calStartDate.get(Calendar.YEAR);
		calStartDate.set(Calendar.DAY_OF_MONTH, 1);
		UpdateCurrentMonthDisplay();
		// update days for week
		int iDay = 0;
		int iStartDay = iFirstDayOfWeek;
		if (iStartDay == Calendar.MONDAY) {
			iDay = calStartDate.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
			if (iDay < 0)
				iDay = 6;
		}
		if (iStartDay == Calendar.SUNDAY) {
			iDay = calStartDate.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
			if (iDay < 0)
				iDay = 6;
		}
		calStartDate.add(Calendar.DAY_OF_WEEK, -iDay);
	}


	private void UpdateCurrentMonthDisplay() {
		mYear = calCalendar.get(Calendar.YEAR);
	}


	private void setPrevMonthViewItem() {
		iMonthViewCurrentMonth--;
		if (iMonthViewCurrentMonth == -1) {
			iMonthViewCurrentMonth = 11;
			iMonthViewCurrentYear--;
		}
		calStartDate.set(Calendar.DAY_OF_MONTH, 1);
		calStartDate.set(Calendar.MONTH, iMonthViewCurrentMonth);
		calStartDate.set(Calendar.YEAR, iMonthViewCurrentYear);
		updateDate();
		updateCenterTextView(iMonthViewCurrentMonth, iMonthViewCurrentYear);
	}


	private void setNextMonthViewItem() {
		iMonthViewCurrentMonth++;
		if (iMonthViewCurrentMonth == 12) {
			iMonthViewCurrentMonth = 0;
			iMonthViewCurrentYear++;
		}
		calStartDate.set(Calendar.DAY_OF_MONTH, 1);
		calStartDate.set(Calendar.MONTH, iMonthViewCurrentMonth);
		calStartDate.set(Calendar.YEAR, iMonthViewCurrentYear);
		updateDate();
		updateCenterTextView(iMonthViewCurrentMonth, iMonthViewCurrentYear);
	}
	

	private void setPrevYearViewItem() {
		iMonthViewCurrentYear--;
		calStartDate.set(Calendar.DAY_OF_MONTH, 1);
		calStartDate.set(Calendar.MONTH, iMonthViewCurrentMonth);
		calStartDate.set(Calendar.YEAR, iMonthViewCurrentYear);
		updateDate();
		updateCenterTextView(iMonthViewCurrentMonth, iMonthViewCurrentYear);
	}
	

	private void setNextYearViewItem() {
		iMonthViewCurrentYear++;
		calStartDate.set(Calendar.DAY_OF_MONTH, 1);
		calStartDate.set(Calendar.MONTH, iMonthViewCurrentMonth);
		calStartDate.set(Calendar.YEAR, iMonthViewCurrentYear);
		updateDate();
		updateCenterTextView(iMonthViewCurrentMonth, iMonthViewCurrentYear);
	}
	
	private OnItemClick	mOnDayCellClick	= new DateWidgetDayCell.OnItemClick() {
			
			public void OnClick(DateWidgetDayCell item) {
				calSelected.setTimeInMillis(item.getDate().getTimeInMillis());
				item.setSelected(true);
				updateCalendar();
				//Toast.makeText(context, org.apache.http.impl.cookie.DateUtils.formatDate(calSelected.getTime(), "yyyy-MM-dd"),
				//		Toast.LENGTH_SHORT).show();
				tv.setText(org.apache.http.impl.cookie.DateUtils.formatDate(calSelected.getTime(), "yyyy-MM-dd"));
				pop.dismiss();
			}
		};
	
	
	private void updateCenterTextView(int iMonthViewCurrentMonth, int iMonthViewCurrentYear) {
		yearTextView.setText(iMonthViewCurrentYear + "年");
		monthTextView.setText(format(iMonthViewCurrentMonth + 1) + "月");
	}
	

	private void updateDate() {
		updateStartDateForMonth();
		updateCalendar();
	}


	private String format(int x) {
		String s = "" + x;
		if (s.length() == 1)
			s = "0" + s;
		return s;
	}
}
