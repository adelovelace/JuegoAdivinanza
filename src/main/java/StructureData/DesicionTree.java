package StructureData;
public class DesicionTree {
    private class Node {
        private String question;
        private String answer;
        private Node yes;
        private Node no;
        public Node(String question) {
            this.question = question;
            answer =null;
        }
        public void addAnswer(String answer) {
            this.answer = answer;
        }
        public void addYes(Node yes) {
            this.yes = yes;
        }
        public void addNo(Node no) {
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
        public Node getYes() {
            return yes;
        }
        public Node getNo() {
            return no;
        }
    }
    public Node root;
    public DesicionTree(String question) {
        root = new Node(question);
    }
    
}
