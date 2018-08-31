package com.ladyishenlong.ioc_processor;

import com.google.auto.service.AutoService;
import com.ladyishenlong.ioc_annotation.BaseActivityLayout;
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
@SupportedSourceVersion(SourceVersion.RELEASE_7)    //支持的源码版本
@SupportedAnnotationTypes("com.ladyishenlong.ioc_annotation.BaseActivityLayout")//注解位置
public class BaseActivityLayoutProcessor extends BaseProcessor<BaseActivityLayoutProxyInfo> {


    @Override
    protected void processAnnotation(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        printMessage("process BaseActivityLayout...");

        //获取所有 有注解的元素
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BaseActivityLayout.class);

        for (Element element : elements) {

            TypeElement typeElement = (TypeElement) element;//该元素是一个类
            String qualifiedName = typeElement.getQualifiedName().toString();
            BaseActivityLayoutProxyInfo proxyInfo = proxyMap.get(qualifiedName);

            if (proxyInfo == null) {
                proxyInfo = new BaseActivityLayoutProxyInfo(elementUtils, typeElement, "BaseActivityLayoutInjector");
                proxyMap.put(qualifiedName, proxyInfo);
            }

            BaseActivityLayout annotation = typeElement.getAnnotation(BaseActivityLayout.class);

            if (annotation != null) {
                int layoutId = annotation.value();
                proxyInfo.injectElements.put(layoutId, typeElement);
            }

        }

    }

}
