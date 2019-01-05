package IOCplus;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
    private final List<PropertyValue> pvList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.pvList.add(pv);
    }

    public List<PropertyValue> getPvList() {
        return pvList;
    }
}
