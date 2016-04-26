package models;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Kev on 25/04/2016.
 */
public class PowerNumberTable {
        private int numCards = 13;
        private PowerNumber[][] table = new PowerNumber[numCards][numCards];
        private Context context;
        private TableLayout tableView;

        public PowerNumberTable(TableLayout tableView, Context context)
        {
            this.context = context;
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
            //Table[rowNumber, i] = PowerNumber.determinateValue(rowData[i]);
            TableLayout tbl = (TableLayout)tableView;
            tbl.addView(CreateRow(0, RowA));
            tbl.addView(CreateRow(1, RowK));
            tbl.addView(CreateRow(2, RowQ));
            tbl.addView(CreateRow(3, RowJ));
            tbl.addView(CreateRow(4, RowT));
            tbl.addView(CreateRow(5, Row9));
            tbl.addView(CreateRow(6, Row8));
            tbl.addView(CreateRow(7, Row7));
            tbl.addView(CreateRow(8, Row6));
            tbl.addView(CreateRow(9, Row5));
            tbl.addView(CreateRow(10, Row4));
            tbl.addView(CreateRow(11, Row3));
            tbl.addView(CreateRow(12, Row2));

            return tbl;
        }

        private TableRow CreateRow(int rowNumber, int[] rowData)
        {
            // declare a new row
            TableRow newRow = new TableRow(context);
            for (int i = 0; i <= 12; i++)
            {
                TextView txtView = new TextView(context);
                PowerNumber powerNumber = PowerNumber.determinateValue(rowData[i]);
                txtView.setText(String.valueOf(powerNumber.ToString()));
                // add views to the row
                newRow.addView(txtView);
            }
            // you would actually want to set properties on this before adding it
            // add the row to the table layout
            return newRow;
        }

       /*
           public static PowerNumber[,] CreateWeightTable()
            {
                return new PowerNumbersTable().Table;
            }
        */
    /*
        public static bool[,] CreateValidationTable(int powerNumber)
    {
        bool[,] table = new bool[13, 13];
        var powerNumberTable = new PowerNumbersTable();
        for (int row = 0; row < 13; row++)
        {
            for (int col = 0; col < 13; col++)
            {
                var currentValue = powerNumberTable.Table[row, col];
                table[row, col] = PowerNumber.GetIsValid(currentValue, powerNumber);
            }
        }

        return table;
    }
    */
}
