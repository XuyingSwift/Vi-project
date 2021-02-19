import java.util.ArrayList;
import java.util.List;

public class Node<T, O> {
    private T data = null;

    private List<Node<T, O>> children = new ArrayList<>();

    private Node<T, O> parent = null;

    public Node(T data) {
        this.data = data;
    }

    public Node<T, O> addChild(Node<T, O> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T, O>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    public List<Node<T, O>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(Node<T, O> parent) {
        this.parent = parent;
    }

    public Node<T, O> getParent() {
        return parent;
    }


    private static <T> void printTree(Node<String, Object> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }

}
