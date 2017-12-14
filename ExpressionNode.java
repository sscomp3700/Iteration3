public interface ExpressionNode {
    public int eval();

    public String toString();

    public void accept(ExpressionVisitor visitor);
}
