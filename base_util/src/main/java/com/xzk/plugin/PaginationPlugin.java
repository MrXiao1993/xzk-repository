//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.xzk.plugin;

import java.util.List;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class PaginationPlugin extends PluginAdapter {
    public PaginationPlugin() {
    }

    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("com.xzk.util.Page"));
        CommentGenerator commentGenerator = this.context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("com.xzk.util.Page"));
        field.setName("page");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = "page".charAt(0);
        String camel = Character.toUpperCase(c) + "page".substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("com.xzk.util.Page"), "page"));
        method.addBodyLine("this." + "page" + "=" + "page" + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("com.xzk.util.Page"));
        method.setName("get" + camel);
        method.addBodyLine("return " + "page" + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement element_ = new XmlElement("if");
        element_.addAttribute(new Attribute("test", "page != null"));
        element_.addElement(new TextElement("limit #{page.begin} , #{page.length}"));
        element.addElement(element_);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }


    public boolean validate(List<String> warnings) {
        return true;
    }
}
