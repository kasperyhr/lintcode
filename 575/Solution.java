public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        
        Stack<Object> stack = new Stack<>();
        int num = 0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                continue;
            }
            
            if(c == '['){
                stack.push(Integer.valueOf(num));
                num = 0;
                continue;
            }
            
            if(c == ']'){
                String newStr = popStack(stack);
                Integer cnt = (Integer) stack.pop();
                for(int i = 0; i < cnt; i++){
                    stack.push(newStr);
                }
                continue;
            }
            
            stack.push(String.valueOf(c));
        }
        return popStack(stack);
    }
    
    private String popStack(Stack<Object> stack){
        Stack<String> buffer = new Stack<>();
        while(!stack.isEmpty() && (stack.peek() instanceof String)){
            buffer.push((String) stack.pop());
        }
        
        StringBuffer sb = new StringBuffer();
        while(!buffer.isEmpty()){
            sb.append(buffer.pop());
        }
        
        return sb.toString();
    }
}