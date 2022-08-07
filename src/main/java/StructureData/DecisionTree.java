package StructureData;
public class DecisionTree {
    public class Node {
        private String question;
        private String answer;
        private DecisionTree yes;
        private DecisionTree no;
        public Node(String question) {
            this.question = question;
            answer =null;
        }
        public void addAnswer(String answer) {
            this.answer = answer;
        }
        public void addYes(DecisionTree yes) {
            this.yes = yes;
        }
        public void addNo(DecisionTree no) {
            this.no = no;
        }
        public boolean hadAnswer() {
            return answer != null;
        }
        public String getAnswer() {
            return answer;
        }

        public String getQuestion() {
            return question;
        }
        public DecisionTree getYes() {
            return yes;
        }
        public DecisionTree getNo() {
            return no;
        }
    }
    public Node root;

    public DecisionTree(String question) {
        root = new Node(question);
    }

    public int heightTree(Node node) {

        if (node == null)
            return -1;
        else
        {
            int lheight = heightTree(node.yes.root);
            int rheight = heightTree(node.no.root);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
    
}
