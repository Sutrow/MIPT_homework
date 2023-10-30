class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

class Auth {
    public static boolean checkAuth(String login, String password, String confirmPassword) {
        try {
            if (login == null || login.length() >= 20 || !login.matches("\\w+")) {
                throw new WrongLoginException("Неправильный логин");
            }

            if (password == null || confirmPassword == null || !password.equals(confirmPassword)
                    || password.length() >= 20 || !password.matches("\\w+")) {
                throw new WrongPasswordException("Неправильный пароль");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAuth("user1", "password1", "password1")); // true
        System.out.println(checkAuth("user1$", "password1", "password1")); // false
        System.out.println(checkAuth("user1", "password1", "password2")); // false
    }
}
