package vv.tp3;

import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTBlock;
import net.sourceforge.pmd.lang.java.ast.ASTForStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class DoubleForRule extends AbstractJavaRule {

    public Object visit(ASTForStatement node, Object data) {

        forBlock(node, node, data);

        return super.visit(node,data);
    }

    private void forBlock(Node node, Node original_node, Object data){
        int nb = node.jjtGetNumChildren();
        Node tmp;

        for (int i=0 ; i<nb ; i++) {
            if (node.jjtGetChild(i) instanceof ASTForStatement) {
                addViolation(data, original_node);
                break;
            } else {
                forBlock(node.jjtGetChild(i), original_node, data);
            }
        }
    }
}

