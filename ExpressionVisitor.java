public interface ExpressionVisitor {
    public void visit(InfixExpression expression);
    public void visit(NumberNode node);
    public void visit(VariableNode node);
}
