public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }


    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }


    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {
            hours.increment();
        }
        updateDisplay();
    }


    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }


    public String getTime()
    {
        return displayString;
    }


    private void updateDisplay()
    {
      int hour = hours.getValue();
      String suffix = "am";
      if(hour >= 12) {
        hour = hour - 12;
        suffix = "pm";
      }
      if(hour == 0) {
        hour = 12;
      }
      displayString = hour + "." + minutes.getDisplayValue() + suffix;
    }
}
