package models;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.apps.kev.pokermvc.R;

/**
 * Created by Kev on 25/04/2016.
 */
public class PowerNumberTable {
        private int numCards = 13;
        private PowerNumber[][] table = new PowerNumber[numCards][numCards];
        private Context context;
        private TableLayout tableView;
        private ResultStat resultStat;

        public PowerNumberTable(TableLayout tableView, Context context, ResultStat resultStat)
        {
            this.context = context;
            this.resultStat = resultStat;
            this.tableView = generateTable(tableView);
        }

        public TableLayout getTableView() {
            return tableView;
        }

        private int[] RowA = { 100, 100, 100, 100, 100, 50, 37, 32, 28, 31, 27, 26, 24 };
        private int[] RowK = { 100, 100, 100, 75, 66, 44, 17, 15, 14, 13, 11, 10, 9 };
        private int[] RowQ = { 100, 48, 100, 75, 58, 38, 16, 11, 10, 8, 8, 8, 8 };
        private int[] RowJ = { 50, 31, 26, 100, 58, 39, 21, 12, 7, 7, 7, 7, 5 };
        private int[] RowT = { 36, 19, 17, 22, 100, 43, 26, 15, 10, 9, 7, 5, 4 };
        private int[] Row9 = { 27, 12, 9, 9, 11, 100, 31, 17, 10, 9, 3, 2, 0 };
        private int[] Row8 = { 24, 10, 8, 8, 10, 10, 66, 19, 15, 10, 9, 0, 0 };
        private int[] Row7 = { 22, 9, 6, 5, 6, 7, 10, 58, 15, 10, 9, 0, 0 };
        private int[] Row6 = { 18, 9, 6, 4, 3, 3, 4, 7, 51, 11, 10, 4, 0 };
        private int[] Row5 = { 21, 9, 6, 4, 0, 0, 0, 0, 0, 44, 11, 8, 0 };
        private int[] Row4 = { 18, 8, 5, 3, 0, 0, 0, 0, 0, 0, 39, 6, 0 };
        private int[] Row3 = { 16, 8, 5, 3, 0, 0, 0, 0, 0, 0, 0, 33, 0 };
        private int[] Row2 = { 15, 7, 4, 3, 0, 0, 0, 0, 0, 0, 0, 0, 28 };

        private TableLayout generateTable(TableLayout tableView)
        {
            TableLayout tbl = (TableLayout)tableView;
            tbl.addView(CreateHeader(13,true,false));
            tbl.addView(CreateRow(1, RowA));
            tbl.addView(CreateRow(13, RowK));
            tbl.addView(CreateRow(12, RowQ));
            tbl.addView(CreateRow(11, RowJ));
            tbl.addView(CreateRow(10, RowT));
            tbl.addView(CreateRow(9, Row9));
            tbl.addView(CreateRow(8, Row8));
            tbl.addView(CreateRow(7, Row7));
            tbl.addView(CreateRow(6, Row6));
            tbl.addView(CreateRow(5, Row5));
            tbl.addView(CreateRow(4, Row4));
            tbl.addView(CreateRow(3, Row3));
            tbl.addView(CreateRow(2, Row2));

            return tbl;
        }

        private TableRow CreateRow(int rowNumber, int[] rowData)
        {
            // declare a new row
            TableRow newRow = new TableRow(context);
            //Initial Column to Header
            TextView txtViewMargin = new TextView(context);
            txtViewMargin.setGravity(Gravity.CENTER);
            txtViewMargin.setTextColor(ContextCompat.getColor(context, R.color.white));
            txtViewMargin.setText(String.valueOf(Card.toString(rowNumber)));
            // add views to the row
            newRow.setBackgroundColor(ContextCompat.getColor(context, R.color.darkGrey));
            newRow.addView(txtViewMargin);
            //bucle for columns
            for (int i = 0; i <= 12; i++)
            {
                TextView txtView = new TextView(context);
                txtView.setTextColor(ContextCompat.getColor(context, R.color.white));
                txtView.setBackgroundColor(addColorToResult(resultStat.getIntPN(),PowerNumber.determinateValue(rowData[i]).getValue()));
                txtView.setGravity(Gravity.CENTER);
                txtView.setPadding(5,5,5,5);
                PowerNumber powerNumber = PowerNumber.determinateValue(rowData[i]);
                txtView.setText(String.valueOf(powerNumber.ToString()));
                // add views to the row
                newRow.addView(txtView);
            }

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setMinimumWidth(1);
            linearLayout.setMinimumHeight(5);

            // add the row to the table layout
            return newRow;
        }

    private int addColorToResult(int currentValue, int weight){
        PowerNumber powerNumber = new PowerNumber(currentValue);
        int color = ContextCompat.getColor(context, R.color.black);
        boolean isValid = powerNumber.getIsValid(powerNumber, weight);
        if(isValid)
            color = ContextCompat.getColor(context, R.color.darkGreen);
        if(!isValid)
            color = ContextCompat.getColor(context, R.color.darkRed);
        return color;
    }

    private TableRow CreateHeader(int fields, boolean withFirst, boolean withLast)
    {
        TableRow newRow = new TableRow(context);
        if(withFirst)
        {
            TextView txtViewMargin = new TextView(context);
            txtViewMargin.setGravity(Gravity.CENTER);
            txtViewMargin.setTextColor(ContextCompat.getColor(context, R.color.white));
            txtViewMargin.setText(" ");
            newRow.addView(txtViewMargin);
        }
        for (int i = 1; i <= fields; i++)
        {
            TextView txtView = new TextView(context);
            txtView.setTextColor(ContextCompat.getColor(context, R.color.white));
            txtView.setBackgroundColor(ContextCompat.getColor(context, R.color.darkGrey));
            txtView.setGravity(Gravity.CENTER);
            txtView.setPadding(5,5,5,5);
            txtView.setText(String.valueOf(Card.toString(i)));
            newRow.addView(txtView);
        }
        if(withLast)
        {
            TextView txtViewMargin = new TextView(context);
            txtViewMargin.setGravity(Gravity.CENTER);
            txtViewMargin.setTextColor(ContextCompat.getColor(context, R.color.black));
            txtViewMargin.setText(" ");
            newRow.addView(txtViewMargin);
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setMinimumWidth(1);
        linearLayout.setMinimumHeight(5);

        newRow.setBackgroundColor(ContextCompat.getColor(context, R.color.black));
        return newRow;
    }

}
