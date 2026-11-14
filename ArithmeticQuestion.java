public class ArithmeticQuestion {
    private int a;
    private int b;
    private char sign;

    public ArithmeticQuestion(int a, int b, char sign) {
        this.a = a;
        this.b = b;
        if (sign == '+' || sign == '-' || sign == '*' || sign == '/') {
            this.sign = sign;
        } else {
            throw new IllegalArgumentException("The sign must be +, -, *, or /");
        }
    }

    public ArithmeticQuestion(int a, char sign, int b) {
        this.a = a;
        this.b = b;
        if (sign == '+' || sign == '-' || sign == '*' || sign == '/') {
            this.sign = sign;
        } else {
            throw new IllegalArgumentException("The sign must be +, -, *, or /");
        }
    }

    public int getAnswer() {
        switch (sign) {
            case '+':
                return this.a+this.b;
            case '-':
                return this.a-this.b;
            case '*':
                return this.a*this.b;
            case '/':
                return this.a/this.b;
            default:
                return 0;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char s) {
        if (s == '+' || s == '-' || s == '*' || s == '/') {
            this.sign = s;
        } else {
            throw new IllegalArgumentException("The sign must be +, -, *, or /");
        }
    }

    
}
