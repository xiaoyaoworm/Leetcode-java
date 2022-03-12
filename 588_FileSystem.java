class FileSystem {
    private final Node root;
    public FileSystem() {
        root = Node.createDirectory("/");
    }
    
    public List<String> ls(String path) {
        Node cur = root;
        if(!path.equals("/")){
            String[] names = path.substring(1).split("/");
            for(String name: names){
                if(cur.getChild(name) == null) throw new IllegalArgumentException("directory "+name+" doesn't exist");
                cur = cur.getChild(name);
            }
        }
        if(!cur.isDirectory){
            return Arrays.asList(cur.name);
        } else{
            return cur.children.keySet().stream().sorted().collect(Collectors.toList());
        }
    }
    
    public void mkdir(String path) {
        Node cur = root;
        if(path.equals("/")) return;
        
        String[] names = path.substring(1).split("/");
        for(int i = 0; i < names.length-1; i++){
            Node child = cur.getChild(names[i]);
            if(child == null) {
                cur.addChild(Node.createDirectory(names[i]));
                child = cur.getChild(names[i]);
            } else if(!child.isDirectory){
                throw new IllegalArgumentException(child.name +" is a file, not a directory");
            }
            cur = child;
        }
        Node next = cur.getChild(names[names.length-1]);
        if(next == null) {
            cur.addChild(Node.createDirectory(names[names.length-1]));
        } else if(!next.isDirectory){
             throw new IllegalArgumentException(next.name +" is a file, cannot generate directory here");
        }
        //Do nothing because directory exists
    }
    
    public void addContentToFile(String filePath, String content) {
        Node cur = root;
        if(filePath.equals("/")) return;
        String[] names = filePath.substring(1).split("/");
        for(int i = 0; i < names.length-1; i++){
            Node child = cur.getChild(names[i]);
            if(child == null) {
                cur.addChild(Node.createDirectory(names[i]));
            } else if(!child.isDirectory){
                throw new IllegalArgumentException(child.name +" is a file, not a directory");
            }
            cur = child;
        }
        Node next = cur.getChild(names[names.length-1]);
        if(next == null) {
            cur.addChild(Node.createFile(names[names.length-1]));
            next = cur.getChild(names[names.length-1]);
            next.appendContent(content);
        } else if(next.isDirectory){
             throw new IllegalArgumentException(next.name +" is a directory, not a file");
        } else{
            next.appendContent(content);
        }
    }
    
    public String readContentFromFile(String filePath) {
        Node cur = root;
        if(filePath.equals("/")) return null;
        String[] names = filePath.substring(1).split("/");
        for(int i = 0; i < names.length-1; i++){
            Node child = cur.getChild(names[i]);
            if(child == null) {
                cur.addChild(Node.createDirectory(names[i]));
            } else if(!child.isDirectory){
                throw new IllegalArgumentException(child.name +" is a file, not a directory");
            }
            cur = child;
        }
        Node next = cur.getChild(names[names.length-1]);
        if(next == null) {
            return null;
        } else if(next.isDirectory){
             throw new IllegalArgumentException(next.name +" is a directory, not a file");
        } else{
            return next.content;
        }
    }
    
    private static class Node{
        String name;
        String content;
        boolean isDirectory;
        HashMap<String, Node> children;
        
        private Node(String name, String content, boolean isDirectory){
            this.name = name;
            this.content = content;
            this.isDirectory = isDirectory;
            this.children = isDirectory?new HashMap<String, Node>(): null;
        }
        
        static Node createFile(String name){
            return new Node(name, "", false);
        }
        
        static Node createDirectory(String name){
            return new Node(name, null, true);
        }
        
        public Node getChild(String name){
            if(children == null) return null;
            return children.get(name);
        }
        
        public void addChild(Node child){
            if(children != null) {
                children.put(child.name, child);
            }
        }
        
        public void appendContent(String content){
            if(content != null && !isDirectory){
                this.content += content;
            }
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */