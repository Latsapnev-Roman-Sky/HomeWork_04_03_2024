public class Main {
    public static void main(String[] args) {
        try {
            checkData("login!", "password", "password");
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }
    }
    public static void checkData(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Использованы недопустимые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Слищком длинный пароль");
        }
        if (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Использованы недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}