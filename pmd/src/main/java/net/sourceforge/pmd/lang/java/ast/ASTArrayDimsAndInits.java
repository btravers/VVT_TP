/* Generated By:JJTree: Do not edit this line. ASTArrayDimsAndInits.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTArrayDimsAndInits extends AbstractJavaNode {
    public ASTArrayDimsAndInits(int id) {
        super(id);
    }

    public ASTArrayDimsAndInits(JavaParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
