import java.util.LinkedList;

class Q592 {
    public String fractionAddition(String expression) {
        StringBuilder son = new StringBuilder(),parent = new StringBuilder();
        if (expression.startsWith("-")) {
            expression = expression.substring(1);
            son.append('-');
        }
        expression = expression + '+';
        boolean isAdd = true, hasSplit = false;
        char tmp;
        int upper=0, down=1;
        int s,p;
        for (int i=0; i<expression.length(); i++) {
            tmp = expression.charAt(i);
            if (tmp == '-' || tmp == '+') {
                s = Integer.parseInt(son.toString());
                p = Integer.parseInt(parent.toString());
                if (isAdd) {
                    upper = upper * p + down * s;
                } else {
                    upper = upper * p - down * s;
                }
                down *= p;
                son.setLength(0);
                parent.setLength(0);
                isAdd = tmp == '+';
                hasSplit = false;
            } else if (tmp == '/') {
                hasSplit = true;
            } else if (hasSplit) {
                parent.append(tmp);
            } else {
                son.append(tmp);
            }
        }
        LinkedList<Integer> divs = new LinkedList<Integer>() {
            {
                add(2);
                add(3);
                add(5);
                add(7);
            }
        };
        if (upper == 0) {
            return "0/1";
        }
        Integer div;
        while (!divs.isEmpty()) {
            div = divs.pop();
            while (upper % div == 0 && down % div == 0) {
                upper /= div;
                down /= div;
            }
        }
        return new StringBuilder().append(upper).append("/").append(down).toString();
    }
}