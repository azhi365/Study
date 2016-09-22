package v2ch10.chart;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;

/**
 * A custom editor for the titlePosition property of the ChartBean. The editor lets the user choose
 * between Left, Center, and Right
 *
 * @author Cay Horstmann
 * @version 1.20 2007-12-14
 */
public class TitlePositionEditor extends PropertyEditorSupport {
    private String[] tags = {"Left", "Center", "Right"};

    public String[] getTags() {
        return tags;
    }

    public String getJavaInitializationString() {
        return ChartBean.Position.class.getName().replace('$', '.') + "." + getValue();
    }

    public String getAsText() {
        int index = ((ChartBean.Position) getValue()).ordinal();
        return tags[index];
    }

    public void setAsText(String s) {
        int index = Arrays.asList(tags).indexOf(s);
        if (index >= 0)
            setValue(ChartBean.Position.values()[index]);
    }
}
