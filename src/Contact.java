public record Contact(String name, String email) {

    public Contact {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    public Contact(String name) {
        this(name, "defaultname@gmail.com");
    }

    private static boolean isValidEmail(String email) {
        if (!email.contains("@")) {
            return false;
        }

        String domain = email.substring(email.indexOf("@"));
        return "@gmail.com".equals(domain);
    }

    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Contact contact1 = new Contact("Alice", "alice@gmail.com");
        contact1.sayHello();

        Contact contact2 = new Contact("Bob");
        contact2.sayHello();
    }
}
