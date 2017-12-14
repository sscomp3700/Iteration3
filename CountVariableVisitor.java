import java.util.*;

public class CountVariableVisitor implements ExpressionVisitor {

    Set<String> variables = new HashSet<String>();

    @Override
    public void visit(NumberNode node) {
        return;
    }

    @Override
    public void visit(VariableNode node) {
        variables.add(node.toString());     // add variable name!
    }

    @Override
    public void visit(InfixExpression expression) {
        expression.left.accept(this);
        expression.right.accept(this);
    }

    public int count() {
        return variables.size();
    }
}
