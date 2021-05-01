package test;

public enum MediaType {
        ONCE (true),
    TWICE(false);
        private MediaType(boolean b) {
            System. out .println("constructing");
        }
        public static void main(String[] args) {
            MediaType firstCall = MediaType. ONCE ; // prints constructing
            MediaType secondCall = MediaType. TWICE ; // doesn't print anything
            MediaType thirdCall = MediaType. TWICE ;
        }
}

