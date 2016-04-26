package models;

/**
 * Created by Kev on 25/04/2016.
 */
public class PowerNumber {
        private boolean isPlus;
        private boolean isNegative;
        private int value;
        private String errLine;

        public PowerNumber(int value)
        {
            this.value = value;
        }
        ///Summary
        //This constructor is used by to positive or negative, where you pass a null and other boolean.
        public PowerNumber(boolean isPlus, boolean isNegative)
        {
            if(isPlus == true && isNegative == false){
                this.isPlus = isPlus;
            }
            if(isPlus == false && isNegative == true){
                this.isNegative = isNegative;
            }
            if((isPlus && isNegative) || (!isPlus && !isNegative))
                setErrLine("That is not permitted...");
        }
        public boolean getIsPlus()
        {
            return isPlus;
        }
        public void setIsPlus(boolean isPlus)
        {
            this.isPlus = true;
        }
        public boolean getIsNegative()
        {
            return isNegative;
        }
        public void setIsNegative(boolean isNegative)
        {
            this.isNegative = true;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public String getErrLine() {
            return errLine;
        }
        public void setErrLine(String errLine) {
            this.errLine = errLine;
        }

        public static PowerNumber determinateValue(int value)
        {
            if (value == 100)
                return new PowerNumber(true, false);

            if (value == 0)
                return new PowerNumber(false, true);

            return new PowerNumber(value);
        }

        public boolean getIsValid(PowerNumber currentValue, int weight)
        {
            if (currentValue.getIsPlus())
                return true;

            if (currentValue.getIsNegative())
                return false;

            if (currentValue.getValue() > weight)
                return true;

            return false;
        }

        public String ToString()
        {
            if (this.isPlus)
                return "+";

            if (this.isNegative)
                return "-";

            return String.valueOf(this.getValue());
        }
}
