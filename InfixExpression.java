public class InfixExpression implements ExpressionNode {
    private char operator;
    ExpressionNode left, right;

    public InfixExpression(ExpressionNode left, char operator, ExpressionNode right) {
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        int l = this.left.eval();
        int r = this.right.eval();

        if (operator == '+') return l + r;
        if (operator == '-') return l - r;
        if (operator == '*') return l * r;
        if (operator == '/') return l / r;
        if (operator == '/') return l / r;
        if (operator == '^') return (int) Math.pow(l, r);

        return 0;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + operator + right.toString() + ")";
    }

    public void accept(ExpressionVisitor visitor) {
        visitor.visit(this);
    }

}
