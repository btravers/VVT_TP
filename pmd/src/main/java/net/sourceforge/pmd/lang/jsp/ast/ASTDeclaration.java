/* Generated By:JJTree: Do not edit this line. ASTDeclaration.java */

package net.sourceforge.pmd.lang.jsp.ast;

public class ASTDeclaration extends AbstractJspNode {

/* BEGIN CUSTOM CODE */
    private String name;

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
/* END CUSTOM CODE */


    public ASTDeclaration(int id) {
        super(id);
    }

    public ASTDeclaration(JspParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JspParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
