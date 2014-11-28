package vv.tp3;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.*;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class TestAnnotationRule extends AbstractJavaRule {
    boolean test;

    public Object visit(ASTClassOrInterfaceBody node, Object data) {
        if (node.hasDescendantOfType(ASTMethodDeclaration.class) && !node.hasDescendantOfType(ASTAnnotation.class)) {
            addViolation(data, node);
        }
        return super.visit(node,data);
    }

    public Object visit(ASTImportDeclaration node, Object data) {
        test = (node.getImportedName().equals("org.junit.Test"));
        return super.visit(node,data);
    }

}

