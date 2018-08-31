package com.ladyishenlong.ioc_processor;

import com.ladyishenlong.ioc_processor.Base.BaseProxyInfo;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class BaseActivityLayoutProxyInfo extends BaseProxyInfo {

    //存放baseActivity子类布局的ID 以及该子类
    public Map<Integer, TypeElement> injectElements;


    public BaseActivityLayoutProxyInfo(Elements elementUtils, TypeElement typeElement, String SUFFIX) {
        super(elementUtils, typeElement, SUFFIX);

        injectElements = new HashMap<>();
    }

    @Override
    protected void importFile(StringBuilder stringBuilder) {
        super.importFile(stringBuilder);
        stringBuilder.append("import android.view.View;\n")
                .append("import android.widget.RelativeLayout;\n");
    }

    @Override
    protected void generateMethod(StringBuilder stringBuilder) {

        for (Integer layoutId : injectElements.keySet()) {
            stringBuilder.append("    @Override\n" +
                    "    public void inject(" + typeElement.getQualifiedName() + " activity,  View baseLayout) {\n" +
                    "        View view = activity.getLayoutInflater().inflate(" + layoutId + ", null);\n" +
                    "        RelativeLayout relativeLayout=(RelativeLayout)baseLayout; \n"+
                    "        relativeLayout.addView(view);\n"+
                    "    }");
        }


    }


}
