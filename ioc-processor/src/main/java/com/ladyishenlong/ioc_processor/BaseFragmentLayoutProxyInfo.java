package com.ladyishenlong.ioc_processor;

import com.ladyishenlong.ioc_processor.Base.BaseProxyInfo;

import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class BaseFragmentLayoutProxyInfo extends BaseProxyInfo {

    //fragment的layoutId 和该 fragment
    public Map<Integer, TypeElement> injectElements;

    public BaseFragmentLayoutProxyInfo(Elements elementUtils, TypeElement typeElement, String SUFFIX) {
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
            stringBuilder.append("" +
                    "    @Override\n" +
                    "    public void inject("+typeElement.getQualifiedName() +" fragment, View baseFragmentLayout) {\n" +
                    "                View view = fragment.getLayoutInflater().inflate(" + layoutId + ",null);\n" +
                    "                RelativeLayout relativeLayout =(RelativeLayout)baseFragmentLayout;\n" +
                    "                relativeLayout.addView(view);\n" +
                    "        \n" +
                    "    }");
        }


    }
}
