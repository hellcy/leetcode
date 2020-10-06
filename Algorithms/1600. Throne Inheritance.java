class ThroneInheritance {
    /*
        pre-order traverse a N-ary tree
        map store each node with their names
    */
    class Node {
        public boolean isAlive;
        public String name;
        public List<Node> children;
        
        public Node(boolean isAlive, String name) {
            this.isAlive = isAlive;
            this.name = name;
            this.children = new ArrayList<>();
        }
    }
    
    
    Map<String, Node> map;
    String rootName;
    public ThroneInheritance(String kingName) {
        map = new HashMap<>();
        Node root = new Node(true, kingName);
        map.put(kingName, root);
        rootName = kingName;
    }
    
    public void birth(String parentName, String childName) {
        if (!map.containsKey(parentName)) return;
        Node node = map.get(parentName);
        Node newnode = new Node(true, childName);
        map.put(childName, newnode);
        node.children.add(newnode);
    }
    
    public void death(String name) {
        if (!map.containsKey(name)) return;
        Node node = map.get(name);
        node.isAlive = false;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        Node root = map.get(rootName);
        helper(root, list);
        
        return list;
    }
    
    private void helper(Node node, List<String> list) {
        if (node.isAlive) list.add(node.name);
        for (Node child : node.children) {
            helper(child, list);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */