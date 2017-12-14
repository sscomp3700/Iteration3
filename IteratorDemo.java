import com.sun.tools.corba.se.idl.constExpr.Or;

public class IteratorDemo {


    public static Product find(int productID, Order order) {
        order.reset();
        while (order.hasNext()) {
            OrderLine line = order.next();
            if (line.getProduct().getProductID() == productID)
                return line.getProduct();
        }
        return null;
    }

    public static void main(String args[]) {
        Product apple = new Product(1, "Apple", 0.99, 100);
        Product orange = new Product(2, "Orange", 1.99, 100);

        OrderLine line1 = new OrderLine(apple, 10);
        OrderLine line2 = new OrderLine(orange, 20);

        Order order = new Order();
        order.addLine(line1);
        order.addLine(line2);

        order.setOrderID(1000);
        order.setCustomerName("John");

        double itemCount = 0;

        while (order.hasNext()) {
            OrderLine line = order.next();
            itemCount += line.getQuantity();
        }

        System.out.println("Amount of items: "  + (int) itemCount);

        order.reset();

        double totalCost = 0;

        while (order.hasNext()) {
            OrderLine line = order.next();
            totalCost += line.getCost();
        }

        System.out.println("Total cost of items: "  + totalCost);

        if (find(apple.getProductID(), order) != null)
            System.out.println("There is apple in the order!");

    }

}

/*


public interface ChannelIterator {
    public boolean hasNext();

    public void next();

    public String currentItem();
}

public class ConcreteTV {
    private ChannelIterator iterator;
    private List<String> channels;

    public ConcreteTV() {
        iterator = new ConcreteChannelIterator(channels);
    }

    public ChannelIterator getIterator() {
        return iterator;
    }
}

public interface ChannelIterator {
    private List<String> channels;
    private int currentPos = 0;

    public ChannelIterator(List<String> channels) {
        this.channels = channels;
    }

    public boolean hasNext() {
        if (currentPos + 1 < channels.size()) {
            return true;
        }
        return false;
    }

    public void next() {
        currentPos++;
    }

    public String currentItem() {
        return channels.get(currentPos);
    }
}

public class ConcreteTV {
    private ChannelIterator iterator;
    private List<String> channels;

    public ConcreteTV() {
        iterator = new ConcreteChannelIterator(channels);
    }

    public ChannelIterator getIterator() {
        return iterator;
    }
}


public interface Visitable {
    public void accept(Visitor visitor);
}

public class Book implements Visitable {
    private double price;
    private double weight;

    public void accept(Visitor vistor) {
        visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}

public interface Visitor {
    public void visit(Book book);

    public void visit(CD cd);

    public void visit(DVD dvd);
}

public class PostageVisitor implements Visitor {
    private double totalPostageForCart; //collect data about the book

    public void visit(Book book) { //assume we have a calculation here related to weight and price //free postage for a book over 10
        if (book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    } //add other visitors here

    public void visit(CD cd) {...}

    public void visit(DVD dvd) {...}

    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

public class ShoppingCart { //normal shopping cart stuff
    private ArrayList<Visitable> items;

    public double calculatePostage() { //create a visitor
        PostageVisitor visitor = new PostageVisitor(); //iterate through all items
        for (Visitable item : items) {
            item.accept(visitor);
        }
        double postage = visitor.getTotalPostage();
        return postage;
    }
}

*/