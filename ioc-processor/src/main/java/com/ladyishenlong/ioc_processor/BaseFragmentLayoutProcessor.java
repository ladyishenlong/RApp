package com.ladyishenlong.ioc_processor;

import com.google.auto.service.AutoService;
import com.ladyishenlong.ioc_annotation.BaseFragmentLayout;
import com.ladyishenlong.ioc_processor.Base.BaseProcessor;

import java.util.Set;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("com.ladyishenlong.ioc_annotation.BaseFragmentLayout")
public class BaseFragmentLayoutProcessor extends BaseProcessor<BaseFragmentLayoutProxyInfo> {


    @Override
    protected void processAnnotation(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        printMessage("process BaseFragmentLayout ...");


        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BaseFragmentLayout.class);

        for (Element element : elements) {

            TypeElement typeElement = (TypeElement) element;

            String qualifiedName = typeElement.getQualifiedName().toString();

            BaseFragmentLayoutProxyInfo proxyInfo = proxyMap.get(qualifiedName);

            if (proxyInfo == null) {
                proxyInfo = new BaseFragmentLayoutProxyInfo(elementUtils, typeElement, "BaseFragmentLayoutInjector");
                proxyMap.put(qualifiedName, proxyInfo);
            }

            BaseFragmentLayout annotation = typeElement.getAnnotation(BaseFragmentLayout.class);

            if (annotation != null) {
                int layoutId = annotation.value();
                proxyInfo.injectElements.put(layoutId, typeElement);
            }

        }

    }


}
