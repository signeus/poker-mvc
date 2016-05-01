package models;

import com.apps.kev.pokermvc.R;

import android.content.Context;
import android.content.Context.*;


/**
 * Created by Kev on 30/04/2016.
 */
public class Messages {
    private String msg = "";
    private String[] fields = {""};
    private String actionError = "";

    private Context ctx;

    //Errors Code
    static final String  lowerThan = "LowerThan";
    static final String  isRequired = "IsRequired";
    static final String  somethingIsHasFailed = "SomethingIsHasFailed";
    static final String  notIntegerNumber = "NotIntegerNumber";

    public String messageError(String[] fields, String actionError, Context ctx){
        if(fields != null)
            this.fields = fields;
        this.actionError = actionError;
        this.ctx = ctx;
        switch (actionError){
            case isRequired :{
                msg = fields[0] + ctx.getResources().getString(R.string.IsRequired);
                return msg;
            }
            case lowerThan :{
                msg = fields[0] + ctx.getResources().getString(R.string.LowerThan) + fields[1];
                return msg;
            }
            case notIntegerNumber :{
                return ctx.getResources().getString(R.string.NotIntegerNumber);
            }

            case somethingIsHasFailed :{
                return ctx.getResources().getString(R.string.SomethingIsHasFailed);
            }
        }
        return "";
    }

    public static String getErrorLowerThan() {
        return lowerThan;
    }

    public static String getErrorIsRequired() {
        return isRequired;
    }

    public static String getErrorSomethingIsHasFailed() {
        return somethingIsHasFailed;
    }

}
