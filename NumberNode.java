public class NumberNode implements ExpressionNode {
    private int value;

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public NumberNode(int value) {
        this.value = value;
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }
}
