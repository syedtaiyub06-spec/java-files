class ThroneInheritance {
    private final String king;
    // Maps each parent to their children in order of birth
    private final Map<String, List<String>> familyTree;
    // Keeps track of deceased family members
    private final Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        // Initialize the king in the family tree
        familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child to the parent's list of children
        familyTree.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
        // Initialize the child's own potential branch in the tree
        familyTree.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        // Mark the person as deceased
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Start the Preorder DFS traversal from the King
        dfs(king, order);
        return order;
    }

    private void dfs(String currentPerson, List<String> order) {
        // 1. If the current person is alive, they are added to the order
        if (!dead.contains(currentPerson)) {
            order.add(currentPerson);
        }
        
        // 2. Recursively visit their children in birth order
        List<String> children = familyTree.get(currentPerson);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}