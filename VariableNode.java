public class VariableNode implements ExpressionNode {
    private String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int eval() {
        return Memory.getInstance().getValue(name);
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

}
