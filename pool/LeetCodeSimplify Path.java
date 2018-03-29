public class Solution {
    public String simplifyPath(String path) {
      //I assume the path is a legal path, although redundant
      Stack<String> sk = new Stack<String>();
      int i = 0;
      while(i < path.length()){
        //read out a token: /x or /
        int start = i;
        i++;
        while(i < path.length()){
          if(path.charAt(i) == '/') break;
          else i++;
        }
        String token = path.substring(start, i);
        //add valid token to stack
        if(isValid(token)) addToStack(sk, token);
      }
      //convert stack to String
      StringBuilder sb = new StringBuilder();
      while(!sk.isEmpty())
        sb.insert(0, sk.pop());
      //return result;
      return sb.length() == 0 ? "/" : sb.toString();
    }
    private boolean isValid(String token){
      int len = token.length();
      if(len <= 1) return false;
      else if(token.charAt(0) != '/') return false;
      else{
        for(int i = 1; i < len; i++){
          if(token.charAt(i) == '/') return false;
        }
      }
      return true;
    }
    private void addToStack(Stack<String> sk, String validToken){
      if(validToken.equals("/.")) return;
      else if(validToken.equals("/..")){
        if(sk.isEmpty()) return;
        else sk.pop();
      }else{
        sk.push(validToken);
      }
    }


}
